Table: Person

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| PersonId    | int     |
| FirstName   | varchar |
| LastName    | varchar |
+-------------+---------+
PersonId is the primary key column for this table.
Table: Address

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| AddressId   | int     |
| PersonId    | int     |
| City        | varchar |
| State       | varchar |
+-------------+---------+
AddressId is the primary key column for this table.

[Problem-175] Write a SQL query for a report that provides the following information for each person in the Person table, 
regardless if there is an address for each of those people:

FirstName, LastName, City, State

Approach : Using Left OUTER JOIN since there might not be an address information for every person.
SELECT FirstName, LastName, City, State
    FROM 
    Person p LEFT OUTER JOIN Address a 
    ON p.PersonId=a.PersonId;