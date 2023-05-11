# Application to access location data 

This application contains logic to extract a location for a given zipcode 
from the [4pp data](https://github.com/bobdenotter/4pp).

The application performs two tasks: 
1. Establishing a connection to a MySQL database
2. Extracting a location for a given zipcode

To use the application, follow the steps described below.

## Setting up the MySQL Database
The application is configured to work with a MySQL Database Server using a JDBC Driver. 
A connection with a MySQL Database needs to be set up. To fill the database, an SQL-script named `4pp.sql` 
is added to the resources folder.

Use the following steps to set up the connection:
1. Create a new MySQL database named `4pp` in a database environment to your liking.
2. Import the `4pp.sql` script from the resources folder into the database.
3. Create a new user with the name `rws` and grant this role all privileges, 
then set the password to `RWSassignment`.

### Steps for performance enhancement
Indexing is recommended to ensure fast results when querying the database.

To create an index, follow these steps:
1. Create a new index on the `postcode` column of the existing table. 

   To do this with a query, use:

        CREATE UNIQUE INDEX index_name
        USING BTREE
        ON 4pp (postcode);
2. Remember to update the index after new data has been written into the database.

## Running the application from the CLI
You need JDK 15 installed on your environment to run the application from the Command Line Interface. 
To check which version you have installed, run the command:

`java -version`

```
java version "15.0.2" 2021-01-19
Java(TM) SE Runtime Environment (build 15.0.2+7-27)
Java HotSpot(TM) 64-Bit Server VM (build 15.0.2+7-27, mixed mode, sharing)
```
In your terminal navigate to where the JAR-file is located: `out/artifacts/rws_jar/rws.jar`
Finally, run the following command with one or more arguments to extract location data:

```
java -cp rws.jar main.Main <zipcode> <zipcode> <zipcode>
```

## Using this application as a library in your own application
1. Import the JAR-file into your own Java-application – which is found at `out/artifacts/rws_jar/rws.jar`
2. Ensure the application is able to connect to the database
(as described above in _Setting up the database_)
3. Invoke the `FindLocation.findLocation(int zipcode)` method
to access the location data.
