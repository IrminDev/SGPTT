import React, { useState, useEffect} from "react";
import ProtocolosPendientesAreaCard from "../../components/users/Catt/ProtocolosPendientesAreaCard";
import TittleSection from "../../components/common/TittleSection";
import protocolService from "../../services/protocol.service";

// Información de prueba para los protocolos
const protocolos = [
  {
    id: 1,
    title: "Protocolo 1",
    abstract: "IA",
    keywords: ["Juan Pérez", "Angel Hernandez", "Hernandez Jimenez Irmin"],
    fileUrl: "http://localhost:8081/api/document/protocol/2",
  },
  {
    id: 2,
    title: "Protocolo 2",
    abstract: "TI",
    fileUrl: "http://localhost:8081/api/document/protocol/2",
    keywords: ["Maria Lopez", "Carlos Sanchez"],
  },
];

const AsignarProtocolosAcademias = () => {
  const [protocols, setProtocols] = useState([]);

  useEffect(() => {
    protocolService.getProtocolsByState("PENDING").then((response) => {
      // Set all the protocols with no element in the array "academies"
      const filteredProtocols = response.filter(protocol => protocol.academies.length === 0)
      setProtocols(filteredProtocols);
      console.log(response);
    }).catch((error) => {
      console.error('Error fetching protocols:', error);
    });
  }, [])

  return (
    <div className="bg-gray-800 min-h-screen flex flex-col">
      <div className="mb-4">
        <TittleSection tittle="Asignar Protocolos a Academias" />
      </div>
      <div className="p-8 bg-gray-800 rounded-lg shadow-md w-full">
        { protocols.length > 0 ? (
          protocols.map((protocol, index) => (
            <ProtocolosPendientesAreaCard
              key={index}
              title={protocol.title}
              abstract={protocol.abstract}
              keywords={protocol.keywords}
              fileURL={protocol.fileUrl}
              id={protocol.id}
            />
          ))
        ) : (
          <p className="text-white text-center">No hay protocolos pendientes de asignar academia</p>
        )
        }
      </div>
    </div>
  );
};

export default AsignarProtocolosAcademias;