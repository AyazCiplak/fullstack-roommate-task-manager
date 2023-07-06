import { useState } from 'react';
import { useNavigate, Link } from 'react-router-dom';
import useFetch from '../services/useFetch';
import TaskService from '../services/TaskService';



const CreateTask = () => {

    //Empty states to be filled with info from input form
    const [title, setTitle] = useState('');
    const [description, setDescription] = useState('');
    const [responsible, setResponsible] = useState('None');
    const [date, setDate] = useState('');

    const [isPending, setIsPending] = useState(false);
    const navigate = useNavigate();

    const USER_API_BASE_URL = "http://localhost:8080/api/v1/users"

    //Fetches user data from database
    const { data: users, dataPending: usersPending, error: usersError } = useFetch(USER_API_BASE_URL);

    const handleSubmit = (e) => {
        e.preventDefault();
        const task = { title, description, responsible, date };

        setIsPending(true);

        TaskService.saveTask(task)
            .then((response) => {
                console.log("New task added");
                console.log("Response:" + response)
                setIsPending(false);
                navigate('/');
            })
            .catch((error) => {
                console.log(error)
            })
    }

    return (
        <div className="create-task">
            <h2>Add a new task</h2>
            <form onSubmit={handleSubmit}>
                <label>Task title: </label>
                <input
                    type="text"
                    required
                    value={title}
                    //Changes recorded values dynamically during input
                    onChange={(e) => setTitle(e.target.value)}
                />
                <label>Description: </label>
                <textarea
                    required
                    value={description}
                    onChange={(e) => setDescription(e.target.value)}
                ></textarea>
                <label>Responsible: </label>
                <select
                    value={responsible}
                    onChange={(e) => setResponsible(e.target.value)}
                >
                    {
                        //Lists users based on current contents of database
                    }
                    <option value="None">Select...</option>
                    <option value="All">Everyone</option>
                    {users &&
                        users.map((user) => (
                            <option value={user.name}>{user.name}</option>
                        ))}
                </select>
                <label>Due date: </label>
                <input
                    type="text"
                    value={date}
                    onChange={(e) => setDate(e.target.value)}
                />
                {
                    //Disables button if already submitted and pending
                }
                <div className="create-buttons">
                    <Link to="/">
                        <button className="back-button">Back</button>
                    </Link>
                    {!isPending && <button>Add task</button>}
                    {isPending && <button disabled>Adding task...</button>}
                </div>
            </form>


        </div>
    );
}

export default CreateTask;