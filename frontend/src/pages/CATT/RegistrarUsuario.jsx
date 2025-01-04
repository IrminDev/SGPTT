import React, { useState } from "react";
import OptionBar from "../../components/common/OptionBar";
import FormularioRegistroUsuario from "../../components/users/Catt/FormularioRegistroUsuario";
import TittleSection from "../../components/common/TittleSection";

const RegistrarUsuario = () => {
  const [tipoUsuario, setTipoUsuario] = useState("Alumno");

  const opciones = ["Alumno", "Profesor", "CAT"];

  const renderFormulario = () => {
    switch (tipoUsuario) {
      case "Alumno":
        return (
          <FormularioRegistroUsuario
            titulo="Registro de alumno"
            dropdownLabel="Carrera"
            dropdownOptions={[
              { value: "ISC", label: "ISC" },
              { value: "Ciencia de Datos", label: "Ciencia de Datos" },
              { value: "IA", label: "IA" },
            ]}
          />
        );
      case "Profesor":
        return (
          <FormularioRegistroUsuario
            titulo="Registro de profesor"
            dropdownLabel="Área"
            dropdownOptions={[
              { value: "Ingeniería de software", label: "Ingeniería de software" },
              { value: "Sistemas digitales", label: "Sistemas digitales" },
              { value: "Ciencias de la computación", label: "Ciencias de la computación" },
            ]}
          />
        );
      case "CAT":
        return (
          <FormularioRegistroUsuario
            titulo="Registro de usuario CAT"
            dropdownLabel="Rol"
            dropdownOptions={[
              { value: "Coordinador", label: "Coordinador" },
              { value: "Asistente", label: "Asistente" },
              { value: "Administrativo", label: "Administrativo" },
            ]}
          />
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