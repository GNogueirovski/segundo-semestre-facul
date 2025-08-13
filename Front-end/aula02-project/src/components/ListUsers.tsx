const ListUserComponent = () => {
    const users: Array<{ name: string, age: number, email: string }> = [
        { name: 'Alice', age: 30, email: 'alice@example.com' },
        { name: 'Bob', age: 25, email: 'bob@example.com' },
        { name: 'Charlie', age: 35, email: 'charlie@example.com' },
    ];

    return (
        <ul>
            {users.map((user, index) => (
                <li key={index}>
                    {user.name} - {user.age} - {user.email}
                </li>
            ))}
        </ul>
    );
}

export default ListUserComponent;
