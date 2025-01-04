import React from 'react';
import BackgroundCircles from "../../components/auth/BackGroundCircles";
import FloatingImages from "../../components/auth/FloatingImages";
import LoginPresentation from '../../components/auth/LoginPresentation';

const Login = () => {
    return (
        <div className="w-full h-screen flex justify-around items-center relative z-10">
            <div className="hidden md:block md:w-1/2 ">
                <FloatingImages />
            </div>
            <div className="w-full md:w-1/2">
                <LoginPresentation />
            </div>
            <BackgroundCircles />
        </div>
    );
}

export default Login;