import React, { useState } from "react";
import { FaStar } from "react-icons/fa";
import "./style.css";

const StarRate = ({ numberOfStars = 5 }) => {
  const [rating, setRating] = useState(0);
  const [hover, setHover] = useState(0);
  const handleClick = (getCurrentId: number) => {
    setRating(getCurrentId);
  };

  const handleMouseMove = (getCurrentId: number) => {
    setHover(getCurrentId);
  };

  const handleMouseLeave = () => {
    setHover(rating);
  };
  return (
    <div className="star-rating">
      {[...Array(numberOfStars)].map((_, index) => {
        index += 1;
        return (
          <FaStar
            className={index <= (hover || rating) ? "active" : "inactive"}
            key={index}
            onClick={() => handleClick(index)}
            onMouseMove={() => handleMouseMove(index)}
            onMouseLeave={() => handleMouseLeave()}
            size={40}
          />
        );
      })}
    </div>
  );
};

export default StarRate;
