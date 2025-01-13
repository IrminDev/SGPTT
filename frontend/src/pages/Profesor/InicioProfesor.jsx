import React, { useState, useEffect} from 'react'
import protocolService from '../../services/protocol.service'
import ProtocoloInfoCard from '../../components/common/ProtocoloInfoCard'

const IniciProfesor = () => {
    const [protocols, setProtocols] = useState([])
    const [person, setPerson] = useState(JSON.parse(localStorage.getItem('person')))

    useEffect(() => {
        console.log(person)
        protocolService.getSinodalProtocols(person.personId).then((data) => {
            setProtocols(data)
        }).catch((error) => {
            console.log(error)
        })
    }, [])
    
    return (
        <div>
            <h1
                className=' text-3xl font-bold text-center text-slate-100'
            >Tus protocolos donde eres sinodal</h1>
            {
                protocols.length === 0 ? (
                  <p
                  className='text-center text-slate-100'
                  >No tienes protocolos registrados</p>
                ) : (
                  protocols.map((protocol, index) => (
                    <ProtocoloInfoCard
                        key={index}
                        protocol={protocol}
                    />
                  ))
                )
            }
        </div>
    )
}

export default IniciProfesor
