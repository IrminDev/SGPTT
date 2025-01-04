import React from 'react';

function ButtonSignUp({ text, action }) {
    return (
        <button 
            className="p-2 w-1/3 bg-blue-500 text-white border-none rounded-md cursor-pointer transition-transform duration-200 hover:scale-105"
            onClick={action}
        >
            {text}
        </button>
    );
}

export default ButtonSignUp;