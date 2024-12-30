import React from "react";
import { Routes, Route } from "react-router-dom";
import Sidebar from "../../components/main/Sidebar";
import Header from "../../components/main/Header";
import Errors from "./Errors";

const Dashboard = ({ typeUser, userName, userImageSidebar, userImageHeader, sidebarItems, routes }) => {
  return (
    <div className="flex h-screen">
      {/* Barra lateral */}
      <div className="fixed w-1/5 top-0 left-0 h-full">
        <Sidebar typeUser={typeUser} userName={userName} userImageSidebar={userImageSidebar} sidebarItems={sidebarItems} />
      </div>

      {/* Contenido Central */}
      <div className="flex-1 flex flex-col bg-gray-800 ml-[20%]">
        {/* Encabezado */}
        <div className="fixed top-0 left-[20%] w-[80%]">
          <Header typeUser={typeUser} userName={userName} userImageHeader={userImageHeader} />
        </div>
        {/* Contenido principal */}
        <div className="mt-12 overflow-y-auto h-full">
          <Routes>
            {routes.map((route, index) => (
              <Route key={index} path={route.path} element={route.element} />
            ))}
            <Route path="*" element={<Errors typeUser={typeUser} />} />
          </Routes>
        </div>
      </div>
    </div>
  );
};

export default Dashboard;