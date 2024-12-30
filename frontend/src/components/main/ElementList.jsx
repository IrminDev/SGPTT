// components/ElementList.jsx
import React from "react";

const ElementList = ({ name, image }) => {
  if (!name && !image) {
    return null;
  }

  return (
    <div className="flex items-center space-x-3">
      {image && <img src={image} alt={`icono-${name}`} className="w-8 h-8 rounded-full" />}
      {name && <span className="text-black">{name}</span>}
    </div>
  );
};

export default ElementList;
