import React from 'react';
import { Link } from 'react-router-dom';

const ProtocolSinodalCard = ({ protocol }) => {
  return (
    <div className="max-w-md p-6 bg-white border border-gray-200 rounded-lg shadow-md hover:shadow-lg transition-shadow">
      <h2 className="text-2xl font-bold mb-2 text-gray-800">{protocol.title}</h2>
      <p className="text-gray-600 mb-4">{protocol.abstract}</p>

      <div className="mb-4">
        <h3 className="text-lg font-semibold text-gray-700">Palabras clave:</h3>
        {protocol.keywords.map((keyword, index) => (
            <span key={index} className="bg-gray-200 text-gray-800 rounded-full px-3 py-1 text-sm font-semibold mr-2">{keyword}</span>
        ))}
      </div>

      <div className="mb-4">
        <h3 className="text-lg font-semibold text-gray-700">Academias:</h3>
        <ul className="list-disc list-inside text-gray-600">
          {protocol.academies.map((academy, index) => (
            <li key={index}>{academy.name}</li>
          ))}
        </ul>
      </div>

        <div className="mb-4">
            <Link 
                to={`./${protocol.id}`}
                className="inline-block px-4 py-2 bg-blue-500 text-white font-semibold rounded-lg hover:bg-blue-600 transition-colors"
            >
                Asignar sinodales
            </Link>
        </div>
    </div>
  );
};

export default ProtocolSinodalCard;