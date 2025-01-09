import React, { useEffect, useState } from 'react'
import { useParams, useNavigate } from 'react-router-dom';
import protocolService from '../../../services/protocol.service';
import utilsService from '../../../services/utils.service';
import sinodalService from '../../../services/sinodal.service';

const FormularioAsignarSinodales = () => {
    const navigate = useNavigate();
    
    const { id } = useParams();

    const [selectedSynodal, setSelectedSynodal] = useState("");
    const [assignedSynodales, setAssignedSynodales] = useState([]);
    const [protocol, setProtocol] = useState({})
    const [professors, setProfessors] = useState([]);
    const [suggestions, setSuggestions] = useState([]);

    useEffect(() => {
      protocolService.getProtocol(id).then((response) => {
        setProtocol(response[0]);
        console.log("Protocol:", response[0]);
        sinodalService.getAllProfessors().then((resp) => {
            // Filter all the professors that are not directors of the protocol and are in the same academy
            console.log("Professors:", resp);
            const directors = response[0].directors;
            const academies = response[0].academies.map(academy => academy.id);
            const synodales = response[0].synodales;
            const filteredProfessors = resp.filter((professor) => {
                return !directors.includes(professor.name) && academies.includes(professor.academy?.academyId) && !synodales.includes(`${professor.name} ${professor.paternalSurname} ${professor.maternalSurname}`);
            });
    
            setProfessors(filteredProfessors);

            utilsService.getSuggestions(id).then((response) => {
                console.log("Suggestions:", response);
                setSuggestions(response);
            }).catch((error) => {
              console.log("Error fetching suggestions:", error);
            })
        }).catch((error) => {
            console.log("Error fetching professors:", error);
        });
    }).catch((error) => {
        console.log("Error fetching protocol:", error);
    });
    }, []);

    const handleAddSynodal = () => {
      if (selectedSynodal && !assignedSynodales.includes(selectedSynodal)) {
        setAssignedSynodales([...assignedSynodales, selectedSynodal]);
        setSelectedSynodal(""); // Reinicia el select
      }
    };
  
    const handleUploadSynodales = () => {
      console.log(assignedSynodales)
      assignedSynodales.forEach((synodal) => {
        const data = {
          protocolId: parseInt(id),
          professorId: parseInt(synodal),
        }

        console.log("Data:", data);

        sinodalService.createSinodal(data).then((response) => {
            console.log("Sinodal created:", response);
            navigate("../");
        }).catch((error) => {
            console.log("Error creating sinodal:", error);
        })
      })
      console.log("Sinodales asignados:", assignedSynodales);

    };
  
    return (
      <div className="max-w-3xl mx-auto p-6 bg-white border border-gray-200 rounded-lg shadow-md">
        {/* Información del Protocolo */}
        <h1 className="text-2xl font-bold mb-4 text-gray-800">{protocol.title}</h1>
        <p className="text-gray-600 mb-4">Resumen: {protocol.abstract}</p>
        <p className="text-gray-600 mb-4">
          Palabras clave: {protocol.keywords?.join(", ")}
        </p>
        <p className="text-gray-600 mb-4">
          Estado: <span className="font-semibold">{protocol.state}</span>
        </p>
        <p className="text-gray-600 mb-4">
          Creado el: {new Date(protocol.createdAt).toLocaleDateString()}
        </p>
        <p className="text-gray-600 mb-4">
          Estudiantes: {
            protocol.students?.map((student, index) => (
                <span key={index}>{student}</span>
            ))
          }
        </p>
        <p className="text-gray-600 mb-4">
          Directores: {
            protocol.directors?.map((director, index) => (
                <span key={index}>{director}</span>
            ))
          }
        </p>
        <div>
            <iframe
                src={protocol.fileUrl}
                className="w-full h-96"
            ></iframe>
        </div>
  
        {/* Sección de Asignar Sinodales */}
        <div className="mt-6">
          <h2 className="text-lg font-semibold mb-4 text-gray-800">
            Asignar Sinodales
          </h2>
  
          {/* Lista de Sinodales Asignados */}
          <ul className="list-disc list-inside text-gray-600 mb-4">
            {assignedSynodales.length > 0 ? (
              assignedSynodales.map((synodal, index) => (
                <li key={index}>{synodal}</li>
              ))
            ) : (
              <p className="text-gray-500">No hay sinodales asignados.</p>
            )}
          </ul>
  
          {/* Select para elegir Sinodal */}
          <div className="mb-4">
            <label
              htmlFor="synodal-select"
              className="block text-gray-700 font-semibold mb-2"
            >
              Selecciona un Sinodal
            </label>
            <select
              id="synodal-select"
              value={selectedSynodal}
              onChange={(e) => setSelectedSynodal(e.target.value)}
              className="w-full p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-400"
            >
              <option value="" disabled>
                Selecciona un sinodal
              </option>
              {professors.map((professor, index) => (
                <option key={index} value={professor.personId}>
                  {professor.name + " " + professor.paternalSurname + " " + professor.maternalSurname}
                </option>
              ))}
            </select>
          </div>
  
          {/* Botones */}
          <div className="flex space-x-4">
            <button
              onClick={handleAddSynodal}
              className="px-4 py-2 bg-green-500 text-white font-semibold rounded-lg hover:bg-green-600 transition-colors"
            >
              Agregar Sinodal
            </button>
            <button
              onClick={handleUploadSynodales}
              className="px-4 py-2 bg-blue-500 text-white font-semibold rounded-lg hover:bg-blue-600 transition-colors"
            >
              Subir Sinodales
            </button>
          </div>

          {/* Sugerencias */}
          <div className="mt-6">
            <h3 className="text-lg font-semibold mb-4 text-gray-800">
              Sugerencias
            </h3>
            <ul className="list-disc list-inside text-gray-600">
              {
                suggestions.length > 0 ? (
                  suggestions.map((suggestion, index) => (
                    <li key={index}>{suggestion}</li>
                  ))
                ) : (
                  <p className="text-gray-500">No hay sugerencias, asigna los sinodales de acuerdo a tu criterio.</p>
                )
              }
            </ul>
          </div>
        </div>
      </div>
    );
}

export default FormularioAsignarSinodales
