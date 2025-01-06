import React from "react";

// Función para obtener el color del estado
const getStatusColor = (status) => {
  switch (status) {
    case "APPROVED":
      return "text-green-500";
    case "REJECTED":
      return "text-red-500";
    case "PENDING":
      return "text-blue-500";
    default:
      return "text-gray-300";
  }
};

// Función para obtener el color del círculo del estado
const getStatusCircleColor = (status) => {
  switch (status) {
    case "APPROVED":
      return "bg-green-500";
    case "REJECTED":
      return "bg-red-500";
    case "PENDING":
      return "bg-blue-500";
    default:
      return "bg-gray-300";
  }
};

const ProtocoloInfoCard = ({ protocol }) => {
  return (
    <div className="p-8 bg-gray-700 rounded-lg shadow-md w-full max-w-4xl mx-auto mb-8">
      <div className="mb-4">
        <h2 className="text-2xl text-white font-semibold">{`Título: ${protocol.title}`}</h2>
      </div>
      <div className="flex flex-col flex-wrap md:flex-row">
        {/* Sección de datos */}
        <div className="md:w-1/2 mb-4 md:mb-0 md:pr-8">
          <div className="mb-4">
            <label className="block text-gray-300 font-medium mb-1">Palabras clave</label>
            <p className="text-white">{protocol.keywords.join(", ")}</p>
          </div>
          <div className="mb-4">
            <label className="block text-gray-300 font-medium mb-1">Resumen</label>
            <p className="text-white">{protocol.abstract}</p>
          </div>
          <div className="mb-4">
            <label className="block text-gray-300 font-medium mb-1">Fecha de creación</label>
            <p className="text-white">{protocol.createdAt.substring(0,10)}</p>
          </div>
        </div>

        {/* Sección de dropdowns */}
        <div className="md:w-1/2 space-y-6">
          <div>
            <label className="block text-gray-300 font-medium mb-1">Estado</label>
            <div className="flex items-center">
              <span className={`w-3 h-3 rounded-full mr-2 ${getStatusCircleColor(protocol.state)}`}></span>
              <p className={getStatusColor(protocol.state)}>{protocol.state}</p>
            </div>
          </div>
        </div>

        <div className=" w-full mt-5">
          <iframe src={protocol.fileUrl} width="100%" height="600"></iframe>
        </div>
      </div>
    </div>
  );
};

export default ProtocoloInfoCard;