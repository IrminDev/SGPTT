import React from 'react';
import TittleSection from '../../components/common/TittleSection';
import SolicitudesProtocolosCard from '../../components/users/Catt/SolicitudesProtocolosCard';

export default function SolicitudesModificacionProtocolos() {
  const solicitudes = [
    {
      titulo: "Título de prueba para un protocolo 1",
      integrantes: ["Integrante1", "Integrante2", "Integrante3"],
      comentarios: "Queremos modificar la sección de resultados.",
      pdfFile: "ruta/al/archivo1.pdf",
    },
    {
      titulo: "Título de prueba para un protocolo 2",
      integrantes: ["Integrante4", "Integrante5", "Integrante6"],
      comentarios: "Necesitamos actualizar la metodología.",
      pdfFile: "ruta/al/archivo2.pdf",
    },
    // Puedes agregar más solicitudes aquí
  ];

  return (
    <div className="bg-gray-800 min-h-screen flex flex-col">
      <div className="mb-4">
        <TittleSection tittle="Solicitudes de Modificación de Protocolos" />
      </div>
      <div className="p-4 bg-gray-800 rounded-lg shadow-md w-full max-w-7xl mx-auto">
        {solicitudes.map((solicitud, index) => (
          <SolicitudesProtocolosCard key={index} solicitud={solicitud} />
        ))}
      </div>
    </div>
  );
}