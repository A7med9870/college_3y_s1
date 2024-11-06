# At Home

| Consultant | project | Hours | Project | Consultant | project | Fee |
| ---------- | ------- | ----- | ------- | ---------- | ------- | --- |
|            |         |       |         |            |         |     |

----

| Consultant | project | Hours |
| ---------- | ------- | ----- |
|            |         |       |

| Hours | Project | Consultant | project | Fee |
| ----- | ------- | ---------- | ------- | --- |
|       |         |            |         |     |

---


| Consultant | project | Hours |
| ---------- | ------- | ----- |
|            |         |       |

| Hours | Project | Consultant |
| ----- | ------- | ---------- |
|       |         |            |


| project | Fee |
| ------- | --- |
|         |     |

---
---

# In Class
start

| Name | Employee | Date of Birth | Salary | Project name | Description | Full days worked | worked | manager |
| ---- | -------- | ------------- | ------ | ------------ | ----------- | ---------------- | ------ | ------- |
|      |          |               |        |              |             |                  |        |         |

---
1nf


| Name | Employee number | Date of Birth | Salary |
| ---- | --------------- | ------------- | ------ |
|      | p               |               |        |

| Project name | Description | Full days worked | worked | manager | Employee number |
| ------------ | ----------- | ---------------- | ------ | ------- | --------------- |
|              |             |                  |        |         | F               |

---

2nf

| Name | Employee number | Date of Birth | Salary |
| ---- | --------------- | ------------- | ------ |
|      | P               |               |        |

| Project name | Description | Full days worked |
| ------------ | ----------- | ---------------- |
| P            |             |                  |


| Employee | Salary | manager | ProjectName |
| -------- | ------ | ------- | ----------- |
| F        |        |         |             |

---

3nf

Employee

| Employee Number | Name | Date of birth | Salary |
| --------------- | ---- | ------------- | ------ |
| P               |      |               |        |
Project

| Project name | Description | Manager |
| ------------ | ----------- | ------- |
| P            |             | F       |
Emp prot

| Employee Number | Project Name | Full days Worked |
| --------------- | ------------ | ---------------- |
| F               | F            |                  |

---
![[Pasted image 20241030124743.png]]


Database Scehma
Employee (**EmployeeNumber**,Name,DateOfBirth,Salary)
Project (**ProjectName**,Description,*Manager*)
Emproject (*EmployeeNumber*,*ProjectName*,FullDaysWorked)

---
```
CREATE TABLE loaddata
(
    Name VARCHAR(30),
    EmployeedNumber INT,
    dateofbirth DATE,
    salary DECIMAL(10,3),
    projectname VARCHAR(30),
    description VARCHAR(100),
    fulldaysworked INT,
    manager INT
);

```
Then format the cells, didn’t work in excel alt

with the look from the following pic
![[screenshot-20241030-130710 1.png]]
then import it into the table
![[Pasted image 20241030132530.png]]

```
CREATE TABLE Employee
(
    EmployeeNumber INT PRIMARY KEY,
    Name VARCHAR(30),
    DateOfBirth DATE,
    Salary DECIMAL(10,3)
);


CREATE TABLE Project
(
    ProjectName VARCHAR(30) PRIMARY KEY,
    Description VARCHAR(100),
    Manager INT
);


CREATE TABLE Emproject
(
    EmployeeNumber INT,
    ProjectName VARCHAR(30),
    FullDaysWorked INT,
    PRIMARY KEY (EmployeeNumber, ProjectName),
    FOREIGN KEY (EmployeeNumber) REFERENCES Employee(EmployeeNumber),
    FOREIGN KEY (ProjectName) REFERENCES Project(ProjectName)
);

```

.
```
INSERT INTO Employee (Name, EmployeeNumber, DateOfBirth, Salary)
    SELECT DISTINCT Name, EmployeedNumber, DateOfBirth, Salary
    FROM loaddata;


INSERT INTO Project (ProjectName, Description, Manager)
SELECT projectname, description, manager
FROM loaddata;

INSERT INTO Emproject (EmployeeNumber, ProjectName, FullDaysWorked)
SELECT EmployeedNumber, projectname, fulldaysworked
FROM loaddata;

```