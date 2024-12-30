import React from 'react';
import Input from '../../common/Input';
import Button from '../../common/Button';

export default function FormularioEditarProtocolo() {
  return (
    <div className="w-full p-6 bg-white rounded-lg shadow-md">
      <h2 className="text-2xl font-bold text-gray-900 mb-4">Editar Protocolo</h2>
      <Input
        label="Resumen de lo que se quiere realizar"
        type="textarea"
        placeholder="Escribe un breve resumen de lo que modificarás"
      />
      <div className="mb-4 mt-4">
        <Input
          label="Subir protocolo"
          type="file"
          accept=".pdf"
        />
      </div>
      <Button label="Guardar" className="bg-teal-600 hover:bg-green-600 w-full" />
    </div>
  );
}