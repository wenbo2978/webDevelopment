import { createContext, useEffect, useState } from "react";
import featureFlagDataServiceCall from "../data";


export const FeatureFlagContext = createContext(null);

/**
 * this is the parent component
 * it can pass any value by context to its children 
 * give any value that you want to pass to children component to the context
 * 
 */

export default function FeatureFlagGlobalState({children}) {
  const [loading, setLoading] = useState(false);
  //components
  const [enableFlags, setEnableFlags] = useState({});

  async function fetchFeatureFlags(){
    try{
      setLoading(true);
      const response = await featureFlagDataServiceCall();
      console.log(response);
      setEnableFlags(response);
      setLoading(false);
    }catch(error){
      setLoading(false);
      console.log(error);
      throw new Error(error);
      //console.log(uuu);
    }
  }
  //get the data when mount the page
  useEffect(()=>{
    fetchFeatureFlags();
  }, []);
  return (
    <FeatureFlagContext.Provider value={{loading, enableFlags}}>
      {children}
    </FeatureFlagContext.Provider>
  )
}