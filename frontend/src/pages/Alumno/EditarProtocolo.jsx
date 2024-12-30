import React from 'react';
import TittleSection from '../../components/common/TittleSection';
import SeccionDeComentarios from '../../components/users/Alumnos/SeccionDeComentarios';
import FormularioEditarProtocolo from '../../components/users/Alumnos/FormularioEditarProtocolo';
import ProtocoloInfoCard from '../../components/common/ProtocoloInfoCard';

export default function EditarProtocolo() {
  const comentarios = [
    { sinodal: "Dr. Juan Pérez", contenido: "Excelente trabajo" },
    { sinodal: "Mtro. Ana López", contenido: "" },
    { sinodal: "Dr. Carlos García", contenido: "Faltó un poco más de documentación" },
  ];

  const protocolo = {
    tipoProtocolo: "Primer Curse",
    titulo: "Título de prueba 1",
    palabrasClave: ["Palabra1", "Palabra2", "Palabra3"],
    resumen: "Este es el resumen del protocolo 1.",
    pdfFile: "ruta/al/archivo1.pdf",
    integrantes: ["Integrante1", "Integrante2", "Integrante3"],
    director: "Nombre del Director 1",
    carrera: "ISC",
    sinodales: ["Sinodal 1", "Sinodal 2", "Sinodal 3"],
    estado: "Aprobado",
  };

  return (
    <div className="bg-gray-800 min-h-screen flex flex-col">
      <div className="mb-4">
        <TittleSection tittle="Editar Protocolo" />
      </div>
      <div className="p-4 bg-gray-800 rounded-lg shadow-md w-full max-w-4xl mx-auto">
        <ProtocoloInfoCard protocolo={protocolo} />
      </div>
      <div className="flex justify-center items-center mt-4 relative">
        {/* Tarjeta para la edición de protocolo */}
        <div className="w-full max-w-7xl bg-gray-800 rounded-lg shadow-md overflow-hidden mt-5">
          {/* Contenido de la tarjeta en dos columnas SeccionDeComentarios y FormularioEditarProtocolo respectivamente */}
          <div className="flex flex-col md:flex-row justify-evenly items-center">
            {/* Sección de comentarios */}
            <div className="w-[80%] md:w-5/12 mb-4 md:mb-0">
              <SeccionDeComentarios comentarios={comentarios} />
            </div>

            {/* FormularioEditarProtocolo */}
            <div className="w-[80%] md:w-5/12">
              <FormularioEditarProtocolo />
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
