import React from 'react'
import MenuItem from './menu-item'

const MenuList = ({list = []}) => {
  return (
    <ul className='menu-list-container'>
      {
        list && list.length ? (
          list.map((listItem, index) => (
            <MenuItem menu={listItem} key={index}></MenuItem>
          ))
        ) : null
      }
    </ul>
  )
}

export default MenuList
