import React, { useState, useEffect } from "react";
import TittleSection from "../../components/common/TittleSection";
import protocolService from "../../services/protocol.service";
import ProtocolSimilarityCard from "../../components/common/ProtocolSimilarCard";

const Plagios = () => {
  const [protocols, setProtocols] = useState([]);

  useEffect(() => {
    protocolService.getAllProtocols().then((response) => {
      console.log(response.protocols);
      setProtocols(response.protocols);
    }).catch((error) => {
      console.error('Error fetching protocols:', error);
    });
  }, []);

  return (
    <div className="bg-gray-800 min-h-screen flex flex-col">
      <div className="mb-4">
        <TittleSection tittle="Verificar similitudes" />
      </div>
      <div className="p-8 bg-gray-800 rounded-lg shadow-md w-full mx-auto flex flex-row flex-wrap justify-evenly">
        {protocols.length > 0 ? (
          protocols.map((protocol, index) => (
            <ProtocolSimilarityCard protocol={protocol} key={index} />
          ))
        ) : (
          <p className="text-white text-center">No hay protocolos con qué verificar</p>
        )}
      </div>
    </div>
  );
};

export default Plagios;
