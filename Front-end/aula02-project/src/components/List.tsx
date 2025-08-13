const ListComponent = () => {
    const itens: string[] = ['Apple', 'Banana', 'Orange', 'Grape', 'Pineapple'];
    return (
        <ul>
            {itens.map((item, index) => (
                <li key={index}>{item}</li>
            ))}
        </ul>
    );
}

export default ListComponent;
