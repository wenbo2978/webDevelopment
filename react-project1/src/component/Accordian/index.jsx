import React, { useState } from 'react'
import { data } from './data'
import "./style.css"


const Accordian = () => {

  const [selected, setSelected] = useState(null);
  const [multiSelected, setMultiSelected] = useState(false);
  const [multiple, setMultiple] = useState([]);

  const handleSingleSelection = (getCurrentId) => {
    console.log(getCurrentId);
    if(getCurrentId === selected){
      setSelected(null);
    }else{
      setSelected(getCurrentId);
    }
    
  }

  const handleMultiSelection = (getCurrentId) => {
    const findIndex = multiple.indexOf(getCurrentId);
    //console.log(findIndex);
    if(findIndex === -1){
      console.log("add");
      setMultiple(m => [...m, getCurrentId]);
    }else{
      console.log("remove");
      setMultiple(multiple.filter((id,index) => id !== getCurrentId));
    }
  }

  const enableMultiSelection = () => {
    if(multiSelected === false){
      setMultiSelected(true);
    }else{
      setMultiSelected(false);
    }
  }


  return (
    <div className='wrapper'>
      <button onClick={enableMultiSelection}>
        Multi Selected
      </button>
      <div className='accordian'>
        {data && data.length > 0 ? (
          data.map((dataItem, index) => (
            <div className='item' key={index}>
              <div className='title'>
                <h3 onClick={multiSelected ? 
                  ()=>handleMultiSelection(dataItem.id):
                  ()=>handleSingleSelection(dataItem.id)
                  }>{dataItem.question}</h3>
                <span>+</span>
              </div>
              {
                multiSelected ? (
                  multiple.indexOf(dataItem.id) !== -1 ? (
                    <div className='content'>{dataItem.answer}</div>
                  ) : null
                ) : (
                  selected === dataItem.id ? (
                    <div className='content'>{dataItem.answer}</div>
                  ) : null
                )
              }
            </div>
          ))
        ) : (
          <div>No data found!</div>
        )}
      </div>
      
    </div>
  )
}

export default Accordian
