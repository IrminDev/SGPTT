import React, { useEffect, useState } from 'react'
import utilsService from '../../services/utils.service'
import { useParams } from 'react-router-dom'

const PlagioProtocolo = () => {
    const { protocolId } = useParams()

    const [protocols, setProtocols] = useState([])

    useEffect(() => {
        utilsService.checkSimilarProtocol(protocolId).then((response) => {
            console.log(response)
            setProtocols(response)
        }).catch((error) => {
            console.error('Error fetching protocols:', error)
        })
    },[])
    
    return (
        <div>
            {
                protocols.length > 0 ? (
                    protocols.map((protocol, index) => (
                        <div key={index}>
                            <p>{protocol.title}</p>
                        </div>
                    ))
                ) : (
                    <p
                        className='text-white text-center'
                    >No hay protocolos similares a este</p>
                )
            }
        </div>
    )
}

export default PlagioProtocolo
