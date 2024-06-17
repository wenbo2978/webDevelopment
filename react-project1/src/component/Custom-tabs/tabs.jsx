import React, { useState } from 'react'
import './style.css'

const Tabs = ({tabsContent, onChange}) => {

  const [currentTabIndex, setCurrentTabIndex] = useState(0);
  const handleOnClick = (getCurrentIndex) => {
    setCurrentTabIndex(getCurrentIndex);
    //console.log("index:" + getCurrentIndex);
    onChange(getCurrentIndex);
  }
  return (
    <div className='wrapper'>
      <div className='heading'>
        {
          tabsContent.map((tabItem, index)=>(
            <div key={tabItem.label}
              onClick={()=> handleOnClick(index)}
              className={`tab-item ${currentTabIndex === index 
              ? "active" : ""
              }`}
            >
              <span className='label'>{tabItem.label}</span>
            </div>
          ))
        }
      </div>
      <div className='content' 
        style={{
          color: 'red'
        }}
      >
        {
          tabsContent[currentTabIndex] && 
            tabsContent[currentTabIndex].content
        }
      </div>
    </div>
  )
}

export default Tabs
