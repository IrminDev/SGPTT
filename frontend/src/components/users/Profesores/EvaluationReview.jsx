import React from "react";

const EvaluationReview = ({ evaluation }) => {

  const questions = [
    "¿El título corresponde al producto esperado?",
    "¿El resumen expresa claramente la propuesta del TT?",
    "¿Las palabras clave han sido clasificadas adecuadamente?",
    "¿La presentación del problema a resolver es comprensible?",
    "¿El objetivo es preciso y relevante?",
    "¿El planteamiento del problema y la tentativa de solución son claros?",
    "¿Sus contribuciones o beneficios están completamente justificados?",
    "¿Su viabilidad es adecuada?",
    "¿La propuesta metodológica es pertinente?",
    "¿El calendario de actividades es adecuado?",
  ];

  return (
    <div className="max-w-4xl mx-auto p-6 bg-white border border-gray-200 rounded-lg shadow-md">
      <h1 className="text-2xl font-bold mb-6 text-gray-800">
        Detalle de Evaluación
      </h1>

      <div className="mb-6">
        <p>
          <span className="font-semibold text-gray-700">Estado de Aprobación:</span>{" "}
          {evaluation.isApproved ? (
            <span className="text-green-600 font-semibold">Aprobado</span>
          ) : (
            <span className="text-red-600 font-semibold">No Aprobado</span>
          )}
        </p>
        <p>
          <span className="font-semibold text-gray-700">Comentarios:</span>{" "}
          {evaluation.comments}
        </p>
      </div>

      <h2 className="text-lg font-semibold mb-4 text-gray-800">
        Criterios de Evaluación
      </h2>

      <div className="space-y-4">
        {evaluation.evaluationCriteria.map((criterion, index) => (
          <div
            key={criterion.evaluationId}
            className="p-4 border rounded-md shadow-sm bg-gray-50"
          >
            <p className="font-medium text-gray-800">
              {index + 1}. {questions[index]}
            </p>
            <p>
              <span className="font-semibold text-gray-700">Resultado:</span>{" "}
              {criterion.criterionResult ? (
                <span className="text-green-600 font-semibold">Cumple</span>
              ) : (
                <span className="text-red-600 font-semibold">No cumple</span>
              )}
            </p>
            {criterion.criterionComments && (
              <p>
                <span className="font-semibold text-gray-700">Comentarios:</span>{" "}
                {criterion.criterionComments}
              </p>
            )}
          </div>
        ))}
      </div>
    </div>
  );
};

export default EvaluationReview;
