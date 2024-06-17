import { useEffect, useState } from "react";

export default function useFetch(url, options={}){
  const [data, setData] = useState(null);
  const [pending, setPending] = useState(false);
  const [error, setError] = useState(null);

  async function fetchData(){
    setPending(true);
    try{
      setPending(true);
      const res = await fetch(url, {...options});
      if(!res.ok){
        throw new Error(res.statusText);
      }

      const result = await res.json();
      setData(result);
      setError(null);
      setPending(false);

    }catch(e){
      setError(`${e}, error occured`);
      setPending(false);
    }
  }

  useEffect(()=>{
    fetchData();
  }, [url]);

  return {data, error, pending};
}