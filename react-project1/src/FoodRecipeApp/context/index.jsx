import { createContext, useState } from "react";

export const GlobalContext = createContext(null);

export default function GlobalState({children}){
  const [searchParam, setSearchParam] = useState('');
  const [loading, setLoading] = useState(false);
  const [recipeList, setRecipeList] = useState([]);
  const [recipeDetailData, setRecipeDetailData] = useState(null);
  const [favoritesList, setFavoritesList] = useState([]);

  async function handleSubmit(event){
    event.preventDefault(); // like ajax, without reload the page
    setLoading(true);
    try{
      const res = await fetch(
        `https://forkify-api.herokuapp.com/api/v2/recipes?search=${searchParam}`
      );
      const data = await res.json();
      //console.log(data);
      if(data?.data?.recipes){
        setRecipeList(data?.data?.recipes);
        setLoading(false);
        setSearchParam('');
      }
    }catch(e){
      setLoading(false);
      //console.log(e);
      setSearchParam('');
    }
  }

  function handleAddFavorite(getCurrentItem){
    //console.log(getCurrentItem);
    let cpyF = [...favoritesList];
    const index = cpyF.findIndex(item => item.id === getCurrentItem.id);
    if(index === -1){
      cpyF.push(getCurrentItem);
    }else{
      cpyF.splice(index);
    }
    setFavoritesList(cpyF);
    
  }
  //console.log(favoritesList, "favoriteItem");
  return <GlobalContext.Provider 
      value={{
        searchParam, 
        loading, 
        recipeList, 
        recipeDetailData,
        setSearchParam, 
        handleSubmit, 
        setRecipeDetailData,
        handleAddFavorite,
        favoritesList
      }}
    >
    {children}
  </GlobalContext.Provider>
}