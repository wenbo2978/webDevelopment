import React from 'react'
import useFetch from '.'
import './style.css'

const UseFetchHookTest = () => {
  const {data, error, pending} = useFetch('https://dummyjson.com/products?limit=100', {});
  //console.log(data ? data.products : "loading");
  return (
    <div className='useFetch-container'>
      <h1>Use Fetch Hook</h1>
      {
        pending ? <h3>Pending ! Please wait</h3> : null
      }
      {
        data && data.products && data.products.length ? 
        data.products.map((productItem, index) => (<p key={index}>
          {productItem.title}
        </p>)) : <p>No data</p>
      }
    </div>
  )
}

export default UseFetchHookTest
