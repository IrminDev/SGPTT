import React, { useEffect, useState } from 'react'
import protocolService from '../../services/protocol.service'
import assessmentService from '../../services/assessment.service'
import { toast } from 'react-toastify';
import { useNavigate } from 'react-router-dom';

const questions = [
    "¿El título corresponde al producto esperado?",
    "¿El resumen expresa claramente la propuesta del TT?",
    "¿Las palabras clave han sido clasificadas adecuadamente?",
    "¿La presentación del problema a resolver es comprensible?",
    "¿El objetivo es previso y relevante?",
    "¿El planteamiento del problema y la tentativa de solución son claros?",
    "¿Sus contribuciones o beneficios están completamente justificados?",
    "¿Su viabilidad es adecuada?",
    "¿La propuesta metodológica es pertinente?",
    "¿El calendario de actividades es adecuado?"
]

const CorregirProtocolo = () => {
    const navigate = useNavigate()

    const [evaluations, setEvaluations] = useState([])
    const [person, setPerson] = useState(JSON.parse(localStorage.getItem('person')))
    const [protocol, setProtocol] = useState(null)
    const [errorMessage, setErrorMessage] = useState('')
    const [file, setFile] = useState(null)

    useEffect(() => {
        protocolService.getStudentProtocols(person.personId).then((data) => {
            const filteredProtocols = data.filter(protocol => protocol.state === 'CORRECTIONS')
            if (filteredProtocols.length > 0) {
                setProtocol(filteredProtocols[0])
                assessmentService.getEvaluations(filteredProtocols[0].id).then((resp) => {
                    setEvaluations(resp)
                    console.log(resp)
                }).catch((error) => {
                    console.log(error)
                })
            } else {
                setErrorMessage('No hay protocolos pendientes de corrección.')
            }
        }).catch((error) => {
            console.log(error)
            setErrorMessage('Error al cargar los protocolos.')
        })
    }, [])

    const handleFileChange = (e) => {
        setFile(e.target.files[0])
    }

    const handleFileUpload = () => {
        if (file && protocol) {
            const formData = new FormData()
            formData.append('file', file)
            protocolService.updateProtocolFile(formData, protocol.id).then((resp) => {
                console.log(resp)
                protocolService.changeProtocolStatus({ protocolId: protocol.id, state: 'EVALUATING' }).then((response) => {
                    assessmentService.deleteAssessment(protocol.id).then((res) => {
                        toast.success('Archivo subido exitosamente')
                        navigate('../mi-protocolo')
                    }).catch((error) => {
                        toast.error('Error al subir archivo')
                        console.log(error)
                    })
                }).catch((error) => {
                    toast.error('Error al subir archivo')
                    console.log(error)
                })
            }).catch((error) => {
                toast.error('Error al subir archivo')
                console.log(error)
            })
        } else {
            toast.error('Seleccione un archivo')
        }
    }

    return (
        <div className="max-w-4xl mx-auto p-6 bg-white border border-gray-200 rounded-lg shadow-md">
            {errorMessage ? (
                <p className="text-red-600 font-semibold">{errorMessage}</p>
            ) : protocol ? (
                <div>
                    <h1 className="text-2xl font-bold mb-4 text-gray-800">Corrección de Protocolo</h1>
                    <p className="mb-4"><span className="font-semibold">Título:</span> {protocol.title}</p>
                    <h2 className="text-lg font-semibold mb-2 text-gray-700">Evaluaciones</h2>
                    {evaluations.map((evalItem, index) => (
                        <div key={index} className="mb-6 border p-4 rounded-lg shadow-sm bg-gray-50">
                            <p><span className="font-semibold">Evaluador {index + 1}:</span> {evalItem.professorName}</p>
                            <p><span className="font-semibold">Comentarios Generales:</span> {evalItem.comments}</p>
                            <div className="list-disc list-inside mt-2">
                                {evalItem.evaluationCriteria.map((criterion, idx) => (
                                    <div key={idx} className="mt-1">
                                        <p><span className="font-semibold">{questions[idx]}</span> - {criterion.criterionResult ? '✔️ Cumple' : '❌ No cumple'}</p>
                                        {criterion.criterionComments && (
                                            <p className="ml-4 text-sm text-gray-600">Comentario: {criterion.criterionComments}</p>
                                        )}
                                    </div>
                                ))}
                            </div>
                        </div>
                    ))}
                    <h2 className="text-lg font-semibold mb-2 text-gray-700">Subir Archivo Corregido</h2>
                    <input type="file" onChange={handleFileChange} className="mb-4" />
                    <button
                        onClick={handleFileUpload}
                        className="px-4 py-2 bg-green-500 text-white font-semibold rounded-lg hover:bg-green-600 transition-colors"
                    >
                        Subir Archivo
                    </button>
                </div>
            ) : (
                <p>Cargando...</p>
            )}
        </div>
    )
}

export default CorregirProtocolo
