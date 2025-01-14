import React from 'react';
import { Link } from 'react-router-dom';
import changeRequestService from '../../../services/changeRequest.service';
import { toast } from 'react-toastify';

const SolicitudesProtocolosCard = ({ solicitud }) => {
  const handleRechazar = () => {
    const updateRequest = {
      state: 'REJECTED',
      id: solicitud.id
    }

    changeRequestService.updateChangeRequest(updateRequest, solicitud.id).then((data) => {
      toast.success('Solicitud rechazada');
      window.location.reload();
    }).catch((error) => {
      toast.error('Error rechazando solicitud');
      console.log(error)
    })
  }

  return (
    <div className="bg-white p-6 rounded-lg shadow-md mb-4">
      <h2 className="text-2xl font-bold text-gray-900 mb-2">ID del protocolo: {solicitud.protocolId}</h2>
      <p><strong>Estado:</strong> {solicitud.state}</p>
      <p><strong>Comentarios:</strong></p>
      <p className="ml-4">{solicitud.requestComments}</p>
      <p><strong>Fecha de solicitud:</strong> {solicitud.createdAt.substring(0,10)}</p>
      <h1 className=' font-bold text-center text-xl'>Formato de solicitud de cambios</h1>
      <div className="mt-4">
        <iframe src={solicitud.filePath} className=' w-full h-96'></iframe>
      </div>
      <div className='flex justify-evenly mt-4'>
        <Link to={`./${solicitud.id}`} className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded mt-4 inline-block">Modificar protocolo</Link> 
        <button
          className='bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded mt-4 inline-block'
          onClick={handleRechazar}
        >Rechazar cambios</button>
      </div>
    </div>
  );
};

export default SolicitudesProtocolosCard;