# Welcome to SWP_Project Reposiyory
OJT Website create with purposes help student in FPT University find the job in OJT (On Job Training) semester more simple by friendly interface and the notification throw email. With employee in FPT University this system will help reduce the complex work . This project also help company that have connected with FPT University choose the candidate faster by view their information right on the website.
## Software requirement
- VS Code: You can download VS Code [in here](https://docs.microsoft.com/vi-vn/visualstudio/ide/?view=vs-2019) 
- Database(Not required): 
  - MySql: Follow instruction to install [MySql.docs](https://dev.mysql.com/doc/mysql-installation-excerpt/5.7/en/)
## Install dependence 
**JDK 11**
- Follow instructions to install the latest version of JDK [oracle docs](https://docs.oracle.com/en/java/javase/11/install/overview-jdk-installation.html#GUID-8677A77F-231A-40F7-98B9-1FD0B48C346A)
## Create database for project
- By default we use H2Database for project if you want to use MySql or MSSql you need to create database name 'swp' in your machine by using fowlling script `create database swp`
- You need to change some code in file `application.properties` 
![application.properties Image](https://github.com/noname163/swp_project/blob/main/Screenshot%20(43).png)
  - If you use MySql you need uncommend code from line 16 to line 21
  - if you use MSSql you need uncommend code from line 1 to line 7
- In file `pom.xml` you will change code depend on database you use
![pom.xml](https://github.com/noname163/swp_project/commit/7ec7ac2613aa24a3e2d5218b54a45f4d4cd5ff8c)
  - If you use MySql you will uncomment code from line 40 to 44
  - If you use MSSql you will uncomment code from line 35 to 39
  - If you use H2Database you will uncoment code from line 29 to 33

 ### You will find in this repo the following stuff:
* Java source code for OJT website
#### © TEAM7 
