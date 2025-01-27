import React, { useState, useEffect} from "react";
import protocolService from "../../../services/protocol.service";
import { useNavigate } from "react-router-dom";
import { toast } from 'react-toastify';

const FormularioSubirProtocolo = ({ tipoProtocolo }) => {
    const navigate = useNavigate();

    const [workMates, setWorkMates] = useState([]);
    const [workMatesValue, setWorkMatesValue] = useState('');
    const [directors, setDirectors] = useState([]);
    const [directorsValue, setDirectorsValue] = useState('');
    const [keywords, setKeywords] = useState([]);
    const [keywordsValue, setKeywordsValue] = useState('');
    const [protocolTitle, setProtocolTitle] = useState('');
    const [abstract, setAbstract] = useState('');
    const [pdfFile, setPdfFile] = useState('');
    const [person, setPerson] = useState(JSON.parse(localStorage.getItem("person")));

    const handleWorkMates = (e) => {
        e.preventDefault();
        // Check if the element is already in the array
        if(workMates.find((mate) => mate === workMatesValue)){
            toast.error("Integrante ya agregado");
            return;
        }

        if(workMates.length <= 3){
            setWorkMates([...workMates, workMatesValue]);
            setWorkMatesValue('');
        } else {
            
        }
    }

    const handleDirectors = (e) => {
        e.preventDefault();
        // Check if the element is already in the array
        if(directors.find((director) => director === directorsValue)){
            toast.error("Director ya agregado");
            return;
        }

        if(directors.length <= 3){
            setDirectors([...directors, directorsValue]);
            setDirectorsValue('');
        } else {

        }
    }

    const handleKeywords = (e) => {
        e.preventDefault();
        // Check if the element is already in the array
        if(keywords.find((keyword) => keyword === keywordsValue)){
            toast.error("Palabra clave ya agregada");
            return;
        }

        // Check if the element has only letters, numbers and spaces
        if(!/^[a-zA-Z0-9 ]+$/.test(keywordsValue)){
            toast.error("Ingresa una palabra clave válida");
            return
        }

        setKeywords([...keywords, keywordsValue]);
        setKeywordsValue('');
    }

    const handleWorkMatesValue = (e) => {
        setWorkMatesValue(e.target.value);
    }

    const handleDirectorsValue = (e) => {
        setDirectorsValue(e.target.value);
    }

    const handleKeywordsValue = (e) => {
        setKeywordsValue(e.target.value);
    }

    const handleProtocolTitle = (e) => {
        setProtocolTitle(e.target.value);
    }

    const handleAbstract = (e) => {
        setAbstract(e.target.value);
    }

    const handlePdfFile = (e) => {
        setPdfFile(e.target.files[0]);
    }

    const handleSubmit = (e) => {
        e.preventDefault();

        if(workMates.find((mate) => mate.length < 10)){
            toast.error("Ingresa una boleta válida");
            return;
        }

        if(directors.find((director) => director.length < 10)){
            toast.error("Ingresa un número de empleado válido");
            return;
        }

        if(keywords.length === 0){
            toast.error("Ingresa al menos una palabra clave");
            return;
        }

        if(!pdfFile){
            toast.error("Sube un archivo PDF");
            return;
        }

        const form = {
            workMates,
            directors,
            keywords,
            protocolTitle,
            abstract,
            studentId: person.personId,
        }
        

        const formData = new FormData();
        formData.append('uploadRequest', new Blob([JSON.stringify(form)], { type: 'application/json' }));
        formData.append('file', pdfFile);
        console.log(JSON.stringify(form));

        const token = localStorage.getItem("token");

        console.log("Token: ", token);

        console.log("Formulario: ", form);
        protocolService.uploadProtocol(formData).then((response) => {
            if(response.new){
                toast.success("Protocolo subido exitosamente");
                navigate('/dashboard-alumno/mi-protocolo');
            }
        }).catch((error) => {
            toast.error("Error al subir el protocolo");
            console.log(error);
        })
    }

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
                                onChange={handleProtocolTitle}
                                value={protocolTitle}
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
                                className="text-gray-700 font-medium m-1 flex flex-row flex-wrap"
                            >
                                Palabras clave relacionadas con el protocolo: {
                                    keywords.map((keyword, index) => (
                                        <span key={index} className="bg-gray-200 text-gray-700 px-2 py-1 rounded-md mr-2 mt-2">
                                            {keyword}
                                        </span>
                                    ))
                                }
                            </label>
                            <input
                                type="text"
                                id="palabrasClave"
                                onChange={handleKeywordsValue}
                                value={keywordsValue}
                                name="palabrasClave"
                                placeholder="Ingresa palabras clave"
                                className="w-full border border-gray-300 rounded-md p-2 focus:outline-none focus:ring-2 focus:ring-blue-500"
                            />
                            <input 
                                type="submit"
                                onClick={handleKeywords}
                                value="Agregar"
                                className="bg-blue-500 text-white px-2 py-1 rounded-md hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-500 cursor-pointer mt-2"
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
                                onChange={handleAbstract}
                                value={abstract}
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
                                    onChange={handlePdfFile}
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
                                className="text-gray-700 font-medium mb-1 flex flex-row flex-wrap"
                            >
                                Integrantes extra del protocolo: {
                                    workMates.map((keyword, index) => (
                                        <span key={index} className="bg-gray-200 text-gray-700 px-2 py-1 rounded-md mr-2 mt-2">
                                            {keyword}
                                        </span>
                                    ))
                                }
                            </label>
                            <input
                                type="text"
                                id="integrante"
                                onChange={handleWorkMatesValue}
                                value={workMatesValue}
                                name="integrante"
                                placeholder="Ingresa la boleta del integrante"
                                className="w-full border border-gray-300 rounded-md p-2 focus:outline-none focus:ring-2 focus:ring-blue-500"
                            />
                            <input 
                                type="submit"
                                onClick={handleWorkMates}
                                value="Agregar"
                                className="bg-blue-500 text-white px-2 py-1 rounded-md hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-500 cursor-pointer mt-2"
                            />
                        </div>

                        {/* Directores del protocolo */}
                        <div>
                            <label
                                htmlFor="director"
                                className=" text-gray-700 font-medium mb-1 flex flex-row flex-wrap"
                            >
                                Directores del protocolo: {
                                    directors.map((keyword, index) => (
                                        <span key={index} className="bg-gray-200 text-gray-700 px-2 py-1 rounded-md mr-2 mt-2">
                                            {keyword}
                                        </span>
                                    ))
                                }
                            </label>
                            <input
                                type="text"
                                id="director"
                                name="director"
                                onChange={handleDirectorsValue}
                                value={directorsValue}
                                placeholder="Ingresa el numero de empleado del director"
                                className="w-full border border-gray-300 rounded-md p-2 focus:outline-none focus:ring-2 focus:ring-blue-500"
                            />
                            <input 
                                type="submit"
                                onClick={handleDirectors}
                                value="Agregar"
                                className="bg-blue-500 text-white px-2 py-1 rounded-md hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-500 cursor-pointer mt-2"
                            />
                        </div>
                    </div>
                </div>

                {/* Botón dentro de la tarjeta (lado izquierdo) */}
                <div className="mt-8 flex justify-start">
                    <button
                        className="bg-teal-600 text-white px-28 py-2 rounded hover:bg-green-600 focus:outline-none focus:ring-2"
                        disabled={(person.isIrregular && tipoProtocolo !== "Recurse")|| (!person.isIrregular && tipoProtocolo !== "Primer Curse")}
                        onClick={handleSubmit}
                    >
                        Subir
                    </button>
                </div>
            </div >
        </>
    );
};

export default FormularioSubirProtocolo;