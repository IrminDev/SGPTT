import React, { useEffect, useState } from "react";
import "../../assets/styles/auth/BackgroundCircles.css";

const BackgroundCircles = () => {
  const [circles, setCircles] = useState([]);

  useEffect(() => {
    const generateCircles = () => {
      const newCircles = [];
      const numCircles = 10; // Puedes ajustar el número de círculos
      const colors = ["#FFCC00", "#00A8E1", "#A0EBA5", "#F04B81", "#C2E4FF"];

      for (let i = 0; i < numCircles; i++) {
        const size = Math.random() * 200 + 50; // Tamaño entre 50px y 250px
        const x = Math.random() * 100; // Posición horizontal en %
        const y = Math.random() * 100; // Posición vertical en %
        const color = colors[Math.floor(Math.random() * colors.length)];

        newCircles.push({ size, x, y, color });
      }
      setCircles(newCircles);
    };

    generateCircles();
  }, []);

  return (
    <div className="background-container">
      {circles.map((circle, index) => (
        <div
          key={index}
          className="circle"
          style={{
            width: circle.size,
            height: circle.size,
            top: `${circle.y}%`,
            left: `${circle.x}%`,
            backgroundColor: circle.color,
            opacity: 0.8,
          }}
        ></div>
      ))}
    </div>
  );
};

export default BackgroundCircles;
