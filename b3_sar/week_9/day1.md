1)
CREATE TABLE Employee (
    Emp_ID VARCHAR PRIMARY KEY,
    Emp_Name VARCHAR(255),
    DoB DATE,
    Department VARCHAR(255),
    Designation VARCHAR(255),
    DoJ DATE,
    Salary DECIMAL(8, 2)
);

INSERT INTO Employee (Emp_ID, Emp_Name, DoB, Department, Designation, DoJ, Salary) 
VALUES (F110, 'Abdullah', '1970-06-15', 'Biotechnology', 'Professor', '2001-04-12', 4500.00);

INSERT INTO Employee (Emp_ID, Emp_Name, DoB, Department, Designation, DoJ, Salary) 
VALUES (F110, 'Mohmmed', '1985-05-25', 'Mechanical', 'Asst.Professor', '2006-05-02', 3000.00);

INSERT INTO Employee (Emp_ID, Emp_Name, DoB, Department, Designation, DoJ, Salary) 
VALUES (F110, 'Raguvaran', '1982-08-10', 'CSE', 'Asst.Professor', '2007-05-05', 2700.00);


INSERT INTO Employee (Emp_ID, Emp_Name, DoB, Department, Designation, DoJ, Salary) 
VALUES (F110, 'Jennifer', '1975-09-10', 'CSE', 'Asst.Professor', '2007-07-03', 3500.00);


INSERT INTO Employee (Emp_ID, Emp_Name, DoB, Department, Designation, DoJ, Salary) 
VALUES (F110, 'Ismail', '1979-05-15', 'IT', 'Asst.Professor', '2007-05-10', 3300.00);



2)
SELECT * FROM Employee;

3)
SELECT * FROM Employee 
WHERE Department = 'CSE';

4)
SELECT * FROM Employee 
WHERE Salary > 3000;

5)
SELECT *  FROM Employee 
WHERE Designation =/= 'Professor';

6)
SELECT Emp_Name, DoB, Designation  FROM Employee 
WHERE Department = 'IT';

7)
SELECT Department FROM Employee
WHERE Salary > 2500;

8)
SELECT * FROM Employee
where Emp_Name = 'Mohammed';

9)
