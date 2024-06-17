import React, { useEffect, useState } from 'react'

const RandomColor = () => {
  const [typeOfColor, setTypeOfColor] = useState("hex");
  const [color, setColor] = useState("#000000");

  const randomColorUtility = (length)=> {
    return Math.floor(Math.random() * length);
  }

  const handleCreateRandomColor = () => {
    if(typeOfColor === "hex"){
      const hex = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F'];
      let hexColor = "#";
      for(let i = 0; i < 6; i ++){
        hexColor += hex[randomColorUtility(16)];
      }
      //console.log(hexColor);
      setColor(hexColor);
    }else{
      let rgbColor = "rgb(";
      for(let i = 0; i < 3; i ++){
        if(i == 2){
          rgbColor += randomColorUtility(256);
        }else{
          rgbColor += randomColorUtility(256);
          rgbColor += ",";
        }
      }
      rgbColor += ")";
      setColor(rgbColor);
      //console.log(rgbColor);
    }
  }

  useEffect(() => {
    handleCreateRandomColor();
  }, [typeOfColor]);

  return (
    <div
      style={{
        width: "100vw",
        height: "100vh",
        background: color,
      }} 
      className='container'>
      <button onClick={()=> setTypeOfColor("hex")}>
        Create HEX Color
      </button>
      <button onClick={()=> setTypeOfColor("rgb")}>
        Create RGB Color
      </button>
      <button onClick={handleCreateRandomColor}>
        generate Random Color
      </button>
      <div
        style={{
          display: "flex",
          justifyContent: "center",
          alignItems: "center",
          color: "#fff",
          fontSize: "60px",
          marginTop: "50px",
          flexDirection: "column",
          margin: "20px"
        }}
      >
        <h3>{typeOfColor}</h3>
        <h1>{color}</h1>
      </div>
    </div>
  )
}

export default RandomColor
