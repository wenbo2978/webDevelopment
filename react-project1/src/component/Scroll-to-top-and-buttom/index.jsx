import React, { useRef } from 'react'
import useFetch from '../Use-fetch'
import './style.css'

const ScrollToTopAndButtom = () => {
  const {data, error, pending} = useFetch(
    'https://dummyjson.com/products?limit=100',
    {}
  );

  const buttomRef = useRef(null);

  function handleScrollToTop(){
    window.scrollTo({
      top: 0, left: 0, behavior: 'smooth'
    });
  }
  function handleScrollToButtom(){
    console.log(buttomRef.current);
    buttomRef.current.scrollIntoView({behavior: 'smooth'})
  }
  if(pending){
    return <h1>Loading ! </h1>
  }
  if(error){
    return <h1>Error !</h1>
  }
  return (
    <div className='scroll-to-top-and-bottom-container'>
      <h1>Scroll To Top And Buttom Feature</h1>
      <h3>This is the top section</h3>
      <button onClick={handleScrollToButtom}>Scroll To Buttom</button>
      <ul>
        {
          data &&  data.products && data.products.length ?
          data.products.map((item, index) => <li key={index}>{item.title}</li>) :
          null
        }
      </ul>
      <button onClick={handleScrollToTop}>Scroll To Top</button>
      <div ref={buttomRef}></div>
      <h3>This is the buttom section</h3>
    </div>
  )
}

export default ScrollToTopAndButtom
