import List from './component/List'
import MyComponent from './component/MyComponent';
import ColorPicker from './component/ColorPicker';
import ToDoList from './component/ToDoList';
import MyComponent2 from './component/MyComponent2';
import MyComponent3 from './component/MyComponent3';
import MyComponent4 from './component/MyComponent4';

import { fruits, vegetables } from './assets/data';

import './App.css'
import WelcomePage from './WelcomePage';

function App() {
  
  /*
  return (
    <>
      {fruits.length > 0 ? <List items={fruits} category="Fruits"></List> : null}
      {vegetables.length > 0 ? <List items={vegetables} category="Vegetables"></List> : null}
    </>
  )
  */
  return (
    <div>
      
      {<WelcomePage />}
    </div>
  )

}

export default App
