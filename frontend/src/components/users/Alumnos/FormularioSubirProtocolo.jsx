import React from "react";

const FormularioSubirProtocolo = ({ tipoProtocolo }) => {
    return (
        <>
            {/* Contenido interno de la tarjeta */}
            <div className="p-8" >
                <h2 className="text-2xl font-bold text-center text-gray-800 mb-6">
                    Registrar Nuevo Protocolo de {tipoProtocolo}
                </h2>
                <div className="flex flex-col md:flex-row"></div>
                <div className="flex flex-col md:flex-row">
                    {/* Sección de datos */}
                    <div className="md:w-1/2 mb-4 md:mb-0 md:pr-8">
                        {/* Título del protocolo */}
                        <div className="mb-4">
                            <label
                                htmlFor="titulo"
                                className="block text-gray-700 font-medium mb-1"
                            >
                                Título del protocolo
                            </label>
                            <input
                                type="text"
                                id="titulo"
                                name="titulo"
                                placeholder="Ingresa el título del protocolo"
                                className="w-full border border-gray-800 rounded-md p-2 focus:outline-none focus:ring-2 focus:ring-blue-500"
                            />
                        </div>

                        {/* Palabras clave relacionadas */}
                        <div className="mb-4">
                            <label
                                htmlFor="palabrasClave"
                                className="block text-gray-700 font-medium mb-1"
                            >
                                Palabras clave relacionadas con el protocolo
                            </label>
                            <input
                                type="text"
                                id="palabrasClave"
                                name="palabrasClave"
                                placeholder="Ingresa palabras clave"
                                className="w-full border border-gray-300 rounded-md p-2 focus:outline-none focus:ring-2 focus:ring-blue-500"
                            />
                            <input
                                type="text"
                                id="palabrasClave2"
                                name="palabrasClave2"
                                placeholder="Ingresa palabras clave"
                                className="w-full border border-gray-300 rounded-md p-2 focus:outline-none focus:ring-2 focus:ring-blue-500 mt-2"
                            />
                            <input
                                type="text"
                                id="palabrasClave3"
                                name="palabrasClave3"
                                placeholder="Ingresa palabras clave"
                                className="w-full border border-gray-300 rounded-md p-2 focus:outline-none focus:ring-2 focus:ring-blue-500 mt-2"
                            />
                        </div>

                        {/* Resumen del protocolo */}
                        <div className="mb-4">
                            <label
                                htmlFor="resumen"
                                className="block text-gray-700 font-medium mb-1"
                            >
                                Resumen del protocolo
                            </label>
                            <textarea
                                id="resumen"
                                name="resumen"
                                rows="3"
                                placeholder="Escribe un breve resumen del protocolo"
                                className="w-full border border-gray-300 rounded-md p-2 focus:outline-none focus:ring-2 focus:ring-blue-500"
                            ></textarea>

                            {/* Subir PDF */}
                            <div className="mb-4 mt-4">
                                <label
                                    htmlFor="pdfFile"
                                    className="block text-gray-700 font-medium mb-1"
                                >
                                    Subir PDF
                                </label>
                                <input
                                    type="file"
                                    id="pdfFile"
                                    name="pdfFile"
                                    accept=".pdf"
                                    className="w-full text-gray-700 border border-gray-300 rounded-md p-2 focus:outline-none focus:ring-2 focus:ring-blue-500 cursor-pointer bg-gray-50"
                                />
                            </div>
                        </div>
                    </div>

                    {/* Sección de dropdowns */}
                    <div className="md:w-1/2 space-y-6">
                        {/* Integrantes extra del protocolo */}
                        <div>
                            <label
                                htmlFor="integrante"
                                className="block text-gray-700 font-medium mb-1"
                            >
                                Integrantes extra del protocolo
                            </label>
                            <input
                                type="text"
                                id="integrante"
                                name="integrante"
                                placeholder="Ingresa el nombre del integrante"
                                className="w-full border border-gray-300 rounded-md p-2 focus:outline-none focus:ring-2 focus:ring-blue-500"
                            />
                            <input
                                type="text"
                                id="integrante2"
                                name="integrante2"
                                placeholder="Ingresa el nombre del integrante"
                                className="w-full border border-gray-300 rounded-md p-2 focus:outline-none focus:ring-2 focus:ring-blue-500 mt-2"
                            />
                            <input
                                type="text"
                                id="integrante3"
                                name="integrante3"
                                placeholder="Ingresa el nombre del integrante"
                                className="w-full border border-gray-300 rounded-md p-2 focus:outline-none focus:ring-2 focus:ring-blue-500 mt-2"
                            />
                            <input
                                type="text"
                                id="integrante4"
                                name="integrante4"
                                placeholder="Ingresa el nombre del integrante"
                                className="w-full border border-gray-300 rounded-md p-2 focus:outline-none focus:ring-2 focus:ring-blue-500 mt-2"
                            />
                        </div>

                        {/* Directores del protocolo */}
                        <div>
                            <label
                                htmlFor="director"
                                className="block text-gray-700 font-medium mb-1"
                            >
                                Director del protocolo
                            </label>
                            <input
                                type="text"
                                id="director"
                                name="director"
                                placeholder="Ingresa el nombre del director"
                                className="w-full border border-gray-300 rounded-md p-2 focus:outline-none focus:ring-2 focus:ring-blue-500"
                            />
                        </div>
                        <div>
                            <label htmlFor="">
                                Carrera
                            </label>
                            <select
                                id="carrera"
                                name="carrera"
                                required
                                className="w-full px-3 py-2 border rounded-lg shadow-sm focus:outline-none focus:border-indigo-500"
                            >
                                <option value="">Selecciona la carrera</option>
                                <option value="ISC">ISC</option>
                                <option value="Ciencia de Datos">Ciencia de Datos</option>
                                <option value="IA">IA</option>
                            </select>
                        </div>

                    </div>
                </div>

                {/* Botón dentro de la tarjeta (lado izquierdo) */}
                <div className="mt-8 flex justify-start">
                    <button className="bg-teal-600 text-white px-28 py-2 rounded hover:bg-green-600 focus:outline-none focus:ring-2">
                        Subir
                    </button>
                </div>
            </div >
        </>
    );
};

export default FormularioSubirProtocolo;