import React, { useEffect, useState} from 'react'
import { useParams } from 'react-router-dom'
import ProtocoloInfoCard from '../../components/common/ProtocoloInfoCard'
import SurveyForm from '../../components/users/Profesores/SurveyForm'
import protocolService from '../../services/protocol.service'

const EvaluarProtocolo = () => {
    const { id } = useParams()
    const [person, setPerson] = useState(JSON.parse(localStorage.getItem('person')));
    const [protocol, setProtocol] = useState({})

    useEffect(() => {
        protocolService.getProtocol(id).then((response) => {
            console.log("Protocol:", response[0]);
            setProtocol(response[0]);
        }).catch((error) => {
            console.log("Error fetching protocol:", error);
        })
    }, []);

    const protocolo = {
        title: "Título de prueba 1",
        keywords: ["Palabra1", "Palabra2", "Palabra3"],
        abstract: "Este es el resumen del protocolo 1.",
        fileUrl: "http://localhost:8081/api/document/protocol/2",
        students: ["Integrante1", "Integrante2", "Integrante3"],
        directors: "Nombre del Director 1",
        state: "Rechazado",
        createdAt: "2021-10-01T00:00:00.000Z",
    };
  
    return (
    <div>
        <ProtocoloInfoCard protocol={protocol} />
        <SurveyForm id={id} professorId={person.personId} />
    </div>
  )
}

export default EvaluarProtocolo
