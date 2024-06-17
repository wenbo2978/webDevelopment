import React, { useState } from 'react'
import MenuItemList from './menuItemList'
import { Link } from 'react-router-dom'

const MenuItem = ({menu}) => {
  const [childrenDisplay, setChildrenDisplay] = useState({});
  const handleToggleChildren = (getLabel) => {
    setChildrenDisplay({
      ...childrenDisplay,
      [getLabel] : !childrenDisplay[getLabel]
    })
  }
  return (
    <div>
      {
        menu ? (
          <div>
      
              <div>
                {
                  menu.children ? 
                  <div onClick={()=>handleToggleChildren(menu.label)} className='mainPageBar-label'>
                    <p>
                      {menu.label}
                    </p>
                    <span>
                      {
                        childrenDisplay[menu.label] ? '-' : '+'
                      }
                    </span>
                  </div> : 

                    
                    menu.label === 'Home' ? 
                    <Link to={menu.to} className='mainPageBar-label'> 
                    {menu.label}</Link> : 
                    <Link to={menu.to} className='mainPageBar-label'> 
                    &nbsp;&nbsp;&nbsp;{menu.label}</Link>
                  
                  
                  
                  
                }
                
              </div>
            
            {
              menu.children && childrenDisplay[menu.label] ? <MenuItemList menuList={menu.children} />
              : null
            }
          </div>
        ) : null
      }
    </div>
  )
}

export default MenuItem
