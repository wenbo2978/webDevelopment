import React, { useState } from 'react'
import MenuList from './menu-list'
import {FaMinus, FaPlus} from 'react-icons/fa'

const MenuItem = ({menu}) => {
  //console.log("123");
  const [displayChildren, setDisplayChildren] = useState({});
  const handleToggleChildren = (getLabel) => {
    setDisplayChildren({
      ...displayChildren,
      [getLabel] : !displayChildren[getLabel]
    })
  }

  //console.log(displayChildren);
  return (
    <li className='menu-item'>
      {
        menu ? (
          <div>
            <div style={{
              display: "flex",
              gap: "20px",
            }}>
              <p>{menu.label}</p>
              {
                menu && menu.children && menu.children.length ? 
                <span onClick={
                  ()=>handleToggleChildren(menu.label)
                }>
                  {
                    displayChildren[menu.label] ? 
                    <FaMinus 
                      color='#fff'
                      size={25}
                    /> 
                    : 
                    <FaPlus
                      color='#fff'
                      size={25}
                    />
                  }
          
                </span>
                : null
              }
            </div>
            
            {
              menu.children && menu.children.length ? displayChildren[menu.label] && (
                <MenuList list={menu.children}></MenuList>
              ) : null
            }
          </div>
        ) : null
      }
    </li>
  )
}

export default MenuItem
