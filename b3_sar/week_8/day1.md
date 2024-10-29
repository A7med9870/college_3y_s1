Department(**DeptCode**,name)
Employee (**EmpNo**, Firstname,LastName,Salary,*Deptcode*,*Projcode*)
Dependent (**DNO**,Name,Relationsjip,*Empno*)
Project(**Prjocode**,Name,*Empno*)
Partusage(Quantity, *projcode*, *partcode*)
Part (**PartCode**,Description)
Partsource (unitcost, *partcode*,*suppcode*)
Supplier (**suppcode**,Name, Address)

# tut 2

Q1
1unf, 2nf, 3n
a financial consultancy provides consultants to work on clients projects (this problem comes from Ritchie, 3rd Edition, page 130).
each consultant works on only one project at a time, but a project may employ more than one consultant. The following (un-normalized) table gives sample data about current assigments.
Note that the hours value is the total hours worked on the project so far, per consultant; the Fee Rate value depends on the combination of the consultant involved and the project.
