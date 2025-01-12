import React, { useEffect, useState} from 'react'
import { useParams } from 'react-router-dom'
import ProtocoloInfoCard from '../../components/common/ProtocoloInfoCard'
import SurveyForm from '../../components/users/Profesores/SurveyForm'
import protocolService from '../../services/protocol.service'
import assessmentService from '../../services/assessment.service'
import EvaluationReview from '../../components/users/Profesores/EvaluationReview'

const EvaluarProtocolo = () => {
    const { id } = useParams()
    const [person, setPerson] = useState(JSON.parse(localStorage.getItem('person')));
    const [protocol, setProtocol] = useState({})
    const [evaluation, setEvaluation] = useState(null)

    useEffect(() => {
        protocolService.getProtocol(id).then((response) => {
            console.log("Protocol:", response[0]);
            console.log(person)
            setProtocol(response[0]);
            assessmentService.getEvaluations(id).then((data) => {
                console.log("Evaluations:", data);
                // filter the evaluation of the current professor (person.personId === evaluation.professorId)
                const currentEvaluation = data.find(evaluation => evaluation.professorId === person.personId)
                console.log("Current evaluation:", currentEvaluation);
                if(currentEvaluation) {
                    setEvaluation(currentEvaluation);
                }
            }).catch((error) => {
                console.log("Error fetching evaluations:", error);
            })
        }).catch((error) => {
            console.log("Error fetching protocol:", error);
        })
    }, []);
  
    return (
    <div>
        <ProtocoloInfoCard protocol={protocol} />
        {
            evaluation ? (
                <EvaluationReview evaluation={evaluation} />
            ) : ( 
                <SurveyForm id={id} professorId={person.personId} />
            )
        }
    </div>
  )
}

export default EvaluarProtocolo
