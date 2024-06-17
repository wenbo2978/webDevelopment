import React from 'react'
import MenuItem from './menuItem'

const MenuItemList = ({menuList}) => {
  return (
    <div>
      {
        menuList && menuList.length > 0? 
          menuList.map((item, index) => <MenuItem menu={item} key={index} />)
            
         : null
      }
    </div>
  )
}

export default MenuItemList
