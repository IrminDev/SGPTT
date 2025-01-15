import React, { useEffect, useState } from 'react'
import utilsService from '../../services/utils.service'
import { useParams } from 'react-router-dom'
import ProtocolSimilarityCard from './ProtocolSImilarityCard'
import ProtocoloInfoCard from '../../components/common/ProtocoloInfoCard'
import protocolService from '../../services/protocol.service'

const PlagioProtocolo = () => {
    const { id } = useParams()
    console.log(id)

    const [protocols, setProtocols] = useState([])
    const [protocol, setProtocol] = useState({})
    const [maxScore, setmaxScore] = useState(0)

    useEffect(() => {
        protocolService.getProtocol(id).then((response) => {
            setProtocol(response[0])
            utilsService.checkSimilarProtocol(id).then((response) => {
                console.log(response)
                setProtocols(response)
                const max = Math.max(...response.map((protocol) => protocol.score))
                setmaxScore(max)
            }).catch((error) => {
                console.error('Error fetching protocols:', error)
            })
        }).catch((error) => {
            console.error('Error fetching protocol details:', error)
        })
    },[id])
    
    return (
        <div
            className='bg-gray-800 min-h-screen flex flex-col justify-evenly w-full px-10'
        >
            <h1
                className='text-4xl text-white font-semibold text-center'
            >
                Protocolo
            </h1>
            <ProtocoloInfoCard protocol={protocol} />
            <h1
                className='text-4xl text-white font-semibold text-center'
            >
                Protocolos similares
            </h1>
            <p
                className='text-white text-center mt-4'
            >
                El 100% de similitud no representa que sean iguales en su totalidad, sino que es el protocolo con mayor similitud, y con base en este, se ponderan los demás protocolos.
            </p>
            <div
                className='p-8 bg-gray-800 rounded-lg shadow-md mx-auto flex flex-row flex-wrap justify-evenly'
            >
            {
                protocols.length > 0 ? (
                    protocols.map((protocol, index) => (
                        <ProtocolSimilarityCard protocol={protocol} maxScore={maxScore} key={index} />
                    ))
                ) : (
                    <p
                        className='text-white text-center'
                    >No hay protocolos similares a este</p>
                )
            }
            </div>
        </div>
    )
}

export default PlagioProtocolo
