// src/components/common/AccessDenied.jsx
// Este componente no lo alcance a añadir, pero es en caso de que un usuario no cumpla con los permisos necesarios para mostrar determinado contenido
import React from "react";
import { Link } from "react-router-dom";

const AccessDenied = ({ typeUser }) => {
    return (
        <div className="flex flex-col items-center justify-center h-screen bg-gray-800 text-white">
            <h1 className="text-6xl font-bold mb-4">Acceso Denegado</h1>
            <p className="text-2xl mb-8">No tienes permisos suficientes para acceder a esta página.</p>
            <Link to={`${typeUser ? `/dashboard-${typeUser.toLowerCase()}` : "/"}`} className="text-teal-500 hover:underline">
                Volver al inicio
            </Link>
        </div>
    );
};

export default AccessDenied;