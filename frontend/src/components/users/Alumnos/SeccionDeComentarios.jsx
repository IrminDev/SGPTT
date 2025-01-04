import React from 'react';
import Comments from '../../common/Comments';

export default function SeccionDeComentarios({ comentarios }) {
  return (
    <div className="w-full bg-slate-700 p-6 rounded-lg shadow-md">
      <h2 className="text-2xl font-bold text-white mb-4">Comentarios</h2>
      <div className="border-t border-gray-600 mt-4">
        {comentarios.length > 0 ? (
          comentarios.map((comentario, index) => (
            <Comments
              key={index}
              sinodal={comentario.sinodal}
              contenido={comentario.contenido || "Sin comentarios"}
            />
          ))
        ) : (
          <p className="text-white">Sin comentarios</p>
        )}
      </div>
    </div>
  );
}