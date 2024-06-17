import { useEffect } from "react";


export default function useOutSideClick(ref, handler){
  console.log('enter');
  useEffect(()=>{
    console.log('234');

    function listerner(event){
      if(!ref.current || ref.current.contains(event.target)){
        console.log(ref.current);
        return;
      }

      handler();
    }

    document.addEventListener('mousedown', listerner);
    document.addEventListener('touchstart', listerner);
    return ()=>{
      document.removeEventListener('mousedown', listerner);
      document.removeEventListener('touchstart', listerner);
    }
  }, [handler, ref]);
}