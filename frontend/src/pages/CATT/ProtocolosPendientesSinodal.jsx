import React, { useState, useEffect} from "react";
import ProtocolosPendientesSinodalCard from "../../components/users/Catt/ProtocolosPendientesSinodalCard";
import TittleSection from "../../components/common/TittleSection";
import protocolService from "../../services/protocol.service";

// Información de prueba para los protocolos
const protocols = [
  {
    protocolName: "Protocolo 1",
    area: "Circuitos",
    career: "IA",
    members: ["Juan Pérez", "Angel Hernandez", "Hernandez Jimenez Irmin"],
  },
  {
    protocolName: "Protocolo 2",
    area: "Redes",
    career: "TI",
    members: ["Maria Lopez", "Carlos Sanchez"],
  },
];

// Información de prueba para los sinodales disponibles
const sinodalOptions = [
  { value: "A", label: "Profe A" },
  { value: "B", label: "Profe B" },
  { value: "C", label: "Profe C" },
  { value: "X", label: "Profe X" },
  { value: "Y", label: "Profe Y" },
  { value: "Z", label: "Profe Z" },
  { value: "1", label: "Profe 1" },
  { value: "2", label: "Profe 2" },
  { value: "3", label: "Profe 3" },
];

const ProtocolosPendientesSinodal = () => {
  const [protocols, setProtocols] = useState([])

  useEffect(() => {
    protocolService.getProtocolsByState("PENDING").then((response) => {
      setProtocols(response);
    }).catch((error) => {
      console.error('Error fetching protocols:', error);
    });
  },[])

  return (
    <div className="bg-gray-800 min-h-screen flex flex-col">
      <div className="mb-4">
        <TittleSection tittle="Protocolos Pendientes de Sinodales" />
      </div>
      <div className="p-8 bg-gray-800 rounded-lg shadow-md w-full max-w-4xl mx-auto">
        { protocols.length > 0 ? (
          protocols.map((protocol, index) => (
            <ProtocolosPendientesSinodalCard
              key={index}
              protocolName={protocol.protocolName}
              area={protocol.area}
              career={protocol.career}
              members={protocol.members}
              sinodalOptions={sinodalOptions}
            />
          ))
        ) : (
          <p className="text-white text-center">No hay protocolos pendientes de asignar sinodales</p>
        )}
      </div>
    </div>
  );
};

export default ProtocolosPendientesSinodal;