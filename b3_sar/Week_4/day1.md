to get the list of borrowers with name Duncan in French department

CREATE TABLE borrowers (
    Name VARCHAR(50),
    Number VARCHAR(15),
    Dept VARCHAR(100)
);

select name from borrowers;
	where Name = 'Duncan'
	and dept = ‘French’;

to get the list of borrowers name who have taken books

to join two tables using foreign key and primary key
loans → person number FK
borrowers   → number PK
select borrowers.name from borrowers,loans
	where loans.personnumber=
		borrowers.number;
		(join condition)


to get the list of book’s name which have been taken as loan
![[Screenshot_20240930_125836.png]]
select books.name from books,loans
	where books.name = loans.booknumber;


to get the list of book's name and borrowers's Name those who have taken books

select books.name from books,borrowers
  where books.number = borrowers.number

select books.name,borrowers.name from books,borrowers,loans
	where books.number = loans.booknumber
	and loans.personnumber = Borrowers.number
explain
![[Screenshot_20240930_131727.png]]we place the comma “,” as a way to tell to fitter both
