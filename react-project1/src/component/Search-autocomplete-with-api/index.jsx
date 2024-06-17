import React, { useEffect, useState } from 'react'

const SearchAutoComplete = () => {
  const [loading, setLoading] = useState(false);
  const [users, setUsers] = useState([]);
  const [error, setError] = useState(null);
  const [searchParam, setSearchParam] = useState('');
  const [showDropDown, setShowDropDown] = useState(false);
  const [filterUsers, setFilterUsers] = useState([]);

  async function fetchListOfUsers(){
    try{
      setLoading(true);
      const res = await fetch('https://dummyjson.com/users');
      const data = await res.json();
      //console.log(data);
      if(data && data.users && data.users.length){
        setUsers(data.users.map(userItem => userItem.firstName));
        setLoading(false);
        setError(false);
      }
      
    }catch(error){
      console.log(error);
      setError(error);
      setLoading(false);
    }
  }
  useEffect(()=>{
    fetchListOfUsers();
  }, []);
  function handleSearchInput(event){
    const query = event.target.value.toLowerCase();
    console.log(query);
    setSearchParam(query);
    if(query.length >= 1){
      const filteredData = users && users.length ? (
        users.filter((item) => item.toLowerCase().indexOf(query) > -1)
      ): [];
      setFilterUsers(filteredData);
      setShowDropDown(true);
    }else{
      setShowDropDown(false);
    }
  }
  console.log(filterUsers);
  if(error){
    return <div>Error Happend</div>
  }
  if(loading){
    return <div>Loading data !! Please wait</div>
  }
  return (
    <div className='search-autocomplete-container'>
      <input onChange={(event)=>handleSearchInput(event)} value={searchParam} name='search-users' placeholder='Search Users here...' />
      <div className='show-filter-user-container'>
        {
          showDropDown && filterUsers && filterUsers.length ? (
            filterUsers.map((item, index) => (
              <li key={index}>{item}</li>
            ))
          ) : <div>No Data Found</div>
        }
      </div>
    </div>
  )
}

export default SearchAutoComplete
