import React, { useEffect, useState } from 'react'

const MyComponent3 = () => {
  const [width, setWidth] = useState(window.innerWidth);
  const [height, setHeight] = useState(window.innerHeight);

  
  //console.log("event listener add");
  useEffect(() => {
    window.addEventListener("resize", handleResize);
    console.log("event listener added");

    return () => {
      window.removeEventListener("resize", handleResize);
      console.log("event listener removed");
    }
  }, []);

  useEffect(() => {
    document.title = `Size: ${width} * ${height}`;
  }, [width, height]);

  function handleResize(){
    setWidth(window.innerWidth);
    setHeight(window.innerHeight);
  }

  return (
    <div>
      <p>Window Width: {width} px</p>
      <p>Window Height: {height} px</p>
    </div>
  )
}

export default MyComponent3
