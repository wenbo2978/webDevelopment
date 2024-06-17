import React from 'react'
import GlobalState from './context'
import Navbar from './components/navbar'
import Home from './pages/home'
import Details from './pages/details'
import Favorites from './pages/favorites'
import {Routes, Route} from 'react-router-dom'

const FoodRecipeApp = () => {
  return (
    <div style={{
      width : "100vw"
    }}>
      <GlobalState>
        <div className='min-h-screen p-6 bg-white text-gray-600 text-lg'>
          <Navbar/>
          <Routes>
            <Route
              path='/'
              element={
                <Home/>
              }
            />
            <Route
              path='/favorites'
              element={
                <Favorites/>
              }
            />
            <Route
              path='/recipe-item/:id'
              element={
                <Details/>
              }
            />
          </Routes>
        </div>
      </GlobalState>
    </div>
    
  )
}

export default FoodRecipeApp
