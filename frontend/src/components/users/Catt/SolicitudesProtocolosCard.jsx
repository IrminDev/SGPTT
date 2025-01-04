import React from 'react';
import Button from '../../common/Button';

const SolicitudesProtocolosCard = ({ solicitud }) => {
  return (
    <div className="bg-white p-6 rounded-lg shadow-md mb-4">
      <h2 className="text-2xl font-bold text-gray-900 mb-2">{solicitud.titulo}</h2>
      <p><strong>Integrantes:</strong> {solicitud.integrantes.join(', ')}</p>
      <p><strong>Comentarios:</strong></p>
      <p className="ml-4">{solicitud.comentarios}</p>
      <div className="mt-4">
        <a href={solicitud.pdfFile} target="_blank" rel="noopener noreferrer">
          <Button label="Ver PDF" className="bg-teal-600 hover:bg-green-600" />
        </a>
      </div>
    </div>
  );
};

export default SolicitudesProtocolosCard;