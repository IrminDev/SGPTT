import React, {useState, useEffect} from "react";
import TittleSection from "../../components/common/TittleSection";
import ProtocoloInfoCard from "../../components/common/ProtocoloInfoCard";
import protocolService from "../../services/protocol.service";

const ProtocolosACargo = () => {
  const [protocols, setProtocols] = useState([])

  useEffect(() => {
    const person = JSON.parse(localStorage.getItem('person'));
    console.log(person)
    protocolService.getProfessorProtocols(person.personId).then((data) => {
      setProtocols(data)
      console.log(data)
    }).catch((error) => {
      console.log(error)
    })
  }, []);

  return (
    <div className="bg-gray-800 min-h-screen flex flex-col">
      <div className="mb-4">
        <TittleSection tittle="Protocolos a Cargo" />
      </div>
      <div className="p-8 bg-gray-800 rounded-lg shadow-md w-full max-w-4xl mx-auto">
        { protocols.length > 0 ? 
          protocols.map((protocol, index) => (
            <ProtocoloInfoCard key={index} protocol={protocol} />
          ))
          :
          <h1 className="text-center text-white text-2xl">No hay protocolos a cargo.</h1>
        }
      </div>
    </div>
  );
};

export default ProtocolosACargo;