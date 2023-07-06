import Navbar from './components/Navbar';
import Home from './components/Home';
import CreateTask from './components/CreateTask';
import CreateUser from './components/CreateUser';
import Settings from './components/Settings';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import TaskDetails from './components/TaskDetails';
import UserDetails from './components/UserDetails';

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

