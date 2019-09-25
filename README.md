Resttest
========

This is a small backend test for a potential future project of mine. this involves spring and hibernate to connect the database to a restapi.


Todo
----
* Better RestAPI design
* Better Configuration from Mysql data (if needed)
* Authentication token and stuff for administration and manging own resources
* Setup Test Server

Access
-----
if you want to test it, just clone it and configure the `application.properties` to your mysql database stuff. run it and then call `localhost:8080/user/get?id={id}` or create a user with `localhost:8080/user/add?name={name}`