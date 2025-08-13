import { useState } from 'react'
import './App.css'
import WelcomeComponent from './components/WelcomeComponent'
import ProfileComponent from './components/Profile'
import ListComponent from './components/List'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <WelcomeComponent />
      <ProfileComponent />
      <ListComponent />
    </>
  )
}

export default App
