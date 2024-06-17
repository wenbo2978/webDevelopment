import React from 'react'
import propTypes from 'prop-types'

const List = (props) => {
  
  const itemLists = props.items;
  const category = props.category;

  //fruits.sort((a, b) => a.name.localeCompare(b.name));
  //fruits.sort((a, b) => a.calories - b.calories);

  //const lowCalFruits = fruits.filter(fruit => fruit.calories < 100);
  
  const listItems = itemLists.map(item => <li key={item.id}>{item.name}: &nbsp;<b>{item.calories}</b></li>);
  return (
    <div>
      <h3 className='list-category'>
        {category}
      </h3>
      <ol className='list-items'>
        {listItems}
      </ol>
    </div>
  )
}
List.propTypes = {
  category: propTypes.string,
  items: propTypes.arrayOf(propTypes.shape({id: propTypes.number, 
                                            name: propTypes.string,
                                            categories: propTypes.number})),
}
List.defaultProps = {
  category: "Category",
  item: [],
}
export default List
