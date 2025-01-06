import React, { useEffect, useState } from 'react';
import TittleSection from '../../components/common/TittleSection';
import ProtocolCard from '../../components/common/ProtocolCard';
import protocolService from '../../services/protocol.service';
import { useNavigate } from 'react-router-dom';

export default function RevisarProtocolo() {
  const navigate = useNavigate();
  
  const [protocols, setProtocols] = useState([])

  useEffect(() => {
    const person = JSON.parse(localStorage.getItem('person'));
    protocolService.getSinodalProtocols(person.personId).then((data) => {
      // filter all the protocols with status "EVALUATING"
      const filteredProtocols = data.filter(protocol => protocol.state === "EVALUATING")
      setProtocols(filteredProtocols)
    }).catch((error) => {
      if(error.status === 403) {
        navigate('/')
      }
    }); 
  }, []);

  const protocolos = [
    {
      id: 1,
      title: "Título de prueba 1",
      keywords: ["Palabra1", "Palabra2", "Palabra3"],
      asbtract: "Este es el resumen del protocolo 1.",
      fileUrl: "ruta/al/archivo1.pdf",
      students: ["Integrante1", "Integrante2", "Integrante3"],
      directors: "Nombre del Director 1",
      state: "Rechazado",
      createdAt: "2021-10-01T00:00:00.000Z",
    },
    {
      id: 2,
      title: "Título de prueba 1",
      keywords: ["Palabra1", "Palabra2", "Palabra3"],
      asbtract: "Este es el resumen del protocolo 1.",
      fileUrl: "ruta/al/archivo1.pdf",
      students: ["Integrante1", "Integrante2", "Integrante3"],
      directors: "Nombre del Director 1",
      state: "Rechazado",
      createdAt: "2021-10-01T00:00:00.000Z",
    },
  ];

  return (
    <div className="bg-gray-800 min-h-screen flex flex-col">
      <div className="mb-4">
        <TittleSection tittle="Revisar Protocolos" />
      </div>
      <div className="flex flex-row flex-wrap items-center justify-between p-4 bg-gray-800 rounded-lg shadow-md w-full">
        {
          protocols.length > 0 ? 
          protocols.map((protocol, index) => (
            <ProtocolCard key={index} protocol={protocol} />
          ))
          :
          <h1 className="text-center w-full text-white text-2xl">No hay protocolos a revisar.</h1>
        }
      </div>
    </div>
  );
}