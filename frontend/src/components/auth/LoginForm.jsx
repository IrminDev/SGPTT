import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import InputAuth from '../../components/auth/inputAuth';
import ButtonSignUp from './ButtonSignUp';

function LoginForm() {
    const [error, setError] = useState(false);
    const navigate = useNavigate();

    const handleLogin = () => {
        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;

        if (username === "catt" && password === "password") {
            navigate("/dashboard-catt");
        } else if (username === "alumno" && password === "password") {
            navigate("/dashboard-alumno");
        } else if (username === "profesor" && password === "password") {
            navigate("/dashboard-profesor");
        } else {
            setError(true);
            setTimeout(() => setError(false), 1000);
        }
    };

    return (
        <div className="flex justify-center items-center flex-wrap gap-2">
            <InputAuth type="text" id="username" placeholder="username" error={error} />
            <InputAuth type="password" id="password" placeholder="password" error={error} />
            <ButtonSignUp text={"Ingresar"} action={handleLogin} />
        </div>
    );
}

export default LoginForm;