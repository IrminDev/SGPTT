import React, { useEffect, useState } from "react";
import "./../../assets/styles/auth/Animation.css";

const TypingTitle = ({ text }) => {
  const [displayedText, setDisplayedText] = useState("");

  useEffect(() => {
    let index = 0;
    const interval = setInterval(() => {
      if (index < text.length - 1) {
        setDisplayedText((prev) => prev + text[index]);
        index++;
      } else {
        clearInterval(interval);
      }
    }, 100); // Velocidad de escritura

    return () => clearInterval(interval);
  }, [text]);

  return (
    <h1 className="text-center text-3xl md:text-6xl font-normal text-gray-800 revalia-regular">
      {displayedText}
    </h1>
  );
};

export default TypingTitle;