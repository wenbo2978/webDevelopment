import React, { useRef } from 'react'
import './style.css'

const ScrollToCertainSection = () => {
  const data = [
    {
      label: 'first Card',
      style: {
        width: "100%",
        height: "600px",
        background: "red"
      },
    },
    {
      label: 'second Card',
      style: {
        width: "100%",
        height: "600px",
        background: "green"
      },
    },
    {
      label: 'third Card',
      style: {
        width: "100%",
        height: "600px",
        background: "blue"
      },
    },
    {
      label: 'fourth Card',
      style: {
        width: "100%",
        height: "600px",
        background: "orange"
      },
    }
  ];
  const refSection = useRef(null);
  function handleScrollToSection(){
    //refSection.current.scrollIntoView({behavior: 'smooth'})
    let pos = refSection.current.getBoundingClientRect().top;
    window.scrollTo({
      top: pos,
      behavior: "smooth"
    })
  }
  function handleSelectClick(event){
    console.log(event.target.value)
  }
  return (
    <div className='scroll-to-certain-section-container'>
      
      <button onClick={handleScrollToSection}>Go to Section</button>
      {
        data.map((item, index) => 
        <div key={index}
          ref={(index === 3) ? refSection : null}
        >
          <h1>{item.label}</h1>
          <div style={item.style}></div>
        </div>)
      }
    </div>
  )
}

export default ScrollToCertainSection
