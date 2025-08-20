import { Link, useNavigate, useParams } from 'react-router-dom'
import './User.css'
import { useEffect } from 'react'

const UserPage = () =>{

    const {id} = useParams()
    const navigate = useNavigate()

    useEffect(() => {
        if (id && parseInt(id) > 5){
            console.error('Usuário não encontrado')
            navigate('/404')
        }
    })


    return(
        <div>
            <h1>User Page</h1>
            <p> User ID: {id}</p>
           
            <Link to='/'>Go to HomePage</Link>
        </div>
    )
}

export default UserPage