import React from 'react'
import MainPageBar from './navBar'
import {Routes, Route} from 'react-router-dom'
import FoodRecipeApp from '../FoodRecipeApp'
import MainPage from './mainPage'
import './style.css'
import Weather from '../component/weatherApp/weather'
import GithubProfileFinder from '../component/Github-profile-finder'
import TabTest from '../component/Custom-tabs/tab-test'
import ScrollToCertainSection from '../component/Scroll-to-top-and-buttom/scroll-to-certain-section'
import ScrollToTopAndButtom from '../component/Scroll-to-top-and-buttom'
import UseWindowResizeTest from '../component/Use-window-resize/test'
import UseOnClickOutsideTest from '../component/Use-outside-click/test'
import UseFetchHookTest from '../component/Use-fetch/test'
import UseContextTest from '../component/Future_flag/useContextTest'
import TicTacToe from '../component/Tic-tac-toe'
import SearchAutoComplete from '../component/Search-autocomplete-with-api'
import ModalTest from '../component/Custom-modal-popup/modal-test'
import ScrollIndicator from '../component/Scroll-indicator'
import LightDarkMode from '../component/Light-dark-mode'
import QRCodeGenerator from '../component/QR-Code'
import TreeView from '../component/NavigationBar'
import LoadMoreData from '../component/Load-more-data'
import ImageSlider from '../component/Image-slider'
import StarRate from '../component/Star-rate'
import RandomColor from '../component/Random-color'
import Accordian from '../component/Accordian'
import Stopwatch from '../component/StopWatch/Stopwatch'
import ProfilePicture from '../component/ProfilePicture/ProfilePicture'
import DigitalClock from '../component/DigitalClock/DigitalClock'

const WelcomePage = () => {
  return (
    <div className='main-page-container'>
      <MainPageBar />
      <Routes>
        
        <Route path='/' element={<MainPage/>}/>
        <Route path='profilePicture' element={<ProfilePicture/>}/>
        <Route path='accordian' element={<Accordian/>}/>
        <Route path='randomColor' element={<RandomColor/>}/>
        <Route path='starRate' element={<StarRate numberOfStars={10}/>}/>
        <Route path='imageSlider' element={<ImageSlider 
          url={'https://picsum.photos/v2/list'} 
          limit={'4'} 
          page={'1'}/>}
        />
        <Route path='loadMoreData' element={<LoadMoreData/>}/>
        <Route path='treeView' element={<TreeView/>}/>
        <Route path='qRCodeGenerator' element={<QRCodeGenerator/>}/>
        <Route path='lightDarkMode' element={<LightDarkMode/>}/>
        <Route path='scrollIndicator' element={<ScrollIndicator url={'https://dummyjson.com/products?limit=100'}/>}/>
        <Route path='modalTest' element={<ModalTest/>}/>
        <Route path='searchAutoComplete' element={<SearchAutoComplete/>}/>
        <Route path='ticTacToe' element={<TicTacToe/>}/>
        <Route path='useContextTest' element={<UseContextTest/>}/>
        <Route path='useFetchHookTest' element={<UseFetchHookTest/>}/>
        <Route path='useOnClickOutsideTest' element={<UseOnClickOutsideTest/>}/>
        <Route path='useWindowResizeTest' element={<UseWindowResizeTest/>}/>
        <Route path='tabTest' element={<TabTest/>}/>
        <Route path='scrollToTopAndButtom' element={<ScrollToTopAndButtom/>}/>
        <Route path='scrollToCertainSection' element={<ScrollToCertainSection/>}/>
        <Route path='githubProfileFinder' element={<GithubProfileFinder/>}/>
        <Route path='weather' element={<Weather/>}/>
        <Route path='digitalClock' element={<DigitalClock/>}/>
        <Route path='stopWatch' element={<Stopwatch/>}/>
        <Route path='foodRecipeApp/*' element={<FoodRecipeApp/>}/>
      </Routes>
    </div>
  )
}

export default WelcomePage
