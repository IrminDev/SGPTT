import React from "react";

const OptionBar = ({ opciones, onSelect, selectedOption }) => {
  return (
    <div className="flex flex-wrap justify-around bg-gray-800 py-2 rounded-t-lg shadow-md">
      {opciones.map((opcion, index) => (
        <button
          key={index}
          className={`text-orange-600 font-semibold px-4 py-2 transition-colors duration-300 rounded-lg m-1 ${
            selectedOption === opcion
              ? "bg-teal-600 text-white"
              : "hover:text-teal-700"
          }`}
          onClick={() => onSelect(opcion)}
        >
          {opcion}
        </button>
      ))}
    </div>
  );
};

export default OptionBar;