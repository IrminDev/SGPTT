import "../../assets/styles/auth/Animation.css"

function InputAuth({ id, type, placeholder, error=false }) {
    return (
        <input
            type={type}
            id={id}
            placeholder={placeholder}
            className={`p-2 w-4/5 m-2 border-2 border-blue-500 rounded-full ${error ? "animate-shake" : ""}`}
        />
    );
}

export default InputAuth;