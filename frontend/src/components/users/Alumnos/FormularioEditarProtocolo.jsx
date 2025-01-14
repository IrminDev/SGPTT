import React, {useState, useEffect} from 'react';
import Input from '../../common/Input';
import Button from '../../common/Button';
import changeRequestService from '../../../services/changeRequest.service';
import { useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';

export default function FormularioEditarProtocolo({protocol}) {
  const [formData, setFormData] = useState()
  const [comments, setComments] = useState()

  const navigate = useNavigate()

  const handleFormData = (e) => {
    setFormData(e.target.files[0])
  }

  const handleComments = (e) => {
    setComments(e.target.value)
  }

  const handleUpload = (e) => {
    e.preventDefault()
    const data = {
      requestComments: comments,
      protocolId: protocol
    }

    console.log(protocol)

    const form = new FormData()
    form.append("file", formData)
    form.append("data", new Blob([JSON.stringify(data)], { type: "application/json" }))

    changeRequestService.createChangeRequest(form).then((response) => {
      toast.success("Solicitud de cambio enviada")
      navigate('/dashboard-alumno/mi-protocolo')
    }).catch((error) => {
      console.log(error)
    })
  }

  
  return (
    <div className="w-full p-6 bg-white rounded-lg shadow-md">
      <h2 className="text-2xl font-bold text-gray-900 mb-4">Editar Protocolo</h2>
      <Input
        label="Resumen de lo que se quiere realizar"
        type="textarea"
        onChange={handleComments}
        value={comments}
        placeholder="Escribe un breve resumen de lo que modificarás"
      />
      <div className="mb-4 mt-4">
        <Input
          onChange={handleFormData}
          label="Subir protocolo"
          type="file"
          accept=".pdf"
        />
      </div>
      <Button onClick={handleUpload} label="Guardar" className="bg-teal-600 hover:bg-green-600 w-full" />
    </div>
  );
}