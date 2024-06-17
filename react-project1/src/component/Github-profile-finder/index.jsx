import React, { useEffect, useState } from 'react'
import User from './user';
import './style.css'

const GithubProfileFinder = () => {
  const [userName, setUserName] = useState('wenbo2978');
  const [userData, setUserData] = useState(null);
  const [loading, setLoading] = useState(false);
  const handleSubmit = ()=> {
    fetchGithubUserData();
  }

  async function fetchGithubUserData(){
    try{
      setLoading(true);
      const res = await fetch(`https://api.github.com/users/${userName}`);
      const data = await res.json();
      
      if(data){
        setUserData(data);
        setLoading(false);
      }
      //console.log(data);
    }catch(error){
      console.log(error);
      setLoading(false);
    }
  }

  useEffect(()=> {
    fetchGithubUserData();
  }, [])

  if(loading){
    return <div>Loading data, please wait!!!</div>
  }
  return (
    <div className='github-profile-container'>
      <div className='input-wrapper'>
        <input
          name='search-by-username'
          type='text'
          placeholder='Search Github Username...'
          value={userName}
          onChange={(event)=> setUserName(event.target.value)}
        />
        <button onClick={handleSubmit}>Search</button>
      </div>
      {
        userData !== null ? <User user={userData}/> : null
      }
    </div>
  )
}

export default GithubProfileFinder
