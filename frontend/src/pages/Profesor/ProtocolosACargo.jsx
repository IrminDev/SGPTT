import React from "react";
import TittleSection from "../../components/common/TittleSection";
import ProtocoloInfoCard from "../../components/common/ProtocoloInfoCard";

const ProtocolosACargo = () => {
  const protocolos = [
    {
      tipoProtocolo: "Primer Curse",
      titulo: "Título de prueba 1",
      palabrasClave: ["Palabra1", "Palabra2", "Palabra3"],
      resumen: "Este es el resumen del protocolo 1.",
      pdfFile: "ruta/al/archivo1.pdf",
      integrantes: ["Integrante1", "Integrante2", "Integrante3"],
      director: "Nombre del Director 1",
      carrera: "ISC",
      sinodales: ["Sinodal 1", "Sinodal 2", "Sinodal 3"],
      estado: "Rechazado",
    },
    {
      tipoProtocolo: "Recurse",
      titulo: "Título de prueba 2",
      palabrasClave: ["Palabra4", "Palabra5", "Palabra6"],
      resumen: "Este es el resumen del protocolo 2.",
      pdfFile: "ruta/al/archivo2.pdf",
      integrantes: ["Integrante4", "Integrante5", "Integrante6"],
      director: "Nombre del Director 2",
      carrera: "ISC",
      sinodales: [],
      estado: "En evaluación",
    },
  ];

  return (
    <div className="bg-gray-800 min-h-screen flex flex-col">
      <div className="mb-4">
        <TittleSection tittle="Protocolos a Cargo" />
      </div>
      <div className="p-8 bg-gray-800 rounded-lg shadow-md w-full max-w-4xl mx-auto">
        {protocolos.map((protocolo, index) => (
          <ProtocoloInfoCard key={index} protocolo={protocolo} />
        ))}
      </div>
    </div>
  );
};

export default ProtocolosACargo;