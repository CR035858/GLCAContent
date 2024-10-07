create database GlcaExam;
use glcaexam;
-- QUESTION 1
/* 1. Create respective tables with the below given table structure.*/
create table salesperson
(
S_ID int primary key,
Name varchar(50),
City varchar(50),
Earning int
);
-- C_ID	CUST_NAME	CITY	GRADES_ID

create table Customer
(
C_ID int primary key,
Cust_Name varchar(50),
City varchar(50),
Grades_Id int
);
-- ORD_NO	PURCHASE_AMT	ORD_DATE 	C_ID	S_ID
create table Orders
(
ORD_NO int primary key,
Purchase_Amt int,
Ord_Date date,
C_ID int,
S_ID int,
foreign key(C_ID) references Customer(C_ID),
foreign key(S_ID) references SalesPerson(S_ID)
);
create table tab11
(
tid int primary key,
tvar varchar(20)
);
/*
create table tab22
(
t1id int primary key,
tvar2 varchar(20),
tid int representation tid in tab11 integer foreign key
);
/*
1	Amit	Delhi	25000
2	Ankit	Pune	15000
3	Chandra	Ahmedabad	100000
4	Monica	Delhi	35000
5	Rohini	Bhopal	25000

10	Manish	Ahmedabad	1001
11	Nishanth	Chennai	3001
12	Guru	Delhi	4002
13	Sonia	Delhi	2002
14	Sakshi	Lucknow	4003

ORD_NO	PURCHASE_AMT	ORD_DATE 	C_ID	S_ID
1	5000	04-MAY-17 	10	1
2	450	20-JAN-17	10	2
3	1000	24-FEB-17	13	2
4	3500	13-APR-17	14	3
5	550	09-MAR-17	12	2


*/
insert into SalesPerson
values 
(1,'Amit','Delhi',25000),
(2,'Ankit','Pune',15000),
(3,'Chandra','Ahmedabad',100000),
(4,'Monica','Delhi',35000),
(5,'Rohini','Bhopal',25000);
delete from Customer;
insert into Customer
values 
(10,'Amit','Delhi',25000),
(11,'Ankit','Pune',15000),
(12,'Chandra','Ahmedabad',100000),
(13,'Monica','Delhi',35000),
(14,'Rohini','Bhopal',25000);


select * from salesperson;
select * from customer;
select * from Orders;

insert into Orders values
-- (1,5000,'2017-05-04',10,1)
(2,450,'2017-01-20',10,2),
(3,1000,'2017-02-24',13,2),
(4,3500,'2017-04-13',14,3),
(5,550,'2017-03-09',12,2);

insert into Orders values
(6,5000,'2018-05-04',12,1);

/* 2. Display all the data in all the three tables.*/
select * from customer c join Orders o
on c.C_ID = o.C_Id
join SalesPerson s 
on o.S_ID = s.S_ID;
/*
3. Count the customers with grades above Delhi’s average.
*/

select city , avg(grades_id) as 'City Wise Average Grade' from customer
group by city;

select count(c_id) from customer where Grades_Id > (
select  avg(grades_id) as 'City Wise Average Grade' from customer
group by city having city='Delhi');

/*
4. Find the name and numbers of all salesmen who had more than one customer. 
select
*/

select s_id,count(c_id) from Orders 
group by s_id having count(c_id) > 1;

select s_id,name from salesperson where s_id in 
(select s_id from Orders 
group by s_id having count(c_id) > 1);

/*
5. List all salesmen and indicate those who have and don’t have customers in their cities (Use UNION operation.) 

*/
select name from salesperson
union
select name from salesperson where s_id in(
select s_id from orders);
/* q5 working*/
select name ,city from salesperson
where s_id in (select s_id from orders where c_id in (
select c_id from orders where c_id in (select c_id from customer where city in(select city from salesperson))
));
--  CHECK n MODIFY THIS or Q5 if possible--------------------Students query
select s_id from salesperson
where s_id not in (select distinct s_id from orders)
union
select c_id from customer 
where c_id not in (select distinct s_id from salesperson);

--- Check on this too

-- Version 1
select s.name,s.city , 'has customer' as status from salesperson s
join orders o on s.S_ID = o.S_ID join customer c on o.C_ID = c.C_ID
union
select s.name, s.city ,'no customer' as status from salesperson s 
where exists (select 1 from orders o where o.S_ID = s.S_ID);

-- Above being modified VERSION 2  THE CORRECT ONE FOR SOLUTION
select distinct s.name,s.city , 'has customer from salespersons city' as status from salesperson s
join orders o on s.S_ID = o.S_ID join customer c on o.C_ID = c.C_ID
and s.City = c.City
union
select distinct s.name, s.city , 'no customer from salespersons city' as status from salesperson s 
where exists (select 1 from orders o where o.S_ID = s.S_ID);

-- Above being modified VERSION 3 NOT THE CORRECT ONE
select s.name,s.city , 'has customer' as status from salesperson s
join orders o on s.S_ID = o.S_ID join customer c on o.C_ID = c.C_ID
and c.City = s.City
union 
select s.name,s.city , 'No customer' as status from salesperson s
join orders o on s.S_ID = o.S_ID join customer c on o.C_ID = c.C_ID
and c.City = s.City;


