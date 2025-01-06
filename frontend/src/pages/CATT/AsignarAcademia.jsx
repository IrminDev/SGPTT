import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import protocolService from '../../services/protocol.service';
import assessmentService from '../../services/assessment.service';

const AsignarAcademia = () => {
    const { id } = useParams();
    const [selectedAcademy, setSelectedAcademy] = useState('');
    const [assignedAcademies, setAssignedAcademies] = useState([]);
    const [protocol, setProtocol] = useState({});

    useEffect(() => {
        protocolService.getProtocol(id)
            .then((response) => {
                setProtocol(response[0]);
            })
            .catch((error) => {
                console.error('Error fetching protocol:', error);
            });
    }, [id]);

    const handleAddAcademy = () => {
        if (selectedAcademy && !assignedAcademies.includes(selectedAcademy)) {
            setAssignedAcademies([...assignedAcademies, selectedAcademy]);
        }
    };

    const handleUpload = (e) => {
        e.preventDefault();
        if (assignedAcademies.length === 0) {
            return;
        }

        const data = {
            protocolId: protocol.id,
            academiesId: assignedAcademies,
        }

        assessmentService.assignAcademy(data).then((response) => {
            console.log(response);
        }).catch((error) => {
            console.log(error);
        })

        console.log(data);
    }

    return (
        <div className="max-w-3xl mx-auto p-6 bg-white border border-gray-200 rounded-lg shadow-md">
            <h1 className="text-2xl font-bold mb-4 text-gray-800">{protocol.title}</h1>
            <p className="text-gray-600 mb-6">Resumen: {protocol.abstract}</p>
            <p>Palabras clave: {protocol.keywords?.join(', ')}</p>

            <iframe src={protocol.fileUrl}
                className=' w-full h-96'
            ></iframe>

            <div className="mb-4">
                <h2 className="text-lg font-semibold text-gray-700 mb-2">Academias asignadas: </h2>
                <ul className="list-disc list-inside text-gray-600">
                    {assignedAcademies.map((academy, index) => (
                        <li key={index}>{academy}</li>
                    ))}
                </ul>
            </div>

            <div className="mb-6">
                <label htmlFor="academy-select" className="block text-gray-700 font-semibold mb-2">
                    Escoge una academia
                </label>
                <select
                    id="academy-select"
                    value={selectedAcademy}
                    onChange={(e) => setSelectedAcademy(e.target.value)}
                    className="w-full p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-400"
                >
                    <option value="" disabled>Escoge una opción</option>
                    <option value={1}>1. Sistemas computacionales</option>
                    <option value={2}>2. Sistemas digitales</option>
                    <option value={3}>3. Ingeniería de software</option>
                    <option value={4}>4. Redes y telecomunicaciones</option>
                    <option value={5}>5. Ciencias básicas</option>
                    <option value={6}>6. Bases de datos y tecnologías web</option>
                    <option value={7}>7. Inteligencia artificial</option>
                    <option value={8}>8. Ciencias sociales</option>
                </select>
            </div>

            <div className="flex space-x-4">
                <button
                    type="button"
                    onClick={handleAddAcademy}
                    className="px-4 py-2 bg-green-500 text-white font-semibold rounded-lg hover:bg-green-600 transition-colors"
                >
                    Agregar
                </button>
                <button
                    type="button"
                    onClick={handleUpload}
                    className="px-4 py-2 bg-blue-500 text-white font-semibold rounded-lg hover:bg-blue-600 transition-colors"
                >
                    Subir información
                </button>
            </div>
        </div>
    );
};

export default AsignarAcademia;
