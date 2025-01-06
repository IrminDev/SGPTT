import React, { useState } from "react";
import OptionBar from "../../components/common/OptionBar";
import FormularioRegistroUsuario from "../../components/users/Catt/FormularioRegistroUsuario";
import TittleSection from "../../components/common/TittleSection";
import FormularioRegistroAlumno from "../../components/users/Catt/FormularioRegistroAlumno";
import FormularioRegistroProfesor from "../../components/users/Catt/FormularioRegistroProfesor";
import FormularioRegistroCATT from "../../components/users/Catt/FormularioRegistroCATT";

const RegistrarUsuario = () => {
  const [tipoUsuario, setTipoUsuario] = useState("Alumno");

  const opciones = ["Alumno", "Profesor", "CATT"];

  const renderFormulario = () => {
    switch (tipoUsuario) {
      case "Alumno":
        return (
          <FormularioRegistroAlumno />
        );
      case "Profesor":
        return (
          <FormularioRegistroProfesor />
        );
      case "CATT":
        return (
          <FormularioRegistroCATT />
        );
      default:
        return null;
    }
  };

  return (
    <div className="bg-gray-800 h-screen">
      <div className="mb-4">
        <TittleSection tittle="Registrar Nuevo Usuario" />
      </div>
      <div className="flex justify-center items-center mt-4 relative">
        <div className="w-full max-w-4xl bg-gray-800 rounded-lg shadow-md overflow-hidden">
          <OptionBar opciones={opciones} onSelect={setTipoUsuario} selectedOption={tipoUsuario} />
        </div>
      </div>
      <div className="flex justify-center items-center mt-4 px-4">
        <div className="w-full max-w-4xl bg-gray-600 rounded-lg shadow-md overflow-hidden">
          <div className="p-6">{renderFormulario()}</div>
        </div>
      </div>
    </div>
  );
};

export default RegistrarUsuario;