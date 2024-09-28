employee                        .
________                        .
    empno                       .
    name                        .
    address                     .
    phone                       .
    civivlid                    .
    deptno                      .

dept
________
    deptno
    dname
    location

salary
________
    empno
    month
    basic
    allowance
____________________________________________________________

keys
    -it must be unique (not repeated)
    -it can be one column or combination of columns which gives uniqueness
    super keys
    -it is key, may be of one column or more possible combination
    -example
            empno
            phone
            civilid
            empno,name
            empno,address
            empno,phone
            empno,civilid
            empno,name,phone

candidite keys
________
    The minimal keys fromsuperkeys
        example
        empno
        phone
        civilid

primary key
________
    The most useful column
    which is easy to use and remember
    eg: empno
    Primary key must be unique (not repeated) and it can not be null (without a value)
    there must be a value in the primary key field

Foreign key
________
    it is the primary key of another table used for referencing(linking the data)
        eg
            deptno in employee table is foreign key referencing to dept table


integrity rules
    entity integrity rule
        this refers to primary key
        primary key must be unique and it can not be NULL

    referntial intergrity rule
        this refers to foregin key
        the foreign key value must be
        the primary key of refernceing table
        it may be repeated and it can be NULL

________________________________________________________________________________________________________________________

superkey for dept table
________
    deptno
    dnamte
    location
    deptno, dname
    deptno, lcation
    deptno, name, location

superkey for salary
________
    #empno, month
            empno, basic
            empno, allowance

superkey for employee
    empno
    name
    phone
    empno, name
    empno, address
    name, phone
