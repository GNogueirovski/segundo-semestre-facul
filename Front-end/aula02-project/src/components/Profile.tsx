const ProfileComponent = () => {
    const user = {
        name: "Gabriel Peixoto",
        age: 23,
        birthday: "2002-06-07",
        email: "gabriel.peixoto@gmail.com"
    }

    return (
        <div>
            <h2>Profile Information</h2>
            <p>Name: {user.name}</p>
            <p>Age: {user.age}</p>
            <p>Birthday: {user.birthday}</p>
            <p>Email: {user.email}</p>
        </div>
    )
}

export default ProfileComponent;
