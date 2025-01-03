import "../../assets/styles/auth/Animation.css"

function InputAuth({ id, type, placeholder, error, value, handleChange }) {
    return (
        <input
            value={value}
            onChange={handleChange}
            type={type}
            id={id}
            placeholder={placeholder}
            className={`p-2 w-4/5 m-2 border-2 border-blue-500 rounded-full ${error ? "animate-shake" : ""}`}
        />
    );
}

export default InputAuth;