import React from 'react'
import { useState } from 'react';
import Button from '../../common/Button';
import Input from '../../common/Input';
import registerService from '../../../services/register.service';
import { toast } from 'react-toastify';


const FormularioRegistroProfesor = () => {
    const [name, setName] = useState("");
    const [lastname, setLastname] = useState("");
    const [motherLastname, setMotherLastname] = useState("");
    const [password, setPassword] = useState("");
    const [number, setNumber] = useState("");
    const [academy, setAcademy] = useState("");
    const [email, setEmail] = useState("");
    const [school, setSchool] = useState("");

    const handleNameChange = (e) => {
        setName(e.target.value);
    }

    const handleLastnameChange = (e) => {
        setLastname(e.target.value);
    }

    const handleMotherLastnameChange = (e) => {
        setMotherLastname(e.target.value);
    }

    const handlePasswordChange = (e) => {
        setPassword(e.target.value);
    }

    const handleNumberChange = (e) => {
        setNumber(e.target.value);
    }

    const handleEmailChange = (e) => {
        setEmail(e.target.value);
    }

    const handleAcademyChange = (e) => {
        setAcademy(e.target.value);
    }

    const handleSchoolChange = (e) => {
        setSchool(e.target.value);
    }


    const handleSubmit = (e) => {
        // Check if all the fields are filled
        if (!name || !lastname || !motherLastname || !password || !number || !role || !email) {
            toast.error("Por favor llena todos los campos");
            return;
        }

        // Check if the number has a length of 10
        if (number.length !== 10) {
            toast.error("El número de empleado debe tener 10 dígitos");
            return;
        }

        const data = {
            person: {
                type: "professor",
                name,
                paternalSurname: lastname,
                maternalSurname: motherLastname,
                number,
                academyName: academy,
                school,
            },
            email: email,
            password: password,
        }

        registerService.registerUser(data).then((response) => {
            setName("");
            setLastname("");
            setMotherLastname("");
            setNumber("");
            setAcademy("");
            setEmail("");
            setPassword("");
            setSchool("");
            toast.success("Profesor registrado exitosamente");
            console.log(response)
        }).catch((error) => {
            toast.error("Error al registrar profesor");
            console.log("Error registrando profesor:", error);
        })
    }

    return (
        <div className="flex flex-col md:flex-row">
          {/* Imagen representativa, oculta en pantallas pequeñas */}
          <div className="w-full md:w-1/2 hidden md:block">
            <img
              src="http://placekittens.com/600/800"
              alt="Imagen representativa"
              className="object-cover h-full w-full"
            />
          </div>
          {/* Contenedor del formulario */}
          <div className="w-full md:w-1/2 p-6 md:p-6 sm:px-4">
            {/* Título del formulario */}
            <h2 className="text-2xl font-bold text-center text-yellow-300 mb-6">
              Registro de profesor
            </h2>
            {/* Formulario de registro */}
            <form className="space-y-4">
              <Input onChange={handleNameChange} value={name} label="Nombre(s)" type="text" placeholder="Nombre(s)" required />
              <Input onChange={handleLastnameChange} value={lastname} label="Apellido paterno" type="text" placeholder="Apellido paterno" required />
              <Input onChange={handleMotherLastnameChange} value={motherLastname} label="Apellido materno" type="text" placeholder="Apellido materno" required />
              <Input onChange={handleNumberChange} value={number} label="Número de empleado" type="text" placeholder="Número de empleado" required />
              <div>
                <label className="block text-white text-sm font-bold mb-2">Academia</label>
                <Input
                    type="option"
                    options={[
                        { value: "Sistemas computacionales", label: "Sistemas computacionales" },
                        { value: "Sistemas digitales", label: "Sistemas digitales" },
                        { value: "Ingeniería de software", label: "Ingeniería de software" },
                        { value: "Bases de datos y tecnologías web", label: "Bases de datos y tecnologías web" },
                        { value: "Inteligencia artificial", label: "Inteligencia artificial" },
                        { value: "Ciencias sociales", label: "Ciencias sociales" },
                        { value: "Redes y telecomunicaciones", label: "Redes y telecomunicaciones" },
                        { value: "Ciencias básicas", label: "Ciencias básicas" },
                    ]}
                    defaultValue=""
                    value={academy}
                    onChange={handleAcademyChange}
                    required
                />
              </div>
                <Input onChange={handleEmailChange} value={email} label="Correo electrónico" type="email" placeholder="Correo electrónico" required />

                <Input onChange={handlePasswordChange} value={password} label="Contraseña" type="password" placeholder="Contraseña" required />

                <Input onChange={handleSchoolChange} value={school} label="Escuela" type="text" placeholder="Escuela" required />
        
                <Button onClick={handleSubmit} label="Registrar" className="bg-teal-500 hover:bg-teal-700" />
            </form>
          </div>
        </div>
    );
}

export default FormularioRegistroProfesor
