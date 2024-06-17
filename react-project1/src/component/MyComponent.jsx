import React, {useState} from 'react'

const MyComponent = () => {
  const [name, setName] = useState('Guest');
  const [quantity, setQuantity] = useState(0);
  const [comment, setComment] = useState("");
  const [payment, setPayment] = useState("");
  const [shipping, setShipping] = useState("");
  const [age, setAge] = useState(0);
  const [isEmployed, setIsEmployed] = useState();
  const [car, setCar] = useState({year: 2007, 
                                  make: 'Toya',
                                  model: "Cam"});
  const [food, setFood] = useState(["apple", "orange", "banana"]);
  const handleChangeName = (event) => {
    //console.log(name);
    setName(event.target.value);
    //console.log(name);
  }
  const handleQuantityChange = (event) => {
    setQuantity(event.target.value);
  }
  const handleCommentChange = (event) => {
    setComment(event.target.value);
  }
  const handlePaymentChange = (event) => {
    setPayment(event.target.value);
  }
  const handleShippingChange = (event) => {
    setShipping(event.target.value);
  }
  const incrementAge = () => {
    setAge(age => age + 1); // update function
    setAge(age => age + 1);
    //setAge(age + 1);//it is not taking the current status, it takes pending status
  }
  const toggleEmployeeStatus = () => {
    setIsEmployed(!isEmployed);
  }
  const handleCarYearChange = (event) => {
    setCar(car => ({...car, year: event.target.value}));
  }
  const handleCarMakeChange = (event) => {
    setCar({...car, make: event.target.value});
  }
  const handleCarModelChange = (event) => {
    setCar({...car, model: event.target.value});
  }
  const handleFoodAdder = () => {
    const newFood = document.getElementById('food_adder').value;
    document.getElementById("food_adder").value = "";
    setFood(food => ([...food, newFood]));
  }
  const handleRemoveFood = (index) => {
    setFood(food.filter((_, i)=> index !== i));
  }
  return (
    <div>
      <p>Name: {name}</p>
      <input onChange={handleChangeName} value={name}></input>
      <p>Quantity: {quantity}</p>
      <input onChange={handleQuantityChange} value={quantity} type='number'></input>
      <p>Comment: {comment}</p>
      <textarea value={comment} onChange={handleCommentChange} placeholder='Enter delivery instructions'></textarea>
      <p>Payment: {payment}</p>
      <select value={payment} onChange={handlePaymentChange}>
        <option value="">Select an option</option>
        <option value="Visa">Visa</option>
        <option value="MasterCard">MasterCard</option>
        <option value="GiftCard">GiftCard</option>
      </select>
      <br/>
      <p>Shipping: {shipping}</p>
      <label>
        <input type='radio' value="Pick Up" onChange={handleShippingChange} checked={shipping === "Pick Up"}></input>
        Pick Up
      </label>
      <label>
        <input type='radio' value="Delivery" onChange={handleShippingChange} checked={shipping === "Delivery"}></input>
        Delivery
      </label>
      <p>Age: {age}</p>
      <button onClick={incrementAge}>Increment Age</button>
      <p>Is employee: {isEmployed ? "Yes" : "No"}</p>
      <button onClick={toggleEmployeeStatus}>Toggle Status</button>
      <p>My favorite car is: {car.year} {car.make} {car.model}</p>
      <input type="number" value={car.year} onChange={handleCarYearChange}></input><br/>
      <input type="text" value={car.make} onChange={handleCarMakeChange}></input><br/>
      <input type="text" value={car.model} onChange={handleCarModelChange}></input><br/>
      <p>Food</p>
      <ul>
        {food.map((f, index) => <li key={index} onClick={()=> handleRemoveFood(index)}>{f}</li>)}
      </ul>
      <input type='text' placeholder='type the food name you want' id='food_adder'></input>
      <button onClick={handleFoodAdder}>add food</button>
    </div>
  )
}

export default MyComponent
