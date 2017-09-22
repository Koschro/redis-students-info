# redis-students-info
In this project a relational schema and its records were mapped to REDIS. 

In detail we were asked to first convert the relational schema into txt format. For every table we created a separate txt. Our assignment schema is two tables-txts with table names Student and Grade. 

#Download and Installation

We download the REDIS software from https://github.com/MSOpenTech/redis/releases and then we placed the jedis.jar 2.5.1 (provided by the instructor) into the java folder 

# Mapping to REDIS

In the folder ImportRedis we have the 4 java files used for the import of the schema and its records to REDIS. Specifically, the Reader.Java and Feeder.java are the ones that are used by the Exetutioner.java (our main) to implement the import based on the HMSET command of REDIS which uses the hash-set structure. The UserInput.java file lets the user state the path that the txt-table exist or simply just the name of the document file to input.
We imported the Student.txt and Grade.txt to REDIS. 

After that, we checked the REDIS db using the command hgetall.

# Query Mapping and Processing

In the folder QueryProcess we have the java file used for the import of the Query.txt and its process in the REDIS db.
