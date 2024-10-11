	create table _
	alter table _
	drop table _
	
	insert into _
.

	insert into _ value
	    (dw,"aa","aa","ii.7");
.

	interst into _ (sno, sname) VALUES
	    (456, "wasd");
.

	inset into _
	    select distinct sno, bno, date_out
	    from _

write insert command

	student
		studno int
		name vrchar(20)
		dob date
		phone cgar(8)
________________________________________________________________________
	insert into student values
		(21100,"hamdan bash", "2003-11-4", "93612251");
________________________________________________________________________
	insert into student (studno,name) VALUES
		(21100,"hamdan bash");
________________________________________________________________________
* --> all columns | no star --> no all colums
select command
select * from books;

to get all borrowers

    select name from borrowers;
________________________________________________________________________
to get only name from borrowers

    select name from borrowers;
________________________________________________________________________
to get name nad number from borrowers

    select name,number from borrowers;
________________________________________________________________________
to get the detais of the borrowers anne

    select * from borrowers
        where Name = 'anne';
________________________________________________________________________
to get the detials of borrowers from Maths department

    select dept from borrowers
        where dept = 'Maths';
________________________________________________________________________
to get the details of borrowers from maths department with the name Bill

    select dept from borrowers
        where dept = 'Maths';
        and Name = 'Bill';
________________________________________________________________________
to get the name of the book with number 3

    select Name from Books
        where Number = '3';
.

	  select 'colum' from 'table name'
		  where 'row' = 'data';
                          ____________________________________

________________________________________________________________________
to get the name of the book with number 3

    select Name from Books
        where Name = 'Book3';
________________________________________________________________________
to get the detials of the borrowers working in Maths or French department

	select * from Borrowers
	    where   dept = 'maths' or;
	            dept = 'french';
____________________________

	select * from Borrowers
	    where dept in ('maths','french');

____________________________ reversed

	select * from Borrowers
	    where dept notin ('maths','french');
