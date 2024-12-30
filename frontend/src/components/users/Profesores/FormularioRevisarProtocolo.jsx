import React, { useState } from 'react';
import Input from '../../common/Input';
import Button from '../../common/Button';

export default function FormularioRevisarProtocolo() {
  const [comentario, setComentario] = useState('');
  const [decision, setDecision] = useState('');
  const [justificacion, setJustificacion] = useState(null);

  const handleComentarioChange = (e) => setComentario(e.target.value);
  const handleDecisionChange = (e) => setDecision(e.target.value);
  const handleJustificacionChange = (e) => setJustificacion(e.target.files[0]);

  return (
    <div className="w-full p-6 bg-white rounded-lg shadow-md">
      <h2 className="text-2xl font-bold text-gray-900 mb-4">Revisar Protocolo</h2>
      <Input
        label="Comentario"
        type="textarea"
        value={comentario}
        onChange={handleComentarioChange}
        placeholder="Escribe tu comentario"
      />
      <div className="mb-4 mt-4">
        <Input
          label="Decisión Final"
          type="option"
          value={decision}
          onChange={handleDecisionChange}
          options={[
            { value: 'Aprobado', label: 'Aprobado' },
            { value: 'Rechazado', label: 'Rechazado' },
          ]}
        />
      </div>
      <div className="mb-4 mt-4">
        <Input
          label="Adjuntar Justificación"
          type="file"
          accept=".pdf"
          onChange={handleJustificacionChange}
        />
      </div>
      <Button label="Guardar" className="bg-teal-600 hover:bg-green-600 w-full" />
    </div>
  );
}