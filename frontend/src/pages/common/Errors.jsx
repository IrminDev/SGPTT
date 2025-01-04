import React from "react";
import { Link } from "react-router-dom";

const Errors = ({ typeUser }) => {
  return (
    <div className="flex flex-col items-center justify-center h-screen bg-gray-800 text-white">
      <h1 className="text-6xl font-bold mb-4">404</h1>
      <p className="text-2xl mb-8">Página no encontrada</p>
      <Link to={`${typeUser ? `/dashboard-${typeUser.toLowerCase()}` : "/"}`} className="text-teal-500 hover:underline">
        Volver al inicio
      </Link>
    </div>
  );
};

export default Errors;