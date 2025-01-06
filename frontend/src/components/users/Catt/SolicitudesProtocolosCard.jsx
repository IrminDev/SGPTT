import React from 'react';

const SolicitudesProtocolosCard = ({ solicitud }) => {
  return (
    <div className="bg-white p-6 rounded-lg shadow-md mb-4">
      <h2 className="text-2xl font-bold text-gray-900 mb-2">ID del protocolo: {solicitud.protocolId}</h2>
      <p><strong>Estado:</strong> {solicitud.state}</p>
      <p><strong>Comentarios:</strong></p>
      <p className="ml-4">{solicitud.requestComments}</p>
      <p><strong>Fecha de solicitud:</strong> {solicitud.createdAt.substring(0,10)}</p>
      <h1 className=' font-bold text-center text-xl'>Formato de solicitud de cambios</h1>
      <div className="mt-4">
        <iframe src={solicitud.filePath} className=' w-full h-96'></iframe>
      </div>
    </div>
  );
};

export default SolicitudesProtocolosCard;