import React, { useState } from 'react';
import assessmentService from '../../../services/assessment.service';
import { useNavigate } from 'react-router-dom'; 
import { toast } from 'react-toastify';

const SurveyForm = ({id, professorId}) => {
  const navigate = useNavigate();
  
  const [responses, setResponses] = useState([
    { criterion: "FIRST", result: null, comment: '' },
    { criterion: "SECOND", result: null, comment: '' },
    { criterion: "THIRD", result: null, comment: '' },
    { criterion: "FOURTH", result: null, comment: '' },
    { criterion: "FIFTH", result: null, comment: '' },
    { criterion: "SIXTH", result: null, comment: '' },
    { criterion: "SEVENTH", result: null, comment: '' },
    { criterion: "EIGHTH", result: null, comment: '' },
    { criterion: "NINTH", result: null, comment: '' },
    { criterion: "TENTH", result: null, comment: '' },
  ]);
  const [generalComment, setGeneralComment] = useState('');

  const questions = [
    "¿El título corresponde al producto esperado?",
    "¿El resumen expresa claramente la propuesta del TT?",
    "¿Las palabras clave han sido clasificadas adecuadamente?",
    "¿La presentación del problema a resolver es comprensible?",
    "¿El objetivo es previso y relevante?",
    "¿El planteamiento del problema y la tentativa de solución son claros?",
    "¿Sus contribuciones o beneficios están completamente justificados?",
    "¿Su viabilidad es adecuada?",
    "¿La propuesta metodológica es pertinente?",
    "¿El calendario de actividades es adecuado?"
  ]

  const handleAnswerChange = (index, answer) => {
    const updatedResponses = [...responses];
    updatedResponses[index].result = answer;
    setResponses(updatedResponses);
  };

  const handleCommentChange = (index, comment) => {
    const updatedResponses = [...responses];
    updatedResponses[index].comment = comment;
    setResponses(updatedResponses);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if(responses.some(response => response.result === null)) {
        return;
        toast.error("Por favor, responde todas las preguntas");
    }
    const data = {
        protocolId: id,
        evaluationDTO: {
            professorId: professorId,
            evaluationCriteria: responses,
            comments: generalComment
        }
    }

    assessmentService.createAssessment(data).then((response) => {
        toast.success("Evaluación creada exitosamente");
        console.log("Assessment created successfully:", response);
        navigate('../');
    }).catch((error) => {
        toast.error("Error al crear la evaluación");
        console.log("Error creating assessment:", error);
    });
  };

  return (
    <form
      onSubmit={handleSubmit}
      className="max-w-2xl mx-auto p-6 bg-white border border-gray-200 rounded-lg shadow-md"
    >
      <h1 className="text-2xl font-bold mb-6 text-gray-800">Formulario de evaluación</h1>

      {responses.map((response, index) => (
        <div key={index} className="mb-6">
          <h2 className="text-lg font-semibold text-gray-700 mb-2">Pregunta {index + 1}</h2>
          <p className=' text-gray-800 mb-3'>{questions[index]}</p>
          <div className="flex items-center space-x-4 mb-2">
            <label className="flex items-center space-x-2">
              <input
                type="radio"
                name={`question-${index}`}
                value={true}
                checked={response.result === true}
                onChange={() => handleAnswerChange(index, true)}
                className="text-blue-500 focus:ring-blue-400"
              />
              <span>Sí</span>
            </label>
            <label className="flex items-center space-x-2">
              <input
                type="radio"
                name={`question-${index}`}
                value={false}
                checked={response.result === false}
                onChange={() => handleAnswerChange(index, false)}
                className="text-blue-500 focus:ring-blue-400"
              />
              <span>No</span>
            </label>
          </div>
          <textarea
            placeholder="Agregar un comentario (opcional)"
            value={response.comment}
            onChange={(e) => handleCommentChange(index, e.target.value)}
            className="w-full p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-400"
          ></textarea>
        </div>
      ))}

      <div className="mb-6">
        <h2 className="text-lg font-semibold text-gray-700 mb-2">Comentario general</h2>
        <textarea
          placeholder="Add a general comment"
          value={generalComment}
          onChange={(e) => setGeneralComment(e.target.value)}
          className="w-full p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-400"
        ></textarea>
      </div>

      <button
        type="submit"
        className="w-full px-4 py-2 bg-blue-500 text-white font-semibold rounded-lg hover:bg-blue-600 transition-colors"
      >
        Submit
      </button>
    </form>
  );
};

export default SurveyForm;
