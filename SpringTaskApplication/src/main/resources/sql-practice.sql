CREATE TABLE department (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(50)
);

CREATE TABLE employee (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(50),
    salary INT,
    dept_id INT,
    FOREIGN KEY (dept_id) REFERENCES department(dept_id)
);

INSERT INTO department VALUES
(1, 'IT'), (2, 'HR'), (3, 'Finance');

INSERT INTO employee VALUES
(101, 'Amit', 50000, 1),
(102, 'Neha', 60000, 1),
(103, 'Rahul', 40000, 2),
(104, 'Priya', 70000, 2),
(105, 'Ravi', 80000, 3);

SELECT d.dept_name, COUNT(e.emp_id) AS total_employees,
       AVG(e.salary) AS avg_salary
FROM department d
INNER JOIN employee e
ON d.dept_id = e.dept_id
GROUP BY d.dept_name
HAVING AVG(e.salary) > 45000;

SELECT d.dept_name, e.emp_name
FROM department d
LEFT JOIN employee e
ON d.dept_id = e.dept_id;