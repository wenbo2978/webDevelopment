import React from 'react'
import Tabs from './tabs'

function RandomComponent(){
  return <h1>Some random</h1>;
}

const TabTest = () => {
  const tabs = [
    {
      label: 'Tab1',
      content: <div>This is content for tab 1</div>
    },
    {
      label: 'Tab2',
      content: <div>This is content for tab 2</div>
    },
    {
      label: 'Tab3',
      content: <RandomComponent/>
    }
  ];

  const handelChange = (currentTabIndex) => {
    console.log(currentTabIndex);
  }

  return (
    <Tabs tabsContent={tabs} onChange={handelChange}/>
  )
}

export default TabTest
