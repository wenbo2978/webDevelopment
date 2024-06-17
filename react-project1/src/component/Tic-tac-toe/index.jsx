import React, { useEffect, useState } from 'react'
import './style.css'

function Square({value, onClick}){
  return <button onClick={onClick} className='square-button'>{value}</button>
}

const TicTacToe = () => {
  const [squares, setSquares] = useState(Array(9).fill(''));
  const [isXTurn, setIsXTurn] = useState(true);
  //const [isWinner, setIsWinner] = useState(false);
  const [status, setStatus] = useState('');
  function handleRestart(){
    setIsXTurn(true);
    setSquares(Array(9).fill(''));
    //setIsWinner(false);
  }
  function getWinner(squares){
    const matchPattern = [
      [0, 1, 2],
      [3, 4, 5],
      [6, 7, 8],
      [0, 3, 6],
      [1, 4, 7],
      [2, 5, 8],
      [0, 4, 8],
      [2, 4, 6]
    ];
    for(let i = 0; i < matchPattern.length; i ++){
      if(squares[matchPattern[i][0]] === squares[matchPattern[i][1]]
        && squares[matchPattern[i][2]] === squares[matchPattern[i][1]]
        && squares[matchPattern[i][2]] !== ''){
          //setIsWinner(true);
          return squares[matchPattern[i][0]];
      }
    }
    return null;
  }

  function handleClick(index){
    if(getWinner(squares) || squares[index])
      return;
    let cypSquare = [...squares];
    if(isXTurn){
      cypSquare[index] = 'X';
      setIsXTurn(!isXTurn)
    }else{
      cypSquare[index] = 'O';
      setIsXTurn(!isXTurn);
    }
    
    setSquares(cypSquare);
  }

  
  useEffect(()=>{
    if(!getWinner(squares) && squares.every(item => item !== '')){
      setStatus('This is a draw, Please restart the game');
    }else if(getWinner(squares)){
      setStatus(`Winner is ${getWinner(squares)}`);
    }else{
      setStatus(`Next player is ${isXTurn ? 'X' : 'O'}`);
    }
  }, [squares, isXTurn]);


  return (
    <div className='tic-tac-toe-container'>
      <div className='tic-tac-toe-row'>
        <Square value={squares[0]} onClick={()=>handleClick(0)} />
        <Square value={squares[1]} onClick={()=>handleClick(1)}/>
        <Square value={squares[2]} onClick={()=>handleClick(2)}/>
      </div>
      <div className='tic-tac-toe-row'>
        <Square value={squares[3]} onClick={()=>handleClick(3)}/>
        <Square value={squares[4]} onClick={()=>handleClick(4)}/>
        <Square value={squares[5]} onClick={()=>handleClick(5)}/>
      </div>
      <div className='tic-tac-toe-row'>
        <Square value={squares[6]} onClick={()=>handleClick(6)}/>
        <Square value={squares[7]} onClick={()=>handleClick(7)}/>
        <Square value={squares[8]} onClick={()=>handleClick(8)}/>
      </div>
      <h1>{status}</h1>
      <button onClick={handleRestart}>Restart</button>
    </div>
  )
}

export default TicTacToe