-- WORKING Q 5 solution by learner
select s.s_id,s.name,s.city ,'customers ' as status from salesperson s
where exists(
select 1 from Orders o join customer c on o.C_ID = c.C_ID where s.S_ID = o.S_ID and s.City = c.City)
UNION
select s.s_id,s.name,s.city ,'no customers ' as status from salesperson s
where exists(
select 1 from Orders o join customer c on o.C_ID = c.C_ID where s.S_ID = o.S_ID and s.City = c.City);
-- xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxstudents queriesxxxxxxxxxxxxxxxxxxxxxxxxx

select count(*) from customer where grades_id > (select avg(grades_id) from customer where city='Delhi');
/* NOT CORRECT */
select count(*) as aboveavg from customer where City = 'Delhi' and Grades_Id > (select avg(grades_id) from customer where
city = 'Delhi');

select count(*) from customer where Grades_Id > 
(
select avg(Grades_Id) from customer where city = (select city from customer where city='Delhi')
);
select o.ord_no,o.purchase_amt,o.ord_date, c.Cust_Name ,s.name from orders o join customer c on o.c_id  = c.c_id
join salesperson s on o.S_ID = s.S_ID;
/* working*/
select count(*) from customer where grades_id > (select avg(grades_id) from customer where city = 'Delhi');
/* Q 4 * working */
select s.name,count(c.c_id) from salesperson s
join orders o on s.S_ID = o.S_ID join customer c on o.C_ID = c.C_ID 
group by s.S_ID having count(c.C_ID) > 1;

select s.name,count(c_id) from salesperson s
join orders o on s.S_ID = o.S_ID;

select s.name,s.city , 'has customer' as status from salesperson s
join orders o on s.S_ID = o.S_ID join customer c on o.C_ID = c.C_ID
union
select s.name, s.city ,'no customer' as status from salesperson s 
where exists (select 1 from orders o where o.S_ID = s.S_ID);

select s.s_id,s.name from salesperson s where s.s_id in (select distinct c.s_id from orders c);
/* working*/
select count(*) from customer where Grades_Id > (select avg(Grades_Id) from customer where city = 'Delhi');

/* Not working*/
select count(*) from customer where Grades_Id > (select avg(length(Grades_Id)) from customer where city = 'Delhi');

/*4 learners query working */
select s.s_id,s.name,count(c.c_id) as 'Cust Count'
from salesperson s 
join orders o on s.S_ID = o.S_ID
join customer c on o.C_ID = c.C_ID
group by s.S_ID,s.Name having count(c.C_ID) > 1;

/*4 learners query working */
select s.s_id,s.name,count(*) as 'Cust Count'
from salesperson s 
join orders o on s.S_ID = o.S_ID
group by name having count(*) > 1;

/* Q 5  Learners Query Q 5 not matching criteria */
select s.S_ID,s.Name,c.cust_name, Earning from salesperson s join customer c where s.city = c.City
union
select s.S_ID,s.Name,'No Match', Earning from salesperson  s
where not city = any(select city from customer) ;

/*5 Learners query working */

select s.s_id,s.name,s.city ,'has customers ' as status from salesperson s
where exists(
select 1 from Orders o join customer c on o.C_ID = c.C_ID where s.S_ID = o.S_ID and s.City = c.City)
UNION
select s.s_id,s.name,s.city ,'no customers ' as status from salesperson s
where exists(
select 1 from Orders o join customer c on o.C_ID = c.C_ID where s.S_ID = o.S_ID and s.City = c.City);

/* 5 Learners query not matching requirement*/
select s.Name,s.city ,'Has Customers' as status
from salesperson s
join orders o on s.S_ID = o.S_ID
UNION
select s.Name,s.city ,'No Customers' as status
from salesperson s where s.S_ID not in(select distinct S_ID from orders);

/* 5 Learners query not matching requirement*/
select s.Name,s.city ,'Has Customers' as status
from salesperson s
join orders o on s.S_ID = o.S_ID 
UNION
select distinct s.Name,s.city ,'No Customers' as status
from salesperson s where s.S_ID not in(select distinct S_ID from orders);

/* 5 Learners query not matching requirement*/
select s.Name,s.city ,'Has Customers' as status
from salesperson s where s.S_ID not in(select distinct S_ID from orders)
UNION
select s.Name,s.city ,'No Customers' as status
from salesperson s where s.S_ID not in(select distinct S_ID from orders);

/* Q 4 learner query */
select s.name from salesperson s where 1 < (select count(*) from customer where S_ID = s.S_ID);

/* Q 5 Learners query  Does not meet criteria*/
select s.name,s.city , 'has customer' as status from salesperson s
join orders o on s.S_ID = o.S_ID 
union
select s.name, s.city ,'no customer' as status from salesperson s 
where not exists (select 1 from orders o where o.S_ID = s.S_ID);

/* q5 learners query not working */
select distinct s.name,s.city ,'no customer' from salesperson s where s.S_ID not in (select distinct S_ID from orders);
