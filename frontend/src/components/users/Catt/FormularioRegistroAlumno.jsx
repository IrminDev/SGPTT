import React from 'react'
import { useState } from 'react';
import Button from '../../common/Button';
import Input from '../../common/Input';

const FormularioRegistroAlumno = () => {
    const [name, setName] = useState("");
    const [lastname, setLastname] = useState("");
    const [motherLastname, setMotherLastname] = useState("");
    const [password, setPassword] = useState("");
    const [number, setNumber] = useState("");
    const [career, setCareer] = useState("");
    const [email, setEmail] = useState("");
    const [isIrregular, setIsIrregular] = useState(false);

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

    const handleCareerChange = (e) => {
        setCareer(e.target.value);
    }

    const handleEmailChange = (e) => {
        setEmail(e.target.value);
    }

    const handleIsIrregularChange = (state) => {
        setIsIrregular(state);
    }

    const handleSubmit = (e) => {
        const data = {
            person: {
                type: "student",
                name,
                paternalSurname: lastname,
                maternalSurname: motherLastname,
                number,
                career,
                isIrregular,
            },
            email: email,
            password: password,
        }

        console.log(data);
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
              Registro de alumno
            </h2>
            {/* Formulario de registro */}
            <form className="space-y-4">
              <Input onChange={handleNameChange} label="Nombre(s)" type="text" placeholder="Nombre(s)" required />
              <Input onChange={handleLastnameChange} label="Apellido paterno" type="text" placeholder="Apellido paterno" required />
                <Input onChange={handleMotherLastnameChange} label="Apellido materno" type="text" placeholder="Apellido materno" required />
              <Input onChange={handleNumberChange} label="Boleta" type="text" placeholder="Boleta" required />
              <div>
                <label className="block text-white text-sm font-bold mb-2">Carrera</label>
                <Input
                    type="option"
                    options={[
                      { value: "ISC", label: "Ingeniería en sistemas computacionales" },
                      { value: "LCD", label: "Licenciatura en ciencia de Datos" },
                      { value: "IA", label: "Ingeniería en inteligencia artificial" },
                    ]}
                    defaultValue=""
                    onChange={handleCareerChange}
                    required
                />
              </div>
              <Input onChange={handleEmailChange} label="Correo electrónico" type="email" placeholder="Correo electrónico" required />
              <Input onChange={handlePasswordChange} label="Contraseña" type="password" placeholder="Contraseña" required />
              <h1
                className="text-white text-md font-bold mb-2"
              >¿Es irregular?</h1>
              <div className="flex justify-between flex-row items-center space-x-4 mb-2">
                <label className="flex items-center space-x-2">
                <input
                    type="radio"
                    checked={isIrregular === true}
                    onChange={() => handleIsIrregularChange(true)}
                    className="text-blue-500 focus:ring-blue-400"
                />
                <span>Sí</span>
                </label>
                <label className="flex items-center space-x-2">
                <input
                    type="radio"
                    checked={isIrregular === false}
                    onChange={() => handleIsIrregularChange(false)}
                    className="text-blue-500 focus:ring-blue-400"
                />
                <span>No</span>
                </label>
            </div>
              <Button onClick={handleSubmit} label="Registrar" className="bg-teal-500 hover:bg-teal-700" />
            </form>
          </div>
        </div>
    );
}

export default FormularioRegistroAlumno
