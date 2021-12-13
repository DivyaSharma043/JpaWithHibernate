INSERT INTO PERSON (ID, Name, Location, Birth_Date)
VALUES(1001,'Divya', 'Ludhiana', sysdate());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )
VALUES(1002, 'James', 'New York',sysdate());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )
VALUES(1003, 'Pieter', 'Amsterdam',sysdate());

--COURSE
insert into course (ID, Name, Updated_Last_Date, Created_Date)
VALUES(1,'Java', sysdate(), sysdate());
insert into course (ID, Name, Updated_Last_Date, Created_Date)
VALUES(2,'Spring Boot', sysdate(), sysdate());
insert into course (ID, Name, Updated_Last_Date, Created_Date)
VALUES(3,'JPA', sysdate(), sysdate());
insert into course (ID, Name, Updated_Last_Date, Created_Date)
VALUES(4,'Keycloak', sysdate(), sysdate());
insert into course (ID, Name, Updated_Last_Date, Created_Date)
VALUES(5,'Google', sysdate(), sysdate());

--Passport
insert into passport(ID, Number)
VALUES(3001, 'SD2345DE');
insert into passport(ID, Number)
VALUES(3002, 'DSF2343DU');
insert into passport(ID, Number)
VALUES(3003, 'IER3556KI');
insert into passport(ID, Number)
VALUES(3004, 'SDG2468JI');
insert into passport(ID, Number)
VALUES(3005, 'LH2353458KK');

--STUDENT
insert into student(ID, NAME, PASSPORT_ID)
VALUES(2001, 'divya',3001);
insert into student(ID, NAME, PASSPORT_ID)
VALUES(2002, 'shabnam',3002);
insert into student(ID, NAME, PASSPORT_ID)
VALUES(2003, 'ashish',3003);
insert into student(ID, NAME, PASSPORT_ID)
VALUES(2004, 'shivam',3004);
insert into student(ID, NAME, PASSPORT_ID)
VALUES(2005, 'diksha',3005);

--Review
insert into review(ID, Rating, Description, Course_Id)
VALUES(4001, '5', 'Excellent',1);
insert into review(ID, Rating, Description, Course_Id)
VALUES(4002, '4', 'Very Good',2);
insert into review(ID, Rating, Description, Course_Id)
VALUES(4003, '3', 'Good',3);
insert into review(ID, Rating, Description, Course_Id)
VALUES(4004, '2', 'Average',4);
insert into review(ID, Rating, Description, Course_Id)
VALUES(4005, '1', 'Poor',5);

--STUDENT_COURSE
insert into student_course(student_id, course_id)
VALUES(2001, 1);
insert into student_course(student_id, course_id)
VALUES(2002, 1);
insert into student_course(student_id, course_id)
VALUES(2003, 1);
insert into student_course(student_id, course_id)
VALUES(2001, 3);

