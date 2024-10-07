most commonly used data types

int → inteager
varchar → character type
date → date

numeric -> calculations
character -> alphabets and numbers
date -> date


data is stored in binary digits in the computer
they are
0 or 1 (bit)
binary digit
8 bits → byte or character
kilo bytes → kb → 1024 bytes
mega → mb →1024 mb
giga bytes → gb → 1024 mb
tera btyes → tb → 1024 gb

salary decimal (8,3)
8 → Total length
3 → position after Decimal point
1 2 3 4 5 6 7 8
9 9 9 9 . 9 9 9

char is static
varchar is variable

set is used to specify the list of values to be inserted for a column (set of values)

create table dept
	(deptcode set(‘comp’,’bus’,’ELC’))

insert into dept
	values (‘comp‘)

table : student
column : DATEOFBRITH Date Type
to find which day of the month you have born
select dayofmonth(DATEBRITH) from student;

to find the age of the studnet using dateofbirth coulmn

select in (int(date()-datebrith)/365)
from student;
%% mister does repeat himself a fair bit, it might be a bad thing
but i see it as a good thing for the class i am with right now%%

entity → any object which can be described
example : book, person, computer, course
attribute is the description of the entity
eg : person entity has attributes
Name, Gender, Date of birth, address, phone

```
dwadwa
```
