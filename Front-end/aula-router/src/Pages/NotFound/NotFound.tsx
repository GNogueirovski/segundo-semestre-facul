
import { useNavigate } from 'react-router-dom'

const NotFoundPage = () =>{
    const navigate = useNavigate()

    const toHomePage = () => {
        console.error('Redirect 404 to Home Page')
        navigate('/')
    }

    return(
        <div>
            <h1>Not Found - 404</h1>
            <button onClick={toHomePage}>Go to HomePage</button>
        </div>
    )
}

export default NotFoundPage