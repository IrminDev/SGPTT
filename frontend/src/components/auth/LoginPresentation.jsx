import React from 'react';
import TypingTittle from './TypingTittle';
import LoginForm from './LoginForm';

const LoginPresentation = () => {
    return (
        <div className="flex justify-center items-center h-screen">
            <div className="flex flex-col justify-around items-center w-4/5">
                <TypingTittle text={"Protocolo de trabajo terminal"} />
                <div className="mt-8">
                    <LoginForm />
                </div>
            </div>
        </div>
    );
}

export default LoginPresentation;