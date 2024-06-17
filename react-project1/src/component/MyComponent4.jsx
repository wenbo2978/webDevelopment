import React, { useEffect, useRef, useState } from 'react'

const MyComponent4 = () => {
  let [number, setNumber] = useState(0);
  
  const ref = useRef(0);
  const inputRef = useRef(null);
  
  useEffect(()=>{
    console.log('component rendered');
  });
  

  function handleClick() {
    ref.current++;
    console.log(ref.current);
    inputRef.current.focus();
    inputRef.current.style.backgroundColor = "yellow";
  }
  return (
    <div>
      <button onClick={handleClick}>
        Click Me
      </button>
      <input ref={inputRef}></input>
    </div>
  )
}

export default MyComponent4
