import React, { useState } from "react";
import Button from "../../common/Button";
import { Link } from "react-router-dom";
import protocolService from "../../../services/protocol.service";

// Componente ProtocolosPendientesAreaCard que recibe el nombre del protocolo, el área, la carrera, los miembros y las opciones de áreas como props
export default function ProtocolosPendientesAreaCard({ id, title, abstract, keywords, fileURL }) {
  const handleRejection = () => {
    protocolService.changeProtocolStatus({ protocolId: id, state: "REJECTED" })
      .then((response) => {
        console.log(response);
      })
      .catch((error) => {
        console.error("Error rejecting protocol:", error);
      });
  }

  return (
    <div className="bg-gray-700 flex flex-col rounded-lg shadow-md mb-4 w-full">
      <div className="p-6 bg-gray-800 rounded-lg w-full mx-auto max-w-4xl space-y-4">
        <div className="flex flex-col md:flex-row">
          
          {/* Sección de datos del protocolo */}
          <div className="md:w-1/2 mb-4 md:mb-0 md:pr-8">
            <h2 className="text-2xl font-semibold mb-4 text-white">{title}</h2>
            <p className="text-gray-300 mb-2">
              <span className="font-semibold">Resumen:</span> {abstract}
            </p>
            <p>
              <span className="font-semibold text-white">Palabras clave: </span>
              {keywords.map((keyword, index) => (
                <span key={index} className="text-gray-300">
                  {keyword}
                  {index < keywords.length - 1 ? ", " : ""}
                </span>
              ))}
            </p>
          </div>

          {/* Sección de archivo */}
          <div className=" w-full">
              <iframe src={fileURL}
              className="w-full h-64"
              ></iframe>
          </div>
        </div>

          {/* Botón para asignar área */}
          <div className="mt-8 flex justify-between">
            <Link to={`./${id}`} className="bg-teal-600 hover:bg-green-600 text-white font-normal py-3 px-5 rounded-md">Asignar academia</Link>
            <Button onClick={handleRejection} label="Rechazar protocolo" className="bg-red-600 hover:bg-red-800 rounded-md" />
          </div>
      </div>
    </div>
  );
}