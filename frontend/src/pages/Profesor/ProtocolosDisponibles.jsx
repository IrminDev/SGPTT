import React, { useEffect, useState } from "react";
import TittleSection from "../../components/common/TittleSection";
import ProtocoloInfoCard from "../../components/common/ProtocoloInfoCard";
import Button from "../../components/common/Button";
import protocolService from "../../services/protocol.service";
import sinodalService from "../../services/sinodal.service";
import { toast } from "react-toastify";

const ProtocolosDisponibles = () => {
  const [protocols, setProtocols] = useState([])

  useEffect(() => {
    const person = JSON.parse(localStorage.getItem('person'));

    protocolService.getSuggestionProtocols(person.personId).then((data) => {
      const filteredProtocols = data.filter(protocol => protocol.state === "PENDING" && !protocol.synodales.find(synodal => synodal === person.name))
      setProtocols(filteredProtocols)
      console.log(data)
    }).catch((error) => {
      console.log(error)
    })
  }, []);

  const handleSelectProtocol = (protocolId) => {
    const data = {
      professorId: JSON.parse(localStorage.getItem('person')).personId,
      protocolId: protocolId
    }

    console.log(data)
    sinodalService.createSinodalByProfessor(data).then((resp) => {
      toast.success('Protocolo seleccionado exitosamente')
      setProtocols(protocols.filter(protocol => protocol.id !== protocolId))
    }).catch((error) => {
      console.log(error)
    })
  }

  return (
    <div className="bg-gray-800 min-h-screen flex flex-col">
      {/* Título de la sección */}
      <div className="mb-4">
        <TittleSection tittle="Protocolos Disponibles para Seleccionar" />
      </div>
      {/* Contenedor de las tarjetas de protocolos */}
      <div className="p-8 bg-gray-800 rounded-lg shadow-md w-full max-w-4xl mx-auto">
        { protocols.length > 0 ? (
          protocols.map((protocolo, index) => (
            <div key={index} className="mb-8">
              {/* Tarjeta de información del protocolo */}
              <ProtocoloInfoCard protocol={protocolo} />
              {/* Botón para seleccionar el protocolo */}
              <div className="mt-4 flex justify-end">
                <Button onClick={() => handleSelectProtocol(protocolo.id)} label="Ser sinodal de este protocolo" className="bg-blue-500 hover:bg-blue-600" />
              </div>
              {/* Línea divisoria */}
              <hr className="border-t border-gray-600 mt-4" />
            </div>
          ))
        ) : (
          <h1 className="text-center text-white text-2xl">No hay protocolos disponibles para ser sinodal.</h1>
        )}
      </div>
    </div>
  );
};

export default ProtocolosDisponibles;