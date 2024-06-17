import React, { useEffect, useState } from 'react'
//1. useEffect(()=>{})              //runs after every re-render
//2. useEffect(()=>{}, [])          //runs only on mount
//3. useEffect(()=>{}, [value])     //runs one mount + when value changes


const MyComponent2 = () => {
  const [count, setCount] = useState(0);
  const [color, setColor] = useState("green");

  useEffect(() => {
    document.title = `Count: ${count} ${color}`;
  }, [count, color]);
  const addCount = ()=>{
    setCount(c => c + 1);
  }

  const subtractCount = ()=>{
    setCount(c => c - 1);
  }

  const changeColor = () => {
    setColor(c => c === "green" ? "red" : "green");
  }

  return (
    <div>
      <p style={{color: color}}>Count: {count}</p>
      <button onClick={addCount}>Add</button>
      <button onClick={subtractCount}>Subtract</button>
      <button onClick={changeColor}>Change Color</button>
    </div>
  )
}

export default MyComponent2
