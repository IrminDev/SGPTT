import React, { useState } from "react";
import Input from "../../common/Input";
import Button from "../../common/Button";

// Componente ProtocolosPendientesSinodalCard que recibe el nombre del protocolo, el área, la carrera, los miembros y las opciones de sinodales como props
export default function ProtocolosPendientesSinodalCard({ protocolName, area, career, members, sinodalOptions }) {
  // Estados para almacenar los valores seleccionados de los sinodales
  const [sinodal1, setSinodal1] = useState("");
  const [sinodal2, setSinodal2] = useState("");
  const [sinodal3, setSinodal3] = useState("");

  // Manejadores de eventos para actualizar los estados de los sinodales
  const handleSinodal1Change = (e) => setSinodal1(e.target.value);
  const handleSinodal2Change = (e) => setSinodal2(e.target.value);
  const handleSinodal3Change = (e) => setSinodal3(e.target.value);

  // Filtra las opciones disponibles para evitar duplicados en los sinodales
  const getFilteredOptions = (selectedValues) => {
    return sinodalOptions.filter(
      (option) => !selectedValues.includes(option.value)
    );
  };

  return (
    <div className="bg-gray-700 flex flex-col rounded-lg shadow-md mb-4">
      <div className="p-6 bg-gray-800 rounded-lg w-full mx-auto max-w-4xl space-y-4">
        <div className="flex flex-col md:flex-row">
          {/* Sección de datos del protocolo */}
          <div className="md:w-1/2 mb-4 md:mb-0 md:pr-8">
            <h2 className="text-2xl font-semibold mb-4 text-white">{protocolName}</h2>
            <p className="text-gray-300 mb-2">
              <span className="font-semibold">Área:</span> {area}
            </p>
            <p className="text-gray-300 mb-2">
              <span className="font-semibold">Carrera:</span> {career}
            </p>
            <p className="text-gray-300 mb-2">
              <span className="font-semibold">Número de Integrantes:</span> {members.length}
            </p>
            {members.map((member, index) => (
              <p key={index} className="text-gray-300 mb-2">
                <span className="font-semibold">Integrante No.{index + 1}:</span> {member}
              </p>
            ))}
          </div>

          {/* Sección de dropdowns para seleccionar sinodales */}
          <div className="md:w-1/2 space-y-6">
            <Input
              label="Sinodal 1"
              type="option"
              value={sinodal1}
              onChange={handleSinodal1Change}
              options={getFilteredOptions([sinodal2, sinodal3])}
              defaultValue=""
            />
            <Input
              label="Sinodal 2"
              type="option"
              value={sinodal2}
              onChange={handleSinodal2Change}
              options={getFilteredOptions([sinodal1, sinodal3])}
              defaultValue=""
            />
            <Input
              label="Sinodal 3"
              type="option"
              value={sinodal3}
              onChange={handleSinodal3Change}
              options={getFilteredOptions([sinodal1, sinodal2])}
              defaultValue=""
            />
          </div>
        </div>

        {/* Botón para asignar sinodales */}
        <div className="mt-8 flex justify-start">
          <Button label="Asignar" className="bg-teal-600 hover:bg-green-600" />
        </div>
      </div>
    </div>
  );
}