/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*JDBC:
JDBC (Java Database Connectivity) API(collection of classes and interfaces) which allows Java applications to connect to databases,
execute SQL queries, and retrieve results.

JDBC Drivers
JDBC drivers are essentially middleware that facilitate the interaction between the Java application and the database. 
The driver translates Java JDBC calls into database-specific calls and protocols, allowing the application to execute
SQL queries and retrieve results from the database.

JDBC Driver Types: 
Type 1 (JDBC-ODBC Bridge):Uses ODBC (Open Database Connectivity) drivers to connect to the database.
Requires the ODBC driver to be installed on the client machine. 
Type 2 (Native-API)-Uses client-side libraries provided by the database vendor.
Type 3 (Network Protocol)-Translates JDBC calls into a database-independent network protocol, which is then translated to database-specific calls by a server.
Allows the client to connect to many different databases via a middle-tier server.
Type 4 (Thin Driver)-Directly converts JDBC calls into the database-specific protocol.
Pure Java driver that communicates directly with the database so they typically offer better performance 
compared to other driver types that introduce additional layers (like Type 1 or Type 3 drivers).
Does not require any native libraries or middle-tier server .
Type 4 drivers are written entirely in Java, which makes them platform-independent. 
You can run your application on any system that has a JVM without worrying about native library dependencies.

Example: MySQL Connector/J (com.mysql.cj.jdbc.Driver), PostgreSQL (org.postgresql.Driver).

A JAR (Java ARchive) file (is a package file format) used to aggregate many Java class files, along with associated 
metadata and resources (such as text, images, etc.), into a single file making it easier for distribution and 
deployment of applications.
Library JARs:

JAR files are commonly used to distribute Java libraries and frameworks. These libraries can be 
included in the classpath of Java projects to provide additional functionality.

ODBC: ODBC is a C language API and is platform-independent. It allows C and C++ applications to connect to various DBMSs. Although it can be used with other languages through language-specific bindings, it is primarily associated with the Windows platform and often requires platform-specific drivers.
JDBC: JDBC is a Java API specifically designed for Java applications. It is platform-independent as long as 
the Java environment is available. 
API Design:
ODBC: ODBC is designed for procedural programming. It provides functions for connecting to databases, executing queries, and retrieving results.
JDBC: JDBC is designed for object-oriented programming. It provides classes and interfaces for managing database 
connections, executing SQL statements, and processing results.

ODBC: ODBC uses drivers that conform to the ODBC standard. These drivers are typically provided by the DBMS vendors or third parties and must be installed on the client machine.
JDBC: JDBC defines four types of drivers:

ODBC: ODBC is widely used in applications where multiple languages and platforms need to access databases, 
especially in environments dominated by Windows.
JDBC: JDBC is used primarily in Java applications, including web applications, enterprise applications, and Android apps.
It is the standard way for Java applications to interact with databases.
Driver Installation:

ODBC: ODBC drivers often need to be installed separately on the client machine. 
JDBC: JDBC drivers are usually distributed as JAR files that can be included in the application's classpath,
making deployment easier.
*/
package hotel_management_system;
/*4 steps:
Steps:
Load the MySQL JDBC driver.
Establish a connection to the database using DriverManager.getConnection.
Create a Statement object using the Connection object.
Handle any exceptions that occur during these steps with a try-catch block.
*/
import java.util.HashMap;
import java.util.Map;
import java.sql.*;  
//defines a class conn that establishes a connection to a MySQL database.
public class conn{
    Connection c; //Creating the connection object to represent connection to the database; Connection class is in java.sql package
    Statement s;//A Statement object used to execute SQL queries against the database.
    private final Map<String, PreparedStatement> preparedStatementCache = new HashMap<>();

    public conn(){  
    //mysql is a third party entity and might throw exceptions 
        try{  
            /*Loads the MySQL JDBC driver class in memory. This line registers the driver with the DriverManager. 
            It's needed to allow the DriverManager to understand how to connect to the MySQL database.
            Note: As of JDBC 4.0 (Java 6), this step is no longer needed if the driver is available on the classpath, 
            because JDBC drivers are automatically loaded.*/
            Class.forName("com.mysql.jdbc.Driver");//this is a fully qaulified classname of the MySQL JDBC driver, which is part of the MySQL Connector/J library.
            //this is type-4 driver(fully java driven)
            
            /*Uses the DriverManager class to establish a connection to the database using the driver loaded.
            The getConnection() method takes the database URL, username, and password as parameters:
            URL: jdbc:mysql://localhost:3306/hms
            jdbc:mysql://: Protocol for MySQL JDBC.
            localhost: Host where the database server is running (in this case, the local machine).
            3306: The default port for MySQL.
            hms: The name of the database.
            Username: "root"
            Password: "Sunita@1"*/
            c =DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","Sunita@1"); //Creating coonection with the connection string for MySQL using
            // DriverManager class which takes the connection string as the url
            
            s=c.createStatement();  //Creates a Statement object using the Connection object c. 
            //This Statement object s will be used to execute SQL queries against the database.
           
        }catch(Exception e){ 
            System.out.println(e);
        }
    }
        public PreparedStatement getPreparedStatement(String query) throws SQLException {
        if (!preparedStatementCache.containsKey(query)) {
            // If the PreparedStatement is not already cached, create and cache it
            PreparedStatement preparedStatement = c.prepareStatement(query);
            preparedStatementCache.put(query, preparedStatement);
        }
        // Return the cached PreparedStatement
        return preparedStatementCache.get(query);
 
    }  
}  


