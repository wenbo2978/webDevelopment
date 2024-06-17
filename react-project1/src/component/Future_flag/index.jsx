import React, { useContext } from 'react'
import LightDarkMode from '../Light-dark-mode'
import TicTacToe from '../Tic-tac-toe'
import RandomColor from '../Random-color'
import Accordian from '../Accordian'
import TreeView from '../NavigationBar'
import { FeatureFlagContext } from './context'

/**
 * 
 * this is children component,
 * it can receive value from its parent
 * 
 * 
 */
const FeatureFlags = () => {

  const {loading, enableFlags} = useContext(FeatureFlagContext);

  const componentsToRender = [
    {
      key: "showLightAndDarkMode",
      component: <LightDarkMode/>
    },
    {
      key: "showTicTacToeBoard",
      component: <TicTacToe/>
    },
    {
      key: "showRandomColorGenerator",
      component: <RandomColor/>
    },
    {
      key: "showAccordian",
      component: <Accordian/>
    },
    {
      key: "showTreeView",
      component: <TreeView/>
    }
  ];

  function checkEnabledFlags(getCurrentKey){
    return enableFlags[getCurrentKey];
  }
  if(loading){
    return <h1>Loading data, please wait</h1>
  }

  return (
    <div>
      <h1>FeatureFlags</h1>
      {
        componentsToRender.map(
          componentItem => checkEnabledFlags(componentItem.key)
          ?
          componentItem.component : 
          null
        )
      }
    </div>
  )
}

export default FeatureFlags
