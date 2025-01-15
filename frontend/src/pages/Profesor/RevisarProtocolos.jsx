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
      console.log(data)
      const filteredProtocols = data.filter(protocol => protocol.state === "EVALUATING")
      setProtocols(filteredProtocols)
    }).catch((error) => {
      if(error.status === 403) {
        navigate('/')
      }
    }); 
  }, []);


  return (
    <div className="bg-gray-800 min-h-screen flex flex-col">
      <div className="mb-4">
        <TittleSection tittle="Revisar Protocolos" />
      </div>
      <div className="flex flex-row flex-wrap items-center justify-evenly p-4 bg-gray-800 rounded-lg shadow-md w-full">
        {
          protocols.length > 0 ? 
          protocols.map((protocol, index) => (
            <ProtocolCard key={index}
              id={protocol.id}
              title={protocol.title}
              abstract={protocol.abstract}
              students={protocol.students}
              directors={protocol.directors}
              
            />
          ))
          :
          <h1 className="text-center w-full text-white text-2xl">No hay protocolos a revisar.</h1>
        }
      </div>
    </div>
  );
}