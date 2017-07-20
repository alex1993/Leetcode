DROP TABLE Employee;
DROP TABLE Department;

CREATE TABLE IF NOT EXISTS Employee (
  Id           INT,
  Name         VARCHAR(255),
  Salary       INT,
  DepartmentId INT
);
CREATE TABLE IF NOT EXISTS Department (
  Id   INT,
  Name VARCHAR(255)
);
TRUNCATE TABLE Employee;
INSERT INTO Employee (Id, Name, Salary, DepartmentId) VALUES ('1', 'Joe', '70000', '1');
INSERT INTO Employee (Id, Name, Salary, DepartmentId) VALUES ('2', 'Henry', '80000', '2');
INSERT INTO Employee (Id, Name, Salary, DepartmentId) VALUES ('3', 'Sam', '60000', '2');
INSERT INTO Employee (Id, Name, Salary, DepartmentId) VALUES ('4', 'Max', '90000', '1');
TRUNCATE TABLE Department;
INSERT INTO Department (Id, Name) VALUES ('1', 'IT');
INSERT INTO Department (Id, Name) VALUES ('2', 'Sales');

# Write your MySQL query statement below
SELECT
  T1.Salary,
  T1.Employee,
  T1.Department
FROM
  (SELECT
     Employee.Name   AS 'Employee',
     Employee.Salary AS 'Salary',
     Department.Name AS 'Department',
     Department.Id   AS 'DepartmentId'
   FROM Employee, Department
   WHERE Employee.DepartmentId = Department.Id) AS T1
WHERE
  (SELECT COUNT(DISTINCT Salary)
   FROM Employee AS T2
   WHERE T1.DepartmentId = T2.DepartmentId AND T1.Salary < T2.Salary) < 3;


SELECT
  D.Name AS 'Department',
  E.Name   AS 'Employee',
  E.Salary AS 'Salary'
FROM Department AS D, Employee AS E
WHERE D.Id = E.DepartmentId
      AND (SELECT COUNT(DISTINCT T2.Salary)
           FROM Employee AS T2
           WHERE E.DepartmentId = T2.DepartmentId
            AND E.Salary < T2.Salary
          ) < 3;
