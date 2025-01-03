import React, {useState, useEffect} from 'react';
import Input from '../../common/Input';
import Button from '../../common/Button';
import changeRequestService from '../../../services/changeRequest.service';


export default function FormularioEditarProtocolo() {
  const [person, setPerson] = useState(JSON.parse(localStorage.getItem("person")))
  const [formData, setFormData] = useState()
  const [comments, setComments] = useState()

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
      file: formData,
      protocolId: 1
    }

    changeRequestService.createChangeRequest(data).then((response) => {
      console.log(response)
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