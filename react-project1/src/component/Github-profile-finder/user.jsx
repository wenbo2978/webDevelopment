import React from 'react'

const User = ({user}) => {
  const {avatar_url, 
    followers, 
    following,
    public_repos,
    url,
    name,
    login,
    created_at
  } = user;
  

  const createDate = new Date(created_at);
  
  return (
    <div className='user-container'>
      <div>
        <img src={avatar_url} 
          className='avatar'
          alt='User'
        />
      </div>
      <div className='name-container'>
        <a href={`https://github.com/${login}`}>{name || login}</a>
        <p>User joined on {`${createDate.getDate()} 
            ${createDate.toLocaleDateString('en-us', {
              month: 'short'
            })} ${createDate.getFullYear()}
          `}
        </p>
      </div>
      <div className='profile-info'>
        <div>
          <p>Puclic Repos</p>
          <p>{public_repos}</p>
        </div>
        <div>
          <p>Followers</p>
          <p>{followers}</p>
        </div>
        <div>
          <p>Following</p>
          <p>{following}</p>
        </div>
      </div>
    </div>
  )
}

export default User
