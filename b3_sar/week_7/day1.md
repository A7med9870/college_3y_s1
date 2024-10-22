Normalization

unnormalized data


UNF
studentid
name
acadimic year
modulecode
modulename
credits
result
grade
total credits
date of birth
gender
programname

1nf
---
*studentid*
name
dateofbirth
gender
programname
--–
academic year
modulecode
modulename
credits
results
grade
totalcredits
**sutdentid**

2nf
---
studnet
--–
sudentid
name
dateofbrith
gender
**programcode**
--–
program
--–
programcode
programname
--–
module
--–
academic year
modulecode
modulename
credits
results
grade
totalcredits
studentid

3nf(third normal form)
---
student
--–
studentid
name
dateofbirth
gender
**programcode**
--–
program
--–
programcode
programname
--–
module
--–
modulecode
modulenname
credits
--–
result
--–
acadmic year
modulecode
result
grade
totalcredits
studentid

that was
Normalization

![[Pasted image 20241021130442.png]]
ER Diagram
![[Pasted image 20241021130804.png]]

UNF
Carno
brandname
rentrate
salemanno
salesmanname
salesmangsm
customerno
customername
customergsm
rentdate
renturndate
amount

1nf
---
car
----
carno
branname
rentrate
--–
rent
---
salesmanno
salesmanname
salesmangsm
customeno
customername
customergsm
rentdate
returndate
amount
carno
--–

2nf
---
car
---
carno
brandname
rentrate
--–
salesman
---
salesmanno
salesmanname
salesmangsm
--–
rent
---
customerno
customername
customergsm
rentrate
rentdate
returndate
amount
carno
salesmanno

3nf
---
car
---
carno
brandname
rentrate
--–
salesman
---
salesmanno
salesmanname
salesmangsm
--–
customer
---
customerno
customername
customergsm
--–
rent
---
rentdate
returndate
carno
salesmanno
customerno
--–
![[Pasted image 20241021134408.png]]

![[Pasted image 20241021134616.png]]