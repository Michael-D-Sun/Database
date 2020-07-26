# Database

This is an utility for Jdbc. It uses the c3p0 library to manage the connection pool. All the related interfaces have been encapsuled. You can esily get access to the database and operate the database, for example, add, delete, update operation. Especailly, pay attention to the JDBCUtils.java file. It is the core funciton. Also, this utility support transaction operation.

The account table structure which is operated in this example is like below.
|id|name|balance|
|--|--|--| 
