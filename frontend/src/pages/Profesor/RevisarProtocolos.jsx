import React from 'react';
import TittleSection from '../../components/common/TittleSection';
import FormularioRevisarProtocolo from '../../components/users/Profesores/FormularioRevisarProtocolo';
import ProtocoloInfoCard from '../../components/common/ProtocoloInfoCard';

export default function RevisarProtocolo() {
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
      estado: "En evaluación",
    },
    {
      tipoProtocolo: "Segundo Curse",
      titulo: "Título de prueba 2",
      palabrasClave: ["Palabra4", "Palabra5", "Palabra6"],
      resumen: "Este es el resumen del protocolo 2.",
      pdfFile: "ruta/al/archivo2.pdf",
      integrantes: ["Integrante4", "Integrante5", "Integrante6"],
      director: "Nombre del Director 2",
      carrera: "ISC",
      sinodales: ["Sinodal 4", "Sinodal 5", "Sinodal 6"],
      estado: "En evaluación",
    },
    // Puedes agregar más protocolos aquí
  ];

  return (
    <div className="bg-gray-800 min-h-screen flex flex-col">
      <div className="mb-4">
        <TittleSection tittle="Revisar Protocolos" />
      </div>
      <div className="flex flex-col justify-center items-start p-4 bg-gray-800 rounded-lg shadow-md w-full max-w-7xl mx-auto space-y-4">
        {protocolos.map((protocolo, index) => (
          <React.Fragment key={index}>
            <div className="flex flex-col md:flex-row justify-center items-start w-full space-y-4 md:space-y-0 md:space-x-4">
              <div className="w-full md:w-1/2 p-4">
                <ProtocoloInfoCard protocolo={protocolo} />
              </div>
              <div className="w-full md:w-1/2 p-4">
                <FormularioRevisarProtocolo />
              </div>
            </div>
            {index < protocolos.length - 1 && (
              <hr className="border-t border-gray-600 my-4 w-full" />
            )}
          </React.Fragment>
        ))}
      </div>
    </div>
  );
}