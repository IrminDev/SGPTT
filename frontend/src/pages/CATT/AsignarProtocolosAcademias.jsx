import React from "react";
import ProtocolosPendientesAreaCard from "../../components/users/Catt/ProtocolosPendientesAreaCard";
import TittleSection from "../../components/common/TittleSection";

// Información de prueba para los protocolos
const protocols = [
  {
    protocolName: "Protocolo 1",
    career: "IA",
    members: ["Juan Pérez", "Angel Hernandez", "Hernandez Jimenez Irmin"],
  },
  {
    protocolName: "Protocolo 2",
    career: "TI",
    members: ["Maria Lopez", "Carlos Sanchez"],
  },
];

// Información de prueba para las áreas disponibles
const areaOptions = [
  { value: "A", label: "Area A" },
  { value: "B", label: "Area B" },
  { value: "C", label: "Area C" },
  { value: "X", label: "Area X" },
  { value: "Y", label: "Area Y" },
  { value: "Z", label: "Area Z" },
  { value: "1", label: "Area 1" },
  { value: "2", label: "Area 2" },
  { value: "3", label: "Area 3" },
];

const AsignarProtocolosAcademias = () => {
  return (
    <div className="bg-gray-800 min-h-screen flex flex-col">
      <div className="mb-4">
        <TittleSection tittle="Asignar Protocolos a Academias" />
      </div>
      <div className="p-8 bg-gray-800 rounded-lg shadow-md w-full max-w-4xl mx-auto">
        {protocols.map((protocol, index) => (
          <ProtocolosPendientesAreaCard
            key={index}
            protocolName={protocol.protocolName}
            career={protocol.career}
            members={protocol.members}
            areaOptions={areaOptions}
          />
        ))}
      </div>
    </div>
  );
};

export default AsignarProtocolosAcademias;