import React from 'react'

const ProfilePicture = () => {
  const imageUrl = '../src/assets/image/profilePicture.jpg';
  const handleClick = (e) => {
    e.target.style.display = "none";
  }
  return (
    <div>
      <img onClick={(e) => handleClick(e)} src={imageUrl}></img>
    </div>
  )
}

export default ProfilePicture
