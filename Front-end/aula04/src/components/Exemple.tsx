import { useState } from "react"

const ExempleComponent = () => {
    const [name, setName] = useState<string>('')
    return(
        <>
        <h6>Exemplo de Estado</h6>
        <p>Nome:
            <span>
                {name}
            </span>
        </p>
        <button onClick={() => setName('Gabriel')}>
        Clique em Mim
        </button>

        </>
    )
}

export default ExempleComponent