import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import './index.css'
import {BrowserRouter} from 'react-router-dom'
import GlobalState from './FoodRecipeApp/context/index.jsx'

ReactDOM.createRoot(document.getElementById('root')).render(
  <BrowserRouter>
    <React.StrictMode>
      
      <App />
      {/**FoodRecipeApp */}
      {/*<GlobalState>
        <App />
      </GlobalState>*/}

    </React.StrictMode>,
  </BrowserRouter>
  
)
