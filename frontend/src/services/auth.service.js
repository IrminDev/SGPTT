import axios from 'axios';
const API_URL = import.meta.env.VITE_AUTH_SERVICE_URL;

const login = async (email, password) => {
    const response = await axios.post(`${API_URL}/api/auth/login`, {
        email,
        password
    });

    return response.data;
}

const me = async (token) => {
    const response = await axios.get(`${API_URL}/api/auth/authorize/me`, {
        headers: {
            'Authorization': `Bearer ${token}`
        }
    });

    return response.data;
}

export default {
    login,
    me
}