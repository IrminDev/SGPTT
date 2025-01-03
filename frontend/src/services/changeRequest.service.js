import axios from "axios";
const API_URL = import.meta.env.VITE_UTILS_SERVICE_URL;

const createChangeRequest = async (token, data) => {
    const response = await axios.post(`${API_URL}/api/utils/change-request`, data, {
        headers: {
            'Authorization': `Bearer ${token}`,
        }
    });

    return response.data;
}

export default {
    createChangeRequest
}