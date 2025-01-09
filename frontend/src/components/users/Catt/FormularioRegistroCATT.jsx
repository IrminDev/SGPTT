import React from 'react'
import { useState } from 'react';
import Button from '../../common/Button';
import Input from '../../common/Input';
import registerService from '../../../services/register.service';

const FormularioRegistroCATT = () => {
    const [name, setName] = useState("");
    const [lastname, setLastname] = useState("");
    const [motherLastname, setMotherLastname] = useState("");
    const [password, setPassword] = useState("");
    const [number, setNumber] = useState("");
    const [role, setRole] = useState("");
    const [email, setEmail] = useState("");

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

    const handleRoleChange = (e) => {
        setRole(e.target.value);
    }

    const handleSubmit = (e) => {
        const data = {
            person: {
                type: "catt",
                name,
                paternalSurname: lastname,
                maternalSurname: motherLastname,
                number,
                role,
            },
            email: email,
            password: password,
        }

        console.log("Data:", data);

        registerService.registerUser(data).then((response) => {
            setName("");
            setLastname("");
            setMotherLastname("");
            setNumber("");
            setRole("");
            setEmail("");
            setPassword("");

            console.log(response);
        }).catch((error) => {
            console.error('Error registering user:', error);
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
              Registro de integrante de la CATT
            </h2>
            {/* Formulario de registro */}
            <form className="space-y-4">
              <Input onChange={handleNameChange} value={name} label="Nombre(s)" type="text" placeholder="Nombre(s)" required />
              <Input onChange={handleLastnameChange} value={lastname} label="Apellido paterno" type="text" placeholder="Apellido paterno" required />
              <Input onChange={handleMotherLastnameChange} value={motherLastname} label="Apellido materno" type="text" placeholder="Apellido materno" required />
              <Input onChange={handleNumberChange} value={number} label="Número de empleado" type="text" placeholder="Número de empleado" required />
              <div>
                <label className="block text-white text-sm font-bold mb-2">Rol</label>
                <Input
                    type="option"
                    options={[
                      { value: "ADMINISTRATOR", label: "Presidente" },
                      { value: "SECRETARY", label: "Secretario técnico" },
                      { value: "COORDINATOR", label: "Secretario ejecutivo" },
                      { value: "ASSISTANT", label: "Jefe de departamento académico" },
                    ]}
                    defaultValue=""
                    onChange={handleRoleChange}
                    value={role}
                    required
                />
              </div>
                <Input onChange={handleEmailChange} value={email} label="Correo electrónico" type="email" placeholder="Correo electrónico" required />

                <Input onChange={handlePasswordChange} value={password} label="Contraseña" type="password" placeholder="Contraseña" required />
        
                <Button onClick={handleSubmit} label="Registrar" className="bg-teal-500 hover:bg-teal-700" />

                
            </form>
          </div>
        </div>
    );
}

export default FormularioRegistroCATT
