/*
useEffect it will be called when all the Dom elements will be rendered in browser, 
useLayoutEffect will be called before that

*/

import { useLayoutEffect, useState } from "react";

export default function useWindowResize(){
  const [windowSize, setWindowSize] = useState({
    width: 0,
    height: 0
  });

  function handleResize(){
    setWindowSize({
      width : window.innerWidth,
      height : window.innerHeight
    })
  }

  useLayoutEffect(()=>{
    console.log('add');
    handleResize();
    window.addEventListener('resize', handleResize);
    return ()=>{
      console.log('remove');
      window.removeEventListener('resize', handleResize);
    }
  }, []);
  return windowSize;
}