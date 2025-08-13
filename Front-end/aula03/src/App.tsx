import { useState } from 'react'
import './App.css'
import ComponenteVazio from './components/ComponenteVazio'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
    <ComponenteVazio color="red" />
    </>
  )
}

export default App
