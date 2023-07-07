# Roommate Task Manager (Full Stack version)
Full-stack application designed to facilitate delegation of tasks and chores among roommates. This project incorporates the front-end component I created in React, and extends it with full back-end functionality. Features: 
- Add, remove and modify a list of users/roommates
- Create tasks with descriptions, due dates, and inidividuals responsible for them (list of options based on the list of users created)
- View user and task descriptions
- Complete tasks by checking them off the list, or deleting them from their details page

This application incorporates a Java + Spring backend, connected to a MySQL database. The frontend component is written in React.js, using CSS for styling. REST APIs are defined in the backend and used for interaction between the input in the frontend and the database. 

# Screenshots
Home page: 
![image](https://github.com/AyazCiplak/fullstack-roommate-task-manager/assets/97311304/0964974d-9f44-41df-b6e0-5c15ac1263e6)

Task creation form (reached by clicking on the "new" button beside the Tasks header, or by clicking "New Task" on the navbar):
![image](https://github.com/AyazCiplak/fullstack-roommate-task-manager/assets/97311304/b3c2d913-d1b5-4d74-ab92-000606471869)

Task detail page (reached by clicking on a task name in the list): 
![image](https://github.com/AyazCiplak/fullstack-roommate-task-manager/assets/97311304/cbc939b1-67fc-4568-a20c-b061ec016d1a)

Database structure created in MySQL (screenshot taken on MySQL Workbench):
![image](https://github.com/AyazCiplak/fullstack-roommate-task-manager/assets/97311304/9cd418af-61a6-455b-83d6-43467edd170f)


# Technologies used 
- React.js for all frontend webpage functionality
- CSS for most styling and display of items
- Java to write the logic of the back end implementation
- Spring and Spring boot to initialize the Java backend project (and provide functionality like Autowiring components and using Beans)
- MySQL (with MySQL workbench) to define and view the content of the databases externally
- Additional tools used:
  - Postman (for API testing)
  - VSCode and Intellij (to write frontend and backend, respectively)

# How to run 
- Start the backend code through UserSystemApiApplication
- Start the frontend component with npm start (this should be running on port 3000, else change the @CrossOrigin tags in backend to match port)

# Next steps
New features to integrate could be: 
- Enabling user login/authentication
- Implement proper testing using Jest
