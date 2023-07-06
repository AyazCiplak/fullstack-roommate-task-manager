import UserList from './UserList';
import TaskList from './TaskList';
import useFetch from '../services/useFetch';
import { Link } from 'react-router-dom';

const Home = () => {

    const USER_API_BASE_URL = "http://localhost:8080/api/v1/users"
    const TASK_API_BASE_URL = "http://localhost:8080/api/v1/tasks"
    const { data: users, dataPending: usersPending, error: usersError } = useFetch(USER_API_BASE_URL)
    const { data: tasks, dataPending: tasksPending, error: tasksError } = useFetch(TASK_API_BASE_URL)

    //Note: && does not display the second element if the first one is false (cannot attempt to display unloaded data)
    return (
        <div className="home">
            <div className="users-header">
                <h2>Users</h2>
                <button className="new-user-button">
                    <Link className="new-user-text" to='/new-user'>New</Link>
                </button>
            </div>
            {usersError && <div>{usersError}</div>}
            {usersPending && <div>Loading users...</div>}
            {users && <UserList data={users} />}

            <div className="tasks-header">
                <h2>Tasks</h2>
                <button className="new-task-button">
                    <Link className="new-task-text" to='/new-task'>New</Link>
                </button>
            </div>
            {tasksError && <div>{tasksError}</div>}
            {tasksPending && <div>Loading tasks...</div>}
            {tasks && <TaskList data={tasks} />}
        </div>
    );
}

export default Home;