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


SELECT
  curDepartment AS Department,
  Employee.Name AS Employee,
  maxSalary     AS Salary
FROM
  (SELECT
     Department.Name AS curDepartment,
     MAX(Salary)     AS maxSalary,
     DepartmentId
   FROM Department, Employee
   WHERE Department.Id = Employee.DepartmentId
   GROUP BY Department.Id) AS T, Employee
WHERE T.maxSalary = Employee.Salary AND T.DepartmentId = Employee.DepartmentId
ORDER BY maxSalary;

DROP TABLE Person;
Create table Person (Id int, Email varchar(255));
Truncate table Person;
insert into Person (Id, Email) values ('1', 'a@b.com');
insert into Person (Id, Email) values ('2', 'c@d.com');
insert into Person (Id, Email) values ('3', 'a@b.com');