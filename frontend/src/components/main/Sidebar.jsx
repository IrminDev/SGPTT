import React, { useState, useEffect } from 'react';
import { Link, useNavigate, useLocation } from 'react-router-dom';
import SidebarHeader from './SidebarHeader';
import SidebarItem from './SidebarItem';
import Logout from '../../assets/images/logout.svg';

const Sidebar = ({ typeUser, userName, userImageSidebar, sidebarItems }) => {
  // Estado para los items de la barra lateral
  const [items, setItems] = useState(sidebarItems);
  const navigate = useNavigate();
  const location = useLocation();

  // useEffect para actualizar el item activo basado en la ruta actual
  useEffect(() => {
    const currentPath = location.pathname.split('/').pop();
    const newItems = items.map((item) => ({
      ...item,
      active: item.path === currentPath,
    }));
    setItems(newItems);
  }, [location.pathname]);

  // Maneja el clic en un item de la barra lateral
  const handleItemClick = (index) => {
    const newItems = items.map((item, i) => ({
      ...item,
      active: i === index,
    }));
    setItems(newItems);
  };

  // Maneja el clic en el botón de logout para volver al Login
  const handleLogout = () => {
    // Limpiar cualquier estado o almacenamiento local si es necesario
    navigate('/');
  };

  // Maneja el clic en el encabezado de la barra lateral
  const handleHeaderClick = () => {
    const newItems = items.map((item) => ({
      ...item,
      active: item.text === "Inicio",
    }));
    setItems(newItems);
    navigate(`/dashboard-${typeUser.toLowerCase()}`);
  };

  return (
    <div className="w-full h-screen bg-gray-700 flex flex-col p-4">
      {/* Encabezado */}
      <div onClick={handleHeaderClick}>
        <SidebarHeader typeUser={typeUser} userName={userName} userImageSidebar={userImageSidebar} />
      </div>

      {/* Opciones */}
      <nav className="flex flex-col justify-around items-center h-3/5">
        {items.map((item, index) => (
          <Link to={`/dashboard-${typeUser.toLowerCase()}/${item.path}`} key={index} className="w-full">
            <SidebarItem
              icon={item.icon}
              text={item.text}
              active={item.active}
              onClick={() => handleItemClick(index)}
            />
          </Link>
        ))}
      </nav>

      {/* Botón Salir */}
      <div className="mt-auto w-full">
        <button onClick={handleLogout} className="w-full">
          <SidebarItem icon={Logout} text="Salir" isLogOut={true} />
        </button>
      </div>
    </div>
  );
};

export default Sidebar;