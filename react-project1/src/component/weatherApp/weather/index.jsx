import React, { useEffect, useState } from 'react'
import './style.css'
import Search from '../search'

const Weather = () => {
  const [search, setSearch] = useState('');
  const [loading, setLoading] = useState(false);
  const [weatherData, setWeatherData] = useState(null);
  const APIKey = "26b9c8db630ef89cd14577c941d7872f";


  async function fetchWeatherData(pattern){
    setLoading(true);
    try{
      const response = await fetch(`https://api.openweathermap.org/data/2.5/weather?q=${pattern}&appid=${APIKey}`);
      const data = await response.json();
      console.log(data);
      if(data){
        setLoading(false);
        setWeatherData(data);
      }
    }catch(e){
      console.log(e);
      setLoading(false);
    }
  }

  function handleSearch(){
    console.log("hand");
    fetchWeatherData(search);
  }

  function getCurrentDate(){
    return new Date().toLocaleDateString('en-us', {
      weekday : 'long',
      month : 'long',
      day : 'numeric',
      year : 'numeric'
    })
  }

  useEffect(()=>{
    console.log("eff");
    fetchWeatherData('shanghai');
  }, []);


  return (
    <div style={{
      width : '100vw',
    }}>
      <div className='weather-container'>
        <Search
          search={search}
          setSearch={setSearch}
          handleSearch={handleSearch}
        />
        {
          loading ? <div className='weather-loading'>Loading...</div> : 
          (
            <div style={{
              width: "80%"
            }}>
              <div className='city-name'>
                <h1>
                  {weatherData?.name}, 
                  <span>{weatherData?.sys?.country}</span>
                </h1>
              </div>
              <div className='weather-date'>
                <span>{getCurrentDate()}</span>
              </div>
              <div className='weather-temperature'>
                {weatherData?.main?.temp}
              </div>
              <p className='weather-description'>
                
                {
                  weatherData && weatherData.weather &&
                  weatherData.weather[0] ? 
                  weatherData.weather[0].description : " "
                }
              </p>
              <div className='weather-info'>
                <div className='weather-column'>
                  <div>
                    <p className='weather-wind'>
                      {
                        weatherData?.wind?.speed
                      }
                    </p>
                    <p>Wind Speed</p>
                  </div>
                </div>
                <div className='weather-column'>
                  <div>
                    <p className='weather-humidity'>
                      {weatherData?.main?.humidity}%
                    </p>
                    <p>Humidity</p>
                  </div>
                </div>
              </div>

            </div>
          )
        }
      </div>
    </div>
  )
}

export default Weather
