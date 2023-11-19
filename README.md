# let-me-in

A [Daobab](http://www.daobab.io) Startup Project for your database.
</br>Uses a Spring-Boot framework.

# About

This project may help you create [Daobab](http://www.daobab.io) connection to your database and perform complete Reverse
Engineering for it.

The project contains just two classes:

- `Application` - a Spring Boot starter

- `Guide` - your guide to check the connection and perform the reverse engineering.

By default, the project contains client libraries to: MySQL, PosgreSql, H2

# How to run?
Take a look at the application.yml properties file.
Put the proper parameters to connect to your database.

Run the `Application` class

Check out the console. [Daobab](http://www.daobab.io) connector should validate the database connection.
If everything is fine, you can find something like this:

```
Connection OK. Database: MySQL version: 8.0 driver: MySQL Connector/J
User 'root' is allowed to read database content as follows: 
Catalog: cloud_job_manager (no schema)
Catalog: cross (no schema)
Catalog: information_schema (no schema)
Catalog: kwadrat (no schema)
Catalog: l2 (no schema)
Catalog: mdm (no schema)
Catalog: mysql (no schema)
Catalog: performance_schema (no schema)
Catalog: sakila (no schema)
Catalog: sys (no schema)
Catalog: testdb (no schema)
Catalog: world (no schema)
```


If the database connection is fine, you can perform the reverse engineering:

Go to `Guide` class and init method.

comment: `step1_checkConnection()`

uncomment: `step2_generateClasses()`;

Go to `step2_generateClasses()` method:

Decide where [Daobab](http://www.daobab.io) may write the classes:

```
        generator.setPath("C:\\Daobab\\");
```

Decide which catalogue or schema you want to handle:

```
        generator.generateOnlyForCatalogues("catalogue");
        generator.generateOnlyForSchemas("schema");
```

Otherwise, all catalogues and schemas will be recreated in classes.

Next, run the `Application` again.

Generated output classes should be put into the project you are working on.

# More about Daobab

http://www.daobab.io



