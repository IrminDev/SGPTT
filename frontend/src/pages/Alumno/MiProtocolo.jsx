import React, { useState, useEffect } from "react";
import TittleSection from "../../components/common/TittleSection";
import ProtocoloInfoCard from "../../components/common/ProtocoloInfoCard";
import protocolService from "../../services/protocol.service";

const MiProtocolo = () => {
  const [protocol, setProtocol] = useState([]);

  useEffect(() => {
    const person = JSON.parse(localStorage.getItem("person"));
    protocolService.getStudentProtocols(person.personId).then((response) => {
      setProtocol(response);
      console.log(response);
    })
  }, []);

  return (
    <div className="bg-gray-800 min-h-screen flex flex-col">
      <div className="mb-4">
        <TittleSection tittle="Mis Protocolos" />
      </div>
      <div className="p-8 bg-gray-800 rounded-lg shadow-md w-full max-w-4xl mx-auto">
        {protocol?.map((protocolo, index) => (
          <ProtocoloInfoCard key={index} protocolo={protocolo} />
        ))}
      </div>
    </div>
  );
};

export default MiProtocolo;