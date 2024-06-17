/* 
<div ref = {ref} />
React will assign the DOM element to ref.current once it is mounted.

*/

import React, { useRef, useState } from 'react'
import useOutSideClick from '.';
import './style.css'

const UseOnClickOutsideTest = () => {
  
  const [showContent, setShowContent] = useState(false);
  const ref = useRef();
  useOutSideClick(ref, ()=>setShowContent(false));
  return (
    <div>
      {
        showContent ? 
        <div ref={ref}>
          <h1>This is a random content</h1>
          <p>Please Click outside of this to close this. It won't close if you click inside of this content</p>
        </div> 
        : 
        <button
          onClick={()=> setShowContent(true)}
        >Show Content</button>
      }
    </div>
  )
}

export default UseOnClickOutsideTest
