import React, { useEffect, useState } from 'react'
import {BsArrowLeftCircleFill, BsArrowRightCircleFill} from 'react-icons/bs'
import "./style.css"

const ImageSlider = ({url, limit = 5, page = 1}) => {
  const [images, setImages] = useState([]);
  const [currentSlide, setCurrentSlide] = useState(0);
  const [errorMsg, setErrorMsg] = useState(null);
  const [loading, setLoading] = useState(false);

  const handleCircleIndicator = (getCurrentIndex) => {
    setCurrentSlide(getCurrentIndex);
  }

  const handleLeftArrow = () => {
    //console.log(currentSlide);

    setCurrentSlide(currentSlide === 0 ? images.length - 1 : currentSlide - 1);
  }

  const handleRightArrow = () => {
    setCurrentSlide(c => ((c + 1) % images.length));
    console.log(currentSlide);
  }

  async function fetchImages(getUrl){
    try{
      setLoading(true);
      const response = await fetch(`${getUrl}?page=${page}&limit=${limit}`);
      const data = await response.json();

      if(data){
        setImages(data);
        setLoading(false);
      }
    }catch(e){
      setErrorMsg(e.message);
      setLoading(false);
    }
  }
  useEffect(()=> {
    if(url !== ''){
      fetchImages(url)
    }
  }, [url]);

  console.log('21341');

  if(loading){
    return <div>Liading data ! Please wait</div>
  }

  console.log("7456");

  if(errorMsg !== null){
    return <div>Error occurred ! {errorMsg}</div>
  }

  return (
    <div className='container'>
      <BsArrowLeftCircleFill 
        className='arrow arrow-left' 
        onClick={handleLeftArrow}
      />
      {
        images && images.length ? (
          images.map((imagheItem, index) => (
            currentSlide === index ? (
              <img
                key={imagheItem.id}
                alt={imagheItem.download_url}
                src={imagheItem.download_url}
                className='current-image'
              />
            ) : null
          ))
        ) : (
          null
        )
      }
      <BsArrowRightCircleFill 
        className='arrow arrow-right'
        onClick={handleRightArrow}
      />
      <span className='circle-indicators'>
        {
          images && images.length ? (
            images.map((_, index) => (
              <button
               key={index}
               className= {index === currentSlide 
                ? 'current-indicator' :
                'current-indicator inactive-indicator'
              }
               onClick={() => handleCircleIndicator(index)}
              ></button>
            ))
          ) : null
        }
      </span>
    </div>
  )
}

export default ImageSlider
