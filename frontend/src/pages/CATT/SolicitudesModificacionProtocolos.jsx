import React, { useEffect, useState } from 'react';
import TittleSection from '../../components/common/TittleSection';
import SolicitudesProtocolosCard from '../../components/users/Catt/SolicitudesProtocolosCard';
import changeRequestService from '../../services/changeRequest.service';

export default function SolicitudesModificacionProtocolos() {
  const [changeRequests, setChangeRequests] = useState([])

  useEffect(() => {
    changeRequestService.getAllChangeRequests().then((data) => {
      const filteredChangeRequests = data.filter((solicitud) => solicitud.state === 'PENDING')
      setChangeRequests(filteredChangeRequests)
    }).catch((error) => {
      console.log(error)
    })
  }, []);

  return (
    <div className="bg-gray-800 min-h-screen flex flex-col">
      <div className="mb-4">
        <TittleSection tittle="Solicitudes de Modificación de Protocolos" />
      </div>
      <div className="p-4 bg-gray-800 rounded-lg shadow-md w-full max-w-7xl mx-auto">
        {changeRequests.length === 0 ? (
          <p className="text-center text-slate-100">No hay solicitudes de modificación de protocolos pendientes</p>
        ) : (
          changeRequests.map((solicitud, index) => (
            <SolicitudesProtocolosCard
              key={index}
              solicitud={solicitud}
            />
          ))
        )}
      </div>
    </div>
  );
}