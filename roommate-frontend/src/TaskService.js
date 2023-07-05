import axios from "axios"

const TASK_API_BASE_URL = "http://localhost:8080/api/v1/tasks";

class TaskService {
    saveTask(task) {
        return axios.post(TASK_API_BASE_URL, task);
    }

    deleteTask(id) {
        return axios.delete(TASK_API_BASE_URL + "/" + id);
    }
}

export default new TaskService()

