import React from 'react'
import { sideMenu } from './data'
import MenuItem from './menu-item'
import MenuList from './menu-list'
import "./style.css"

const TreeView = ({menus = sideMenu}) => {
  //console.log(menus.length);
  return (
    <div className='tree-view-container'>
      <MenuList list={menus}></MenuList>
    </div>
  )
}

export default TreeView
