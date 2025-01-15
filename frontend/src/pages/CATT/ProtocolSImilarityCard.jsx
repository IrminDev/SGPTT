import React, { useEffect, useState } from 'react';
import protocolService from '../../services/protocol.service';
import { Link } from 'react-router-dom';

const ProtocolSimilarityCard = ({ protocol, maxScore }) => {
  const [protocolDetail, setProtocolDetail] = useState(null);

  useEffect(() => {
    protocolService.getProtocol(protocol.id).then((response) => {
      setProtocolDetail(response[0]);
    }).catch((error) => {
      console.error('Error fetching protocol details:', error);
    });
  }, [protocol.id]);

  const getColorByScore = (score) => {
    if (score > 0.75) return 'bg-red-500';
    if (score > 0.5) return 'bg-yellow-500';
    return 'bg-green-500';
  };

  const normalizedScore = protocol.score / maxScore;

  return (
    protocolDetail && (
      <div className="max-w-md p-6 bg-white border border-gray-200 rounded-lg shadow-md hover:shadow-lg transition-shadow mt-5">
        <h2 className="text-2xl font-bold mb-2 text-gray-800">{protocolDetail.title}</h2>
        <p className="text-gray-600 mb-4">{protocolDetail.abstract}</p>

        <div className="mb-4">
          <h3 className="text-lg font-semibold text-gray-700">Palabras clave:</h3>
          {protocolDetail.keywords.map((keyword, index) => (
            <span key={index} className="bg-gray-200 text-gray-800 rounded-full px-3 py-1 text-sm font-semibold mr-2">{keyword}</span>
          ))}
        </div>

        <div className="mb-4">
          <h3 className="text-lg font-semibold text-gray-700">Estudiantes:</h3>
          {protocolDetail.students.map((student, index) => (
            <p key={index} className="text-gray-600">{student}</p>
          ))}
        </div>

        <div className="mb-4">
          <h3 className="text-lg font-semibold text-gray-700">Directores:</h3>
          {protocolDetail.directors.map((director, index) => (
            <p key={index} className="text-gray-600">{director}</p>
          ))}
        </div>

        <div className="mb-4">
          <h3 className="text-lg font-semibold text-gray-700">Academias:</h3>
          {protocolDetail.academies.map((academy, index) => (
            <span key={index} className="bg-blue-200 text-blue-800 rounded-full px-3 py-1 text-sm font-semibold mr-2">{academy.name}</span>
          ))}
        </div>

        <div className="w-full bg-gray-300 rounded-full h-4">
          <div
            className={`${getColorByScore(normalizedScore)} h-4 rounded-full`}
            style={{ width: `${normalizedScore * 100}%` }}
          ></div>
        </div>
        <p className="text-gray-700 mt-2 font-medium">Similitud: {(normalizedScore * 100).toFixed(2)}%</p>

        <div className="mb-4">
            <Link
                to={`../plagios/${protocolDetail.id}`}
                className="inline-block px-4 py-2 bg-blue-500 text-white font-semibold rounded-lg hover:bg-blue-600 transition-colors"
            >
                Ver protocolo
            </Link>
        </div>
      </div>
    )
  );
};

export default ProtocolSimilarityCard;
