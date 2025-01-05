import React, {useState, useEffect} from 'react';
import TittleSection from '../../components/common/TittleSection';
import FormularioEditarProtocolo from '../../components/users/Alumnos/FormularioEditarProtocolo';
import ProtocoloInfoCard from '../../components/common/ProtocoloInfoCard';
import protocolService from '../../services/protocol.service';
import changeRequestService from '../../services/changeRequest.service';

export default function EditarProtocolo() {
  const [loading, setLoading] = useState(true)
  const [protocol, setProtocol] = useState({
    id: 0
  })
  const [changeRequests, setChangeRequests] = useState([])
  
  useEffect(() => {
    const person = JSON.parse(localStorage.getItem("person"));
    protocolService.getStudentProtocols(person.personId).then((response) => {
      console.log(response)
      response.forEach((protocolo) => {
        if (protocolo.state === "PENDING") {
          protocolService.getProtocol(protocolo.id).then((response) => {
            setProtocol(response[0]);
            changeRequestService.getProtocolChangeRequests(response[0].id).then((response) => {
              setChangeRequests(response)
              setLoading(false);
              console.log(response)
            }).catch((error) => {
              console.error(error)
            })
          }).catch((error) => {
            console.error(error)
          })
        }
      })
    })


  }, [])

  return (
    <div className="bg-gray-800 min-h-screen flex flex-col">
      <div className="mb-4">
        <TittleSection tittle="Editar Protocolo" />
      </div>
      <div className="p-4 bg-gray-800 rounded-lg shadow-md w-full max-w-4xl mx-auto">
        {loading ? <p>Cargando...</p> : <ProtocoloInfoCard protocolo={protocol} />}
      </div>
      <div className="flex justify-center items-center mt-4 relative">
        {/* Tarjeta para la edición de protocolo */}
        <div className="w-full max-w-7xl bg-gray-800 rounded-lg shadow-md overflow-hidden mt-5">
          {/* Contenido de la tarjeta en dos columnas SeccionDeComentarios y FormularioEditarProtocolo respectivamente */}
          <div className="flex flex-col md:flex-row justify-evenly items-center">
            {/* Seccion de solicitudes de cambio anteriores */}
            <div className="w-full md:w-5/12 mb-10">
              {changeRequests.map((changeRequest, index) => (
                <div key={index} className="p-6 bg-gray-700 rounded-lg shadow-md w-full max-w-4xl mx-auto mb-8">
                  <h2 className="text-2xl font-bold text-white mb-4">Solicitud de cambio {changeRequest.id}</h2>
                  <p className=' text-white mt-5'>Comentarios: {changeRequest.requestComments}</p>
                  <p className=' text-white mt-5 mb-5'>Creado: {changeRequest.createdAt.substring(0,10)}</p>
                  <p className=' text-white mt-5 mb-5'>Estado: {changeRequest.state}</p>
                  <a className=' rounded-lg bg-indigo-800 px-5 py-3 text-white font-medium' href={changeRequest.filePath}>Mirar archivo</a>
                </div>
              ))}
            </div>
            {/* FormularioEditarProtocolo */}
            <div className="w-full md:w-5/12 mb-10">
              <FormularioEditarProtocolo protocol={protocol.id} />
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
