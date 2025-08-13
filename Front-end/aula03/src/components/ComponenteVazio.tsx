interface MyComponentProps{
  color: string;
}

const ComponenteVazio = ({ color }: MyComponentProps) => {
  return (
    <p style={{ color }}>oi</p>
  )
}

export default ComponenteVazio