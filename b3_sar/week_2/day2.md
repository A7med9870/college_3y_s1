create table student
    (studno int,
    name varchar(20) not null,
    date_of_birth date,
    gender char(1) not null,
    phone char(8),
    prgid char(5),
    primary key(studno),
    foreign key(prgid) refernces program(prgid))

create table program
    (prgid har(5) primary key
    prgname varchar(20) not null,
    fees decimal(10,2));

constraints
    are used to ensure the data integrity and accuracy
    eg
    primary key, foreign key,
    not null, default value


course
______
courseid
cname
credits


    create table coruse
        courseid VARCHAR(6),
        cname VARCHAR(20) NOT NULL,
        credits INT(6),
        PRIMARY KEY(courseid);


Create a table to store courses for each program

create table programcourses
    (prgid char(5),
    courseid char(7),
    yearno int,
    semesterno int,
    primary key(prgid,courseid),
    foreign key(prgid) refernces program(prgid),
    foreign key(courseid) refernces course(courseid));


to delete all records from a table
delete from tabelname;

to add adress column in student table
alter table studnet
add address varchar(20);

to delete a table
drop table tablename;
