import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

// Importar Login
import Login from "./pages/auth/Login";

// Importar paginas para CATT
import AgendarPeriodo from "./pages/CATT/AgendarPeriodo";
import AsignarProtocolosAcademias from "./pages/CATT/AsignarProtocolosAcademias";
import ProtocolosPendientesSinodal from "./pages/CATT/ProtocolosPendientesSinodal";
import RegistrarUsuario from "./pages/CATT/RegistrarUsuario";
import SolicitudesModificacionProtocolos from "./pages/CATT/SolicitudesModificacionProtocolos";

// Importar paginas para Alumnos
import MiProtocolo from "./pages/Alumno/MiProtocolo";
import SubirProtocolo from "./pages/Alumno/SubirProtocolo";
import EditarProtocolo from "./pages/Alumno/EditarProtocolo";

// Importar paginas para Profesores
import ProtocolosACargo from "./pages/Profesor/ProtocolosACargo";
import ProtocolosDisponibles from "./pages/Profesor/ProtocolosDisponibles";
import RevisarProtocolos from "./pages/Profesor/RevisarProtocolos";
import EvaluarProtocolo from "./pages/Profesor/EvaluarProtocolo";

// Importar componentes en común
import Dashboard from "./pages/common/Dashboard";
import Inicio from "./pages/common/Inicio";
import Errors from "./pages/common/Errors";

// Importar imágenes
import Home from "./assets/images/home.svg";
import Calendar from "./assets/images/calendar.svg";
import Edit from "./assets/images/edit.svg";
import Warn from "./assets/images/warn.svg";
import Request from "./assets/images/request.svg";
import NewUser from "./assets/images/newUser.svg";
import Protocol from "./assets/images/protocol.svg";
import Upload from "./assets/images/upload.svg";
import Eye from "./assets/images/eye.svg";
import Choose from "./assets/images/choose.svg";
import StudentW from "./assets/images/student-white.svg";
import StudentB from "./assets/images/student-black.svg";
import AdminW from "./assets/images/admin-white.svg";
import AdminB from "./assets/images/admin-black.svg";
import TeacherW from "./assets/images/teacher-white.svg";
import TeacherB from "./assets/images/teacher-black.svg";
import AsignarAcademia from "./pages/CATT/AsignarAcademia";

export default function App() {
  // Definir rutas para usuarios CATT
  const cattRoutes = [
    { path: "/", element: <Inicio /> },
    { path: "agendar-periodo", element: <AgendarPeriodo /> },
    { path: "protocolos-pendientes-area", element: <AsignarProtocolosAcademias /> },
    { path: "protocolos-pendientes-area/:id", element: <AsignarAcademia /> },
    { path: "protocolos-pendientes-sinodal", element: <ProtocolosPendientesSinodal /> },
    { path: "registrar-usuario", element: <RegistrarUsuario /> },
    { path: "solicitudes-modificacion", element: <SolicitudesModificacionProtocolos /> },
  ];

  // Definir rutas para alumnos
  const alumnoRoutes = [
    { path: "/", element: <Inicio /> },
    { path: "mi-protocolo", element: <MiProtocolo /> },
    { path: "subir-protocolo", element: <SubirProtocolo /> },
    { path: "editar-protocolo", element: <EditarProtocolo /> },
  ];
  
  // Definir rutas para profesores
  const profesorRoutes = [
    { path: "/", element: <Inicio /> },
    { path: "protocolo-a-cargo", element: <ProtocolosACargo /> },
    { path: "protocolos-disponibles", element: <ProtocolosDisponibles /> },
    { path: "revisar-protocolos", element: <RevisarProtocolos /> },
    { path: "revisar-protocolos/:id", element: <EvaluarProtocolo /> },
  ];

  // Definir items de la barra lateral para usuarios CATT
  const cattItemsInfo = [
    { icon: Home, text: "Inicio", path: "", active: true },
    { icon: Calendar, text: "Agendar Periodo de Recepción", path: "agendar-periodo" },
    { icon: Edit, text: "Asignar Protocolos a Academias", path: "protocolos-pendientes-area" },
    { icon: Warn, text: "Protocolos Pendientes", path: "protocolos-pendientes-sinodal" },
    { icon: Request, text: "Solicitudes de Modificación", path: "solicitudes-modificacion" },
    { icon: NewUser, text: "Registrar Nuevo Usuario", path: "registrar-usuario" },
  ];

  // Definir items de la barra lateral para alumnos
  const alumnoItemsInfo = [
    { icon: Home, text: "Inicio", path: "", active: true},
    { icon: Protocol, text: "Mi protocolo", path: "mi-protocolo" },
    { icon: Upload, text: "Subir Protocolo", path: "subir-protocolo" },
    { icon: Edit, text: "Editar Protocolo", path: "editar-protocolo" },
  ];
  
  // Definir items de la barra lateral para profesores
  const profesorItemsInfo = [
    { icon: Home, text: "Inicio", path: "", active: true },
    { icon: Eye, text: "Protocolos a Cargo", path: "protocolo-a-cargo" },
    { icon: Choose, text: "Protocolos Disponibles", path: "protocolos-disponibles" },
    { icon: Protocol, text: "Revisar Protocolos", path: "revisar-protocolos" },
  ];

  return (
    <Router>
      <Routes>
        {/* Ruta para la página de login */}
        <Route path="/" element={<Login />} />

        {/* Ruta para el dashboard de usuarios CATT */}
        <Route
          path="/dashboard-catt/*"
          element={
            <Dashboard
              typeUser="CATT"
              userImageSidebar={AdminB}
              userImageHeader={AdminW}
              sidebarItems={cattItemsInfo}
              routes={cattRoutes}
            />
          }
        />

        {/* Ruta para el dashboard de alumnos */}
        <Route
          path="/dashboard-alumno/*"
          element={
            <Dashboard
              typeUser="Alumno"
              userImageSidebar={StudentB}
              userImageHeader={StudentW}
              sidebarItems={alumnoItemsInfo}
              routes={alumnoRoutes}
            />
          }
        />

        {/* Ruta para el dashboard de profesores */}
        <Route
          path="/dashboard-profesor/*"
          element={
            <Dashboard
              typeUser="Profesor"
              userImageSidebar={TeacherB}
              userImageHeader={TeacherW}
              sidebarItems={profesorItemsInfo}
              routes={profesorRoutes}
            />
          }
        />

        {/* Ruta para la página de errores */}
        <Route path="*" element={<Errors />} />
      </Routes>
    </Router>
  );
}