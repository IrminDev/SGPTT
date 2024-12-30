import React, { useState, useEffect } from 'react';

const SidebarHeader = ({ typeUser, userName, userImageSidebar }) => {
  const [windowWidth, setWindowWidth] = useState(window.innerWidth);

  useEffect(() => {
    const handleResize = () => setWindowWidth(window.innerWidth);
    window.addEventListener("resize", handleResize);
    return () => window.removeEventListener("resize", handleResize);
  }, []);

  const getImageSize = () => {
    if (windowWidth < 720) return "h-16 w-16";
    if (windowWidth < 1200) return "h-20 w-20";
    return "h-28 w-28";
  };

  return (
    <div className="flex flex-col items-center mb-4">
      <div className={`bg-green-200 rounded-full flex items-center justify-center mb-2 ${getImageSize()}`}>
        <img src={userImageSidebar} alt="User" className="h-full w-full " />
      </div>
      <h1 className="text-2xl font-bold">{typeUser}</h1>
      <span className="text-white">{userName}</span>
    </div>
  );
};

export default SidebarHeader;