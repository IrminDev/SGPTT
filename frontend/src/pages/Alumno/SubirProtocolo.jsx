import React, { useState, useEffect } from "react";
import TittleSection from "../../components/common/TittleSection";
import FormularioSubirProtocolo from "../../components/users/Alumnos/FormularioSubirProtocolo";
import OptionBar from "../../components/common/OptionBar";
import protocolService from "../../services/protocol.service";

export default function SubirProtocolo() {
  const [tipoProtocolo, setTipoProtocolo] = useState("Primer Curse");
  const [enabled, setEnabled] = useState(true)

  useEffect(() => {
    const person = JSON.parse(localStorage.getItem("person"));
    protocolService.getStudentProtocols(person.personId).then((response) => {
      if(response.length !== 0){
        response.map((protocol) => {
          if(protocol.state === "PENDING"){
            setEnabled(false)
            return
          }
        });
      }
    });
  }, []);

  const opciones = ["Primer Curse", "Recurse"];

  return (
    <div className="bg-gray-800 min-h-screen flex flex-col">
      <div className="mb-4">
        <TittleSection tittle="Subir Protocolo" />
      </div>
      {enabled ? <>
        <div className="flex justify-center items-center mt-4 relative">
        <div className="w-[80%] max-w-4xl bg-white rounded-lg shadow-md overflow-hidden">
          <OptionBar
            opciones={opciones}
            onSelect={setTipoProtocolo}
            selectedOption={tipoProtocolo}
          />
        </div>
      </div>
      <div className="flex justify-center items-center mt-4">
        <div className="w-full max-w-4xl bg-white rounded-lg shadow-md overflow-hidden">
          <div className="p-6">
            <FormularioSubirProtocolo tipoProtocolo={tipoProtocolo} />
          </div>
        </div>
      </div>
      </> : <>
        <div className="flex justify-center items-center mt-4">
          <div className="w-full max-w-4xl bg-white rounded-lg shadow-md overflow-hidden">
            <div className="p-6">
              <h1 className="text-center text-xl font-semibold text-red-600">Ya tienes un protocolo pendiente de aprobación</h1>
            </div>
          </div>
        </div>
      </>}
    </div>
  );
}
