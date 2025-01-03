import React, { useEffect } from "react";
import Card from "../../components/main/Card";
import TittleSection from "../../components/common/TittleSection";

// Images
import Student from "./../../assets/images/search.svg";

function Inicio() {
    // El objeto debe contener dos parámetros: el texto y (opcionalmente) una imagen que se le quiera asignar a ese texto
    const students = [
        { name: "Trejo Flores Johann Daniel", image: Student },
        { name: "Garcia Garcia Aram Jesua", image: Student },
        { name: "Hernandez Diaz Angel Roberto", image: Student },
    ];

    useEffect(() => {
        const person = JSON.parse(localStorage.getItem("person"));
        console.log(person);
    }, []);

    return (
        <div className="bg-gray-800 min-h-screen flex flex-col">
            <div className="mb-4">
                <TittleSection tittle="Panel de Control" />
            </div>
            <div className="p-8 bg-gray-800 rounded-lg shadow-md w-full mx-auto">
                <div className="flex flex-wrap gap-4 w-full">
                    <Card title="Tu(s) compañero(s) de protocolo" elements={students} />
                    <Card title="Tu(s) compañero(s) de protocolo" elements={students} />
                    <Card title="Tu(s) compañero(s) de protocolo" elements={students} />
                    <Card title="Tu(s) compañero(s) de protocolo" elements={students} />
                </div>
            </div>
        </div>
    );
}

export default Inicio;