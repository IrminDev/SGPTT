import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import InputAuth from './InputAuth';
import ButtonSignUp from './ButtonSignUp';
import authService from '../../services/auth.service';
import { toast } from 'react-toastify';

function LoginForm() {
    const [error, setError] = useState(false);
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();

    const handleLogin = () => {
        if (email === "" || password === "") {
            setError(true);
            setTimeout(() => setError(false), 1000);
            return;
        }

        authService.login(email, password).then((response) => {
            console.log(response);
            if(response.result === 'Success'){
                localStorage.setItem("token", response.token);
                localStorage.setItem("person", JSON.stringify(response.person));

                toast.success("Inicio de sesión exitoso")
                if(response.person.career){
                    navigate("/dashboard-alumno");
                } else if(response.person.school){
                    navigate("/dashboard-profesor");
                } else {
                    navigate("/dashboard-catt");
                }
            } else {
                toast.error("Correo o contraseña incorrectos")
            }
        }).catch((error) => {
            console.log(error);
        });
    };

    const handleEmail = (e) => { 
        setEmail(e.target.value);
    };

    const handlePassword = (e) => { 
        setPassword(e.target.value);
    };

    return (
        <div className="flex justify-center items-center flex-wrap gap-2">
            <InputAuth type="email" value={email} handleChange={handleEmail} id="email" placeholder="Correo" error={error} />
            <InputAuth type="password" value={password} handleChange={handlePassword} id="password" placeholder="Contraseña" error={error} />
            <ButtonSignUp text={"Ingresar"} action={handleLogin} />
        </div>
    );
}

export default LoginForm;