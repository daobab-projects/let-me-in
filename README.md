# let-me-in
A Daobab Startup Project for your database

# About
This project may help you create Daobab connection to your database and perform complete Reverse Engineering for it.

The project contains just two classes:
-Application - a Spring Boot starter
-Guide - your guide to check the connection and perform the reverse engineering.

By default, the project contains client libraries to: MySQL, PosgreSql, H2

# How to run?
Take a look at the application.yml properties file.
Put the proper parameters to connect to your database.

Run the Application class

Check out the console. Daobab connector should validate the database connection.
If everyrthing is fine, you can find something like this:

<code>
<br>Connection OK. Database: MySQL version: 8.0 driver: MySQL Connector/J
<br>User 'root' is allowed to read database content as follows: 
<br>Catalog: cloud_job_manager (no schema)
<br>Catalog: cross (no schema)
<br>Catalog: information_schema (no schema)
<br>Catalog: kwadrat (no schema)
<br>Catalog: l2 (no schema)
<br>Catalog: mdm (no schema)
<br>Catalog: mysql (no schema)
<br>Catalog: performance_schema (no schema)
<br>Catalog: sakila (no schema)
<br>Catalog: sys (no schema)
<br>Catalog: testdb (no schema)
<br>Catalog: world (no schema)
</code>


If the database connection is fine, you can perform the reverse engineering:

Go to Guide class and init method.
comment: step1_checkConnection()
uncomment: step2_generateClasses();

Go to step2_generateClasses() method:

Decide where Daobab may write the classes:
<code>generator.setPath("C:\\Daobab\\");</code>

Decide which catalogie or schema you want to handle:
<code>
        generator.generateOnlyForCatalogues("catalogue");
        generator.generateOnlyForSchemas("schema");
</code>

Otherwise, all catalogues and schemas will be recreated in classes.

Next, run the application again.

Generated output classes should be put into the project you are working on.



