import React from "react";

// Función para obtener el color del estado
const getStatusColor = (status) => {
  switch (status) {
    case "Aprobado":
      return "text-green-500";
    case "Rechazado":
      return "text-red-500";
    case "En evaluación":
      return "text-blue-500";
    default:
      return "text-gray-300";
  }
};

// Función para obtener el color del círculo del estado
const getStatusCircleColor = (status) => {
  switch (status) {
    case "Aprobado":
      return "bg-green-500";
    case "Rechazado":
      return "bg-red-500";
    case "En evaluación":
      return "bg-blue-500";
    default:
      return "bg-gray-300";
  }
};

const ProtocoloInfoCard = ({ protocolo }) => {
  return (
    <div className="p-8 bg-gray-700 rounded-lg shadow-md w-full max-w-4xl mx-auto mb-8">
      <div className="mb-4">
        <h2 className="text-2xl text-white font-semibold">{`Tipo de Protocolo: ${protocolo.tipoProtocolo}`}</h2>
      </div>
      <div className="flex flex-col md:flex-row">
        {/* Sección de datos */}
        <div className="md:w-1/2 mb-4 md:mb-0 md:pr-8">
          <div className="mb-4">
            <label className="block text-gray-300 font-medium mb-1">Título del protocolo</label>
            <p className="text-white">{protocolo.titulo}</p>
          </div>
          <div className="mb-4">
            <label className="block text-gray-300 font-medium mb-1">Palabras clave</label>
            <p className="text-white">{protocolo.palabrasClave.join(", ")}</p>
          </div>
          <div className="mb-4">
            <label className="block text-gray-300 font-medium mb-1">Resumen</label>
            <p className="text-white">{protocolo.resumen}</p>
          </div>
          <div className="mb-4">
            <label className="block text-gray-300 font-medium mb-1">PDF</label>
            <a href={protocolo.pdfFile} className="text-blue-500 hover:underline">Ver PDF</a>
          </div>
        </div>

        {/* Sección de dropdowns */}
        <div className="md:w-1/2 space-y-6">
          <div>
            <label className="block text-gray-300 font-medium mb-1">Integrantes</label>
            <ul className="list-disc list-inside text-white">
              {protocolo.integrantes.map((integrante, index) => (
                <li key={index}>{integrante}</li>
              ))}
            </ul>
          </div>
          <div>
            <label className="block text-gray-300 font-medium mb-1">Director</label>
            <p className="text-white">{protocolo.director}</p>
          </div>
          <div>
            <label className="block text-gray-300 font-medium mb-1">Carrera</label>
            <p className="text-white">{protocolo.carrera}</p>
          </div>
          <div>
            <label className="block text-gray-300 font-medium mb-1">Sinodales</label>
            {protocolo.sinodales && protocolo.sinodales.length > 0 ? (
              <ul className="list-disc list-inside text-white">
                {protocolo.sinodales.map((sinodal, index) => (
                  <li key={index}>{sinodal}</li>
                ))}
              </ul>
            ) : (
              <p className="text-white">Sin sinodales asignados</p>
            )}
          </div>
          <div>
            <label className="block text-gray-300 font-medium mb-1">Estado</label>
            <div className="flex items-center">
              <span className={`w-3 h-3 rounded-full mr-2 ${getStatusCircleColor(protocolo.estado)}`}></span>
              <p className={getStatusColor(protocolo.estado)}>{protocolo.estado}</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ProtocoloInfoCard;