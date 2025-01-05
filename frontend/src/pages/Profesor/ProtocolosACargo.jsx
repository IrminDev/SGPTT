import React from "react";
import TittleSection from "../../components/common/TittleSection";
import ProtocoloInfoCard from "../../components/common/ProtocoloInfoCard";

const ProtocolosACargo = () => {
  const protocolos = [
    {
      title: "Título de prueba 1",
      keywords: ["Palabra1", "Palabra2", "Palabra3"],
      asbtract: "Este es el resumen del protocolo 1.",
      fileUrl: "ruta/al/archivo1.pdf",
      students: ["Integrante1", "Integrante2", "Integrante3"],
      directors: "Nombre del Director 1",
      state: "Rechazado",
      createdAt: "2021-10-01T00:00:00.000Z",
    },
    {
      title: "Título de prueba 1",
      keywords: ["Palabra1", "Palabra2", "Palabra3"],
      asbtract: "Este es el resumen del protocolo 1.",
      fileUrl: "ruta/al/archivo1.pdf",
      students: ["Integrante1", "Integrante2", "Integrante3"],
      directors: "Nombre del Director 1",
      state: "Rechazado",
      createdAt: "2021-10-01T00:00:00.000Z",
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