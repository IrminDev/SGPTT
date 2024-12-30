import React, { useState } from "react";
import TittleSection from "../../components/common/TittleSection";
import OptionBar from "../../components/common/OptionBar";
import Input from "../../components/common/Input";
import Button from "../../components/common/Button";

const AgendarPeriodo = () => {
  const [activeTab, setActiveTab] = useState("Ordinario");
  const [startDate, setStartDate] = useState("");
  const [endDate, setEndDate] = useState("");
  const [startTime, setStartTime] = useState("");
  const [endTime, setEndTime] = useState("23:59");

  const handleTabClick = (tab) => setActiveTab(tab);
  const handleStartDateChange = (e) => setStartDate(e.target.value);
  const handleEndDateChange = (e) => setEndDate(e.target.value);
  const handleStartTimeChange = (e) => setStartTime(e.target.value);
  const handleEndTimeChange = (e) => setEndTime(e.target.value);

  const handleCancel = () => {
    setStartDate("");
    setEndDate("");
    setStartTime("");
    setEndTime("23:59");
  };

  return (
    <div className="bg-gray-800 h-screen flex flex-col">
      <div className="mb-4">
        <TittleSection tittle="Agendar Periodo" />
      </div>
      <div className="flex justify-center items-center mt-4 relative">
        <div className="w-full max-w-4xl bg-gray-800 rounded-lg shadow-md overflow-hidden">
          <OptionBar opciones={["Ordinario", "Recurse"]} onSelect={handleTabClick} selectedOption={activeTab} />
        </div>
      </div>
      <div className="flex justify-center items-center mt-4">
        <div className="w-full max-w-4xl bg-gray-800 rounded-lg shadow-md overflow-hidden">
          <div className="p-6">
            <Input
              label="Fecha de Apertura"
              type="date"
              value={startDate}
              onChange={handleStartDateChange}
              placeholder="May 30th, Thursday"
            />

            <Input
              label="Hora de Apertura"
              type="time"
              value={startTime}
              onChange={handleStartTimeChange}
              placeholder="HH:MM"
            />

            <Input
              label="Fecha de Cierre"
              type="date"
              value={endDate}
              onChange={handleEndDateChange}
              placeholder="May 30th, Thursday"
            />

            <Input
              label="Hora de Cierre"
              type="time"
              value={endTime}
              onChange={handleEndTimeChange}
              placeholder="HH:MM"
            />

            <div className="flex justify-end space-x-2 mt-4">
              <Button label="Cancelar" className="bg-gray-500 hover:bg-gray-600" onClick={handleCancel} />
              <Button label="Guardar" className="bg-blue-500 hover:bg-blue-600" />
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AgendarPeriodo;
