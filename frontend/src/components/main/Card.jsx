import React from "react";
import ElementList from "./ElementList";
import "../../assets/styles/auth/Animation.css"

const Card = ({ title, elements = [] }) => {
    return (
        <div className="p-4 bg-green-200 rounded-lg w-max h-max">
            <h2 className="text-black font-bold mb-4 revalia-regular">{title}</h2>
            {elements.length === 0 ? (
                <p className="text-red-500 text-center">No hay información para mostrar</p>
            ) : (
                <div className="flex flex-col space-y-4">
                    {elements.map((value, index) => (
                        <ElementList key={index} name={value.name} image={value.image} />
                    ))}
                </div>
            )}
        </div>
    );
};

export default Card;
