import React from 'react';
import { Link } from 'react-router-dom';

const ProtocolCard = ({ id, title, abstract, students, directors }) => {
  return (
    <div className="max-w-md p-6 bg-white border border-gray-200 rounded-lg shadow-md hover:shadow-lg transition-shadow">
      <h2 className="text-2xl font-bold mb-2 text-gray-800">{title}</h2>
      <p className="text-gray-600 mb-4">{abstract}</p>

      <div className="mb-4">
        <h3 className="text-lg font-semibold text-gray-700">Students:</h3>
        <ul className="list-disc list-inside text-gray-600">
          {students.map((student, index) => (
            <li key={index}>{student}</li>
          ))}
        </ul>
      </div>

      <div className="mb-4">
        <h3 className="text-lg font-semibold text-gray-700">Directors:</h3>
        <ul className="list-disc list-inside text-gray-600">
          {directors.map((director, index) => (
            <li key={index}>{director}</li>
          ))}
        </ul>
      </div>

      <Link
        to={`./${id}`}
        className="inline-block px-4 py-2 bg-blue-500 text-white font-semibold rounded-lg hover:bg-blue-600 transition-colors"
      >
        View Details
      </Link>
    </div>
  );
};

export default ProtocolCard;