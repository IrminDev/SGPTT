import React, { useState } from "react";
import Input from "../../common/Input";
import Button from "../../common/Button";

// Componente ProtocolosPendientesAreaCard que recibe el nombre del protocolo, el área, la carrera, los miembros y las opciones de áreas como props
export default function ProtocolosPendientesAreaCard({ protocolName, career, members, areaOptions }) {
  // Estado para almacenar el valor seleccionado del área
  const [selectedArea, setSelectedArea] = useState("");

  // Manejador de eventos para actualizar el estado del área
  const handleAreaChange = (e) => setSelectedArea(e.target.value);

  return (
    <div className="bg-gray-700 flex flex-col rounded-lg shadow-md mb-4">
      <div className="p-6 bg-gray-800 rounded-lg w-full mx-auto max-w-4xl space-y-4">
        <div className="flex flex-col md:flex-row">
          
          {/* Sección de datos del protocolo */}
          <div className="md:w-1/2 mb-4 md:mb-0 md:pr-8">
            <h2 className="text-2xl font-semibold mb-4 text-white">{protocolName}</h2>
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

          {/* Sección de dropdowns para seleccionar áreas */}
          <div className="md:w-1/2 space-y-6">
            <Input
              label="Área"
              type="option"
              value={selectedArea}
              onChange={handleAreaChange}
              options={areaOptions}
              defaultValue=""
            />
          </div>
        </div>

        {/* Botón para asignar área */}
        <div className="mt-8 flex justify-start">
          <Button label="Asignar" className="bg-teal-600 hover:bg-green-600" />
        </div>
      </div>
    </div>
  );
}