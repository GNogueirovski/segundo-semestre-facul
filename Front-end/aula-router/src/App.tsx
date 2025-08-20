import { BrowserRouter, Route, Routes } from 'react-router-dom'
import './App.css'
import HomePage from './Pages/Home/Home'
import AboutPage from './Pages/About/About'
import NotFoundPage from './Pages/NotFound/NotFound'
import UserPage from './Pages/User/User'

function App() {

  return (
    <>
    <BrowserRouter>
    <Routes>
      <Route path='/' element={<HomePage/>}/>
      <Route path='/about' element={<AboutPage/>}/>
      <Route path= '/user/:id' element={<UserPage/>}/>
      <Route path='*' element={<NotFoundPage/>}/>
      </Routes>
      </BrowserRouter>



    </>
  )
}

export default App
