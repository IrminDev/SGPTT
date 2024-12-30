import React from 'react';

export default function Comments({ sinodal, contenido }) {
  return (
    <div className="bg-gray-50 rounded-md p-3 mb-2 border border-gray-200 text-gray-800">
      <h4 className="text-md font-semibold text-gray-900">{sinodal}</h4>
      <p>{contenido}</p>
    </div>
  );
}