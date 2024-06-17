import React, { useContext } from 'react'
import { GlobalContext } from '../../context'
import RecipeItem from '../../components/recipe-list';

const Home = () => {
  
  const {recipeList, loading} = useContext(GlobalContext);
  if(loading){
    return <div>Loading ! wait !!</div>
  }
  return (
    <div className='py-8 mx-auto flex flex-wrap justify-center gap-10'>
      {
        recipeList && recipeList.length > 0 ? 
        recipeList.map((item, index)=><RecipeItem key={index} item={item}/>)
        : <div>
          <p className='lg:text-4xl text-xl text-center text-black font-extrabold'>Nothing is found</p>
        </div>
      }
    </div>
  )
}

export default Home
