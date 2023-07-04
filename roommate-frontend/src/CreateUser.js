import { useState } from 'react';
import { useNavigate, Link } from 'react-router-dom';
import axios from 'axios';



const CreateUser = () => {

    //Empty states to be filled with info from input form
    const [name, setName] = useState('');
    const [description, setDescription] = useState('');

    const [isPending, setIsPending] = useState(false);
    const navigate = useNavigate();

    const USER_API_BASE_URL = "http://localhost:8080/api/v1/roommates"


    const handleSubmit = (e) => {
        e.preventDefault();
        const user = { name, description };

        setIsPending(true);

        //Make POST request to API
        axios.post(USER_API_BASE_URL, user)
            .then(() => {
                console.log("New user added");
                setIsPending(false);
                navigate('/');
            })
    }

    return (
        <div className="create-user">
            <h2>Add a new user</h2>
            <form onSubmit={handleSubmit}>
                <label>Name: </label>
                <input
                    type="text"
                    required
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                />
                <label>Description: </label>
                <textarea
                    required
                    value={description}
                    onChange={(e) => setDescription(e.target.value)}
                ></textarea>
                <div className="create-buttons">
                    <Link to="/">
                        <button className="back-button">Back</button>
                    </Link>
                    {!isPending && <button>Add User</button>}
                    {isPending && <button disabled>Adding user...</button>}
                </div>

            </form>


        </div>
    );
}

export default CreateUser;