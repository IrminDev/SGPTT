import React, { useState, useEffect } from "react";

const SidebarItem = ({ icon, text, active, onClick, isLogOut }) => {
  const [windowWidth, setWindowWidth] = useState(window.innerWidth);

  useEffect(() => {
    const handleResize = () => setWindowWidth(window.innerWidth);
    window.addEventListener("resize", handleResize);
    return () => window.removeEventListener("resize", handleResize);
  }, []);

  const getTruncatedText = () => {
    if (windowWidth < 720) return ""; // Only icons
    if (windowWidth < 1200) return text.length > 6 ? `${text.slice(0, 4)}...` : text; // Truncate text
    return text; // Full text
  };

  const getImageSize = () => {
    if (windowWidth < 720) return "w-1/3";
    if (windowWidth < 1200) return "w-1/6";
    return "w-1/12";
  };

  return (
    <div
      className={`flex items-center p-2 cursor-pointer bg-gray-200 rounded-full text-black transition-colors duration-300 ease-in-out ${active ? "bg-blue-700" : ""} ${isLogOut ? "hover:bg-red-500" : "hover:bg-blue-400"} ${windowWidth < 720 ? "justify-center" : "justify-start"}`}
      onClick={onClick}
    >
      <img src={icon} alt={`icono-${text}`} className={`${getImageSize()} mx-2`} />
      <span className="text-base">{getTruncatedText()}</span>
    </div>
  );
};

export default SidebarItem;