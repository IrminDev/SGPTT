import React from "react";

const Header = ({ typeUser, userName, userImageHeader }) => {
  return (
    <header className="w-full h-12 bg-gray-900 p-2 flex justify-end items-center">
      <div className="flex w-max justify-evenly items-center font-bold text-white">
        <img src={userImageHeader} alt={typeUser} className="mr-4 h-10" />
        <span className="text-lg" >{userName}</span>
      </div>
    </header>
  );
};

export default Header;
