import React, { useEffect, useState } from "react";
import { Routes, Route } from "react-router-dom";
import Sidebar from "../../components/main/Sidebar";
import Header from "../../components/main/Header";
import Errors from "./Errors";
import authService from "../../services/auth.service";
import { useNavigate } from "react-router-dom";

const Dashboard = ({ typeUser, userImageSidebar, userImageHeader, sidebarItems, routes }) => {
  const navigate = useNavigate();

  const [person, setPerson] = useState({
    name: ''
  });

  useEffect(() => {
    const token = localStorage.getItem("token");
    const personStorage = JSON.parse(localStorage.getItem("person"));
    setPerson(personStorage);

    if (!token) {
      navigate("/");
    }

    if(!personStorage?.personId){
      authService.me(token).then((response) => {
        if (response) {
          setPerson({
            ...personStorage,
            personId: response.personId,
          });
  
          localStorage.setItem("person", JSON.stringify(person));
        } else {
          localStorage.removeItem("token");
          localStorage.removeItem("person");
          navigate("/");
        }
      }).catch((error) => {
        console.log(error);
        navigate("/");
      })
    }
  }, []);

  return (
    <div className="flex h-screen">
      {/* Barra lateral */}
      <div className="fixed w-1/5 top-0 left-0 h-full">
        <Sidebar typeUser={typeUser} userName={person.name} userImageSidebar={userImageSidebar} sidebarItems={sidebarItems} />
      </div>

      {/* Contenido Central */}
      <div className="flex-1 flex flex-col bg-gray-800 ml-[20%]">
        {/* Encabezado */}
        <div className="fixed top-0 left-[20%] w-[80%]">
          <Header typeUser={typeUser} userName={person.name} userImageHeader={userImageHeader} />
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