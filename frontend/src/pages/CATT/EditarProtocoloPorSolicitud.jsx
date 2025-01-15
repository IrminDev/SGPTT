import React, { useState, useEffect } from 'react'
import protocolService from '../../services/protocol.service'
import changeRequestService from '../../services/changeRequest.service'
import { useParams, useNavigate } from 'react-router-dom'
import { toast } from 'react-toastify'

const EditarProtocoloPorSolicitud = () => {
    const { id } = useParams()
    
    const navigate = useNavigate()

    const [title, setTitle] = useState('')
    const [keywords, setKeywords] = useState('')
    const [abstract, setAbstract] = useState('')
    const [changeRequest, setChangeRequest] = useState(null)

    useEffect(() => {
        changeRequestService.getChangeRequestById(id).then((data) => {
            setChangeRequest(data)
            protocolService.getProtocol(data.protocolId).then((protocol) => {
                setTitle(protocol[0].title)
                setKeywords(protocol[0].keywords.join(', '))
                setAbstract(protocol[0].abstract)
            }).catch((error) => {
                console.log(error)
            })
        })
    },[])

    const handleSubmit = (e) => {
        e.preventDefault()
        // Check if all the fields are filled
        if (!title || !keywords || !abstract) {
            toast.error('Por favor llena todos los campos')
            return
        }

        const form = {
            title: title,
            keywords: keywords.split(',').map(keyword => keyword.trim()),
            asbtract: abstract,
            workMates:  null,
            directors: null
        }
        
        console.log(form)

        const formData = new FormData()
        formData.append('updateRequest', new Blob([JSON.stringify(form)], {type: 'application/json'}))

        protocolService.updateProtocol(formData, changeRequest.protocolId).then((data) => {
            console.log(data)
            const updateRequest = {
                state: 'APPROVED',
                id: changeRequest.id
            }

            changeRequestService.updateChangeRequest(updateRequest, changeRequest.id).then((data) => {
                toast.success('Protocolo actualizado')
                navigate('../')
            }).catch((error) => {
                toast.error('Error actualizando protocolo')
                console.log(error)
            })
        }).catch((error) => {
            toast.error('Error actualizando protocolo')
            console.log(error)
        })
    }

    return (
        <div className="max-w-3xl mx-auto p-6 bg-white border border-gray-200 rounded-lg shadow-md">
            {/* Crear div que visualice la información de los cambios que se deben de hacer, indicado por la changeRequest */}
            {
                changeRequest ? (
                    <div
                        className='mb-4'
                    >
                        <p
                            className='text-2xl font-bold text-center text-gray-800'
                        >Comentarios</p>
                        <p>{changeRequest.requestComments}</p>
                        <p><span 
                            className='font-semibold text-gray-800'
                        >Fecha de solicitud:</span> {changeRequest.createdAt.substring(0,10)}</p>
                        <h1
                            className='font-bold text-center text-xl text-gray-800'
                        >Formato de solicitud de cambios</h1>
                        <div className="mt-4">
                            <iframe src={changeRequest.filePath} className=' w-full h-96'></iframe>
                        </div>
                    </div>
                ) : (
                    <p>No se encontró la solicitud de cambio</p>
                )
            }
            <h1 className="text-2xl font-bold mb-4 text-gray-800">Editar Protocolo</h1>
            <form onSubmit={handleSubmit}>
                <div className="mb-4">
                    <label className="block text-gray-700 font-semibold mb-2">Título</label>
                    <input
                        type="text"
                        value={title}
                        onChange={(e) => setTitle(e.target.value)}
                        className="w-full p-2 border border-gray-300 rounded-lg"
                        required
                    />
                </div>
                <div className="mb-4">
                    <label className="block text-gray-700 font-semibold mb-2">Palabras clave (separadas por comas)</label>
                    <input
                        type="text"
                        value={keywords}
                        onChange={(e) => setKeywords(e.target.value)}
                        className="w-full p-2 border border-gray-300 rounded-lg"
                        required
                    />
                </div>
                <div className="mb-4">
                    <label className="block text-gray-700 font-semibold mb-2">Resumen</label>
                    <textarea
                        value={abstract}
                        onChange={(e) => setAbstract(e.target.value)}
                        className="w-full p-2 border border-gray-300 rounded-lg h-32"
                        required
                    />
                </div>
                <button
                    type="submit"
                    className="px-4 py-2 bg-blue-500 text-white font-semibold rounded-lg hover:bg-blue-600 transition-colors"
                >
                    Guardar Cambios
                </button>
            </form>
        </div>
    )
}

export default EditarProtocoloPorSolicitud