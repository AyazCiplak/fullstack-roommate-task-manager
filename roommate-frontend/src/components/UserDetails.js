import { useParams, useNavigate, Link } from 'react-router-dom';
import useFetch from '../services/useFetch';
import UserService from '../services/UserService'


const UserDetails = () => {

    const { id } = useParams();
    const { data: user, dataPending, error } = useFetch('http://localhost:8080/api/v1/users/' + id);
    const navigate = useNavigate();

    const handleClick = () => {
        UserService.deleteUser(id)
            .then(() => {
                navigate("/");
            })
    };

    return (
        <div className="user-details">
            <h2>User Details</h2>
            {dataPending && <div>Loading...</div>}
            {error && <div>{error}</div>}
            {user && (
                <article>
                    <h3>Name: {user.name}</h3>
                    <p><b>Description:</b> {user.description}</p>
                    <div className="details-buttons">
                        <Link to="/">
                            <button>Back</button>
                        </Link>
                        <button onClick={handleClick}>Delete User</button>
                    </div>
                </article>
            )}

        </div>
    );
}

export default UserDetails;