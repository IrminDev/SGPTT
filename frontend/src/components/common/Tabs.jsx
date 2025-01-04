import React from 'react';
import PropTypes from 'prop-types';

// Tabs Component
const Tabs = ({ tabs, activeTab, onTabClick }) => {
  return (
    <div className="flex space-x-2 mb-4">
      {tabs.map((tab) => (
        <button
          key={tab}
          onClick={() => onTabClick(tab)}
          className={`px-3 py-2 rounded font-medium ${
            activeTab === tab
              ? "bg-green-200 text-green-800"
              : "bg-gray-200 text-gray-800 hover:bg-gray-300"
          }`}
        >
          {tab}
        </button>
      ))}
    </div>
  );
};

export default Tabs;