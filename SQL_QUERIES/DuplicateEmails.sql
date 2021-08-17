// [182] Write a SQL query to find all duplicate emails in a table named Person.

// +----+---------+
// | Id | Email   |
// +----+---------+
// | 1  | a@b.com |
// | 2  | c@d.com |
// | 3  | a@b.com |
// +----+---------+
// For example, your query should return the following for the above table:

// +---------+
// | Email   |
// +---------+
// | a@b.com |
// +---------+

//Approach-1: 
SELECT Email FROM
    (SELECT count(Email) as num, Email FROM 
        Person 
        GROUP BY Email) as p
WHERE p.num > 1;

//Approach-2: Using GROUP BY and HAVING clauses
//PROS: Simple & EFFICIENT

SELECT Email
    FROM Person
    GROUP BY Email
    HAVING count(Email) > 1;