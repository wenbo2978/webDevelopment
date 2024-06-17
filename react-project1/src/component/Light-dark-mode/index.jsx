import React from 'react'
import useLocalStorage from './useLocalStorage'
import './style.css'

const LightDarkMode = () => {
  const [theme, setTheme] = useLocalStorage("theme", "dark");
  const handleToggleTheme = () => {
    setTheme(theme === "dark" ? "light" : "dark");
  }

  console.log(theme);

  return (
    <div className='light-dark-mode' data-theme={theme}>
      <div className='light-dark-container'>
        <p>Hello World</p>
        <button onClick={handleToggleTheme}>Change Theme</button>
      </div>
    </div>
  )
}

export default LightDarkMode
