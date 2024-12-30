import React from "react";
import Input from "../../common/Input";
import Button from "../../common/Button";

const FormularioRegistroUsuario = ({ titulo, dropdownLabel, dropdownOptions }) => {
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
          {titulo}
        </h2>
        {/* Formulario de registro */}
        <form className="space-y-4">
          <Input label="Nombre(s)" type="text" placeholder="Nombre(s)" required />
          <Input label="Apellido paterno" type="text" placeholder="Apellido paterno" required />
          <Input label="Apellido materno" type="text" placeholder="Apellido materno" required />
          <Input label="Contraseña" type="password" placeholder="Contraseña" required />
          <Input label="Confirmar contraseña" type="password" placeholder="Confirmar contraseña" required />
          <div>
            <label className="block text-white text-sm font-bold mb-2">{dropdownLabel}</label>
            <Input
              type="option"
              options={dropdownOptions}
              defaultValue=""
              required
            />
          </div>
          <Input label="Correo electrónico" type="email" placeholder="Correo electrónico" required />
          <Button label="Registrar" className="bg-teal-500 hover:bg-teal-700" />
        </form>
      </div>
    </div>
  );
};

export default FormularioRegistroUsuario;