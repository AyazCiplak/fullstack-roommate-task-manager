import { useParams, useNavigate, Link } from 'react-router-dom';
import useFetch from '../services/useFetch';
import TaskService from '../services/TaskService';

const TaskDetails = () => {

    const { id } = useParams();
    const { data: task, dataPending, error } = useFetch('http://localhost:8080/api/v1/tasks/' + id);
    const navigate = useNavigate();

    const handleClick = () => {
        TaskService.deleteTask(id)
            .then(() => {
                navigate("/");
            })
    };

    return (
        <div className="task-details">
            <h2>Task details</h2>
            {dataPending && <div>Loading...</div>}
            {error && <div>{error}</div>}
            {task && (
                <article>
                    <h3>Title: {task.title}</h3>
                    <p><b>Description:</b> {task.description}</p>
                    <p><b>Responsible:</b> {task.responsible}</p>
                    <p><b>Due date:</b> {task.date || <span>No Date</span>}</p>
                    <div className="details-buttons">
                        <Link to="/">
                            <button>Back</button>
                        </Link>
                        <button onClick={handleClick}>Delete Task</button>
                    </div>
                </article>
            )}


        </div>
    );
}

export default TaskDetails;