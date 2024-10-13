practical 2

first table

	create table Employees2(
	    Name varchar(20),
	    Employee_Number int,
	    date_of_birth date,
	    salary DECIMAL(7, 3),
	    full_time DECIMAL(6)
	);
.



second one

	create table Projects2 (
		Project_Name varchar(20),
		Manager int,
		Description varchar(30),
		date_of_birth date,
		salary DECIMAL(7, 3),
		Full_Days_Worked DECIMAL(6)
	);

select part

	select * from employee2
		where name=’Sam Smith’;
update command

	update employee2
		set salary=50000
		where name='Sam Smith';
.

	select * from  employee2
		where fulltime=100;
.3

	select * from employee2 
		where dateofbirth > 1967-01-01;
.4

	select * from employee2
		where salary > 4000;
.5

	select * from projects2
		where employeenumber=234621;
.6

	select projectname from projects2
		where fulldaysworked > 150;
.7

	select employee number from projects2
		where fulldaysworked < 400;
or

	select distinct employee number from projects2
		where fulldaysworked < 400;
distinct is used for not reapting the value

.8

	select * from projects2 order by fulldaysworked desc;
desc for reverse

ascending → smallest to largest “a-z,0-9”
descending → largest to smallest “z-a,9-0”

.9

	select * from employee2
		where name like "%Smith";
.

	"smith%"
.10

	select * from employee2
		where name like "%john%"1