import React from 'react';

const Button = ({ label, type = "button", onClick, className }) => {
    return (
      <button
        type={type}
        onClick={onClick}
        className={`px-4 py-2 rounded text-white ${className}`}
      >
        {label}
      </button>
    );
};

export default Button;