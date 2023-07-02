import Navbar from './Navbar';
import Home from './Home';
import CreateTask from './CreateTask';
import CreateUser from './CreateUser'
import Settings from './Settings';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import TaskDetails from './TaskDetails';
import UserDetails from './UserDetails';

function App() {
  return (
    <Router>
      <div className="App">
        <Navbar />
        <div className="content">
          <Routes>
            <Route exact path='/' element={<Home />} />
            <Route path="/users/:id" element={<UserDetails />} />
            <Route path='/new-user' element={<CreateUser />} />
            <Route path='/new-task' element={<CreateTask />} />
            <Route path="/tasks/:id" element={<TaskDetails />} />
            <Route path='/settings' element={<Settings />} />
          </Routes>
        </div>
      </div>
    </Router>
  );
}

export default App;

