import React from "react";

const TittleSection = ({ tittle }) => {
  return (
    <div className="flex-1 px-6 pt-6 pb-0">
      <h1 className="text-4xl font-bold mb-4 text-yellow-500">{tittle}</h1>
      <hr className="border-t-2 border-yellow-500 w-full mb-2" />
    </div>
  );
};

export default TittleSection;
