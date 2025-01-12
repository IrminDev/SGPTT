import React, { useEffect, useState } from 'react'
import protocolService from '../../services/protocol.service'
import ProtocoloInfoCard from '../../components/common/ProtocoloInfoCard'

const InicioCATT = () => {
  const [protocols, setProtocols] = useState([])

  useEffect(() => {
    protocolService.getAllProtocols().then((data) => {
      console.log(data)
      setProtocols(data.protocols)
    }).catch((error) => {
      console.log(error)
    })
  }, [])

  return (
    <div>
      <h1
        className=' text-3xl font-bold text-center text-slate-100'
      >Últimos protocolos subidos</h1>
      { protocols ? (
        protocols.map((protocol) => (
          <ProtocoloInfoCard
            key={protocol.id}
            protocol={protocol}
          />
        ))
      ) : (
        <p>No hay protocolos registrados</p>
      )}
    </div>
  )
}

export default InicioCATT
