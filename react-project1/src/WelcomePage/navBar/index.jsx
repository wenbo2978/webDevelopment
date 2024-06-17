import React, { useState } from 'react'
import { sideMenu } from './data'
import MenuItemList from './menuItemList'
import './style.css'

const MainPageBar = ({menuList = sideMenu}) => {
  const [navBarShow, setNavBarShow] = useState(true);
  function handleBarClickFunction(){
    setNavBarShow(n => n = !navBarShow);
  }
  return (
    <div className={navBarShow ? 'mainPageBar-container-show' : 'mainPageBar-container-show mainPageBar-container-hidden'}>
      <img onClick={handleBarClickFunction} className='mianPageBar-show-hidden-image'/>
      {
        navBarShow && <MenuItemList menuList={menuList}/>
      }
      
    </div>
  )
}

export default MainPageBar
