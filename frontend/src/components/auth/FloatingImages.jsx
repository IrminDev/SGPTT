import React from "react";
import graduation from "./../../assets/images/graduation-keyword.png";
import student from "./../../assets/images/student.png";
import "./../../assets/styles/auth/Animation.css";

const FloatingImages = () => {
  return (
    <div className=" m-0 p-0 w-full ">
      <div className=" img-container ">
        <img src={graduation} alt="Graduation" className="image1" />
        <img src={student} alt="Student" className="image2" />
      </div>
    </div>
  );
};

export default FloatingImages;
