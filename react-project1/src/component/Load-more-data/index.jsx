import React, { useEffect, useRef, useState } from 'react'
import './style.css'

//url = dummyjson.com/docs/products

const LoadMoreData = () => {
  const ref = useRef(false);
  const [loading, setLoading] = useState(false);
  const [products, setProducts] = useState([]);
  const [count, setCount] = useState(0);
  const [disableButton, setDisableButton] = useState(false);
  async function fetchProducts() {
    try{
      setLoading(true);
      const response = await fetch(
        `https://dummyjson.com/products?limit=20&skip=${count * 20}`
      );
      //limit: number of images get in once
      //skip: skip previous data
      const result = await response.json();
      console.log(result);
      if(result && result.products && result.products.length){
        setProducts((prevData) => [...prevData, ...result.products]);
        setLoading(false);
      }
    }catch(e){
      console.log(e);
      setLoading(false);
    }
  }

  useEffect(()=>{
    if(!ref.current){
      fetchProducts();
      ref.current = true;
    }
    
  }, [count]);

  useEffect(()=> {
    if(products && products.length === 100){
      setDisableButton(true);
    }
  }, [products])

  if(loading){
    return <div>Liading data ! Please wait.</div>
  }

  return (
    <div className='load-more-container'>
      <div className='product-container'>
        {
          products && products.length ? 
          products.map((item, index) => (
            <div className='product' key={index}>
              <img
                src={item.thumbnail}
                alt={item.title}
              />
              <p>{item.title}</p>
            </div>
          ))
          : null
        }
      </div>
      <div className='button-container'>
        <button
          onClick={() => {
            ref.current = false;
            setCount(c => c + 1);

          }}
          disabled={disableButton}
        >More Products</button>
        {
          disableButton ? <p>You have reached 100 products</p> :
          null
        }
      </div>
    </div>
  )
}

export default LoadMoreData
