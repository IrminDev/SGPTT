import React, { useState, useEffect} from "react";
import TittleSection from "../../components/common/TittleSection";
import protocolService from "../../services/protocol.service";
import ProtocolSinodalCard from "../../components/common/ProtocolSinodalCard";

const ProtocolosPendientesSinodal = () => {
  const [protocols, setProtocols] = useState([])

  useEffect(() => {
    protocolService.getProtocolsByState("PENDING").then((response) => {
      // Set all the protocols with less than 3 elements in the array "synodales" and at least 1 element in the array "academies"
      const filteredProtocols = response.filter(protocol => protocol.synodales.length < 3 && protocol.academies.length > 0)

      setProtocols(filteredProtocols);

      console.log(response);
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
            <ProtocolSinodalCard protocol={protocol} key={index} />
          ))
        ) : (
          <p className="text-white text-center">No hay protocolos pendientes de asignar sinodales</p>
        )}
      </div>
    </div>
  );
};

export default ProtocolosPendientesSinodal;