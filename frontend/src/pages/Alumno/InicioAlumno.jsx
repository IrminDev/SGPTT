import React, { useState, useEffect} from 'react'
import protocolService from '../../services/protocol.service'
import ProtocoloInfoCard from '../../components/common/ProtocoloInfoCard'

const InicioAlumno = () => {
    const [lastProtocol, setLastProtocol] = useState(null)
    const [person, setPerson] = useState(JSON.parse(localStorage.getItem('person')))

    useEffect(() => {
        console.log(person)
        protocolService.getStudentProtocols(person.personId).then((data) => {
            // Fetch for the protocol with the highest ID
            let max = 0
            data.forEach(protocol => {
                if (protocol.id > max) {
                    max = protocol.id
                    setLastProtocol(protocol)
                }
            })
        }).catch((error) => {
            console.log(error)
        })
    }, [])

    console.log(lastProtocol)
    
    return (
        <div>
            <h1
                className=' text-3xl font-bold text-center text-slate-100'
            >Tu protocolo más reciente</h1>
            {
                lastProtocol ? (
                    <ProtocoloInfoCard
                        protocol={lastProtocol}
                    />
                ) : (
                    <p
                        className='text-center text-slate-100'
                    >No tienes protocolos registrados</p>
                )
            }
        </div>
    )
}

export default InicioAlumno
