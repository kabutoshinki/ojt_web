# Welcome to SWP_Project Reposiyory
OJT Website create with purposes help student in FPT University find the job in OJT (On Job Training) semester more simple by friendly interface and the notification throw email. With employee in FPT University this system will help reduce the complex work . This project also help company that have connected with FPT University choose the candidate faster by view their information right on the website.
## Use can visit ours website at the link below
- https://ojt-website.herokuapp.com/
## Software requirement
- VS Code: You can download VS Code [in here](https://docs.microsoft.com/vi-vn/visualstudio/ide/?view=vs-2019) 
- Database(Not required): 
  - MySql: Follow instruction to install [MySql.docs](https://dev.mysql.com/doc/mysql-installation-excerpt/5.7/en/)
## Install dependence 
**JDK 11**
- Follow instructions to install the latest version of JDK [oracle docs](https://docs.oracle.com/en/java/javase/11/install/overview-jdk-installation.html#GUID-8677A77F-231A-40F7-98B9-1FD0B48C346A)
**Maven**
- Follow instruction to setup and install [Maven](https://maven.apache.org/install.html))
## Create database for project(You can skip this step if you not want to use any specific database)
- By default we use H2Database for project if you want to use MySql or MSSql you need to create database name 'swp' in your machine by using fowlling script `create database swp`
- All data of project are implemented in project code.
- You need to change some code in file `application.properties` 
  - If you use MySql you need uncommend code from line 16 to line 21
  - if you use MSSql you need uncommend code from line 1 to line 7
![application.properties Image](https://github.com/noname163/swp_project/blob/main/Screenshot%20(43).png)

- In file `pom.xml` you will change code depend on database you use
  - If you use MySql you will uncomment code from line 40 to 44
  - If you use MSSql you will uncomment code from line 35 to 39
  - If you use H2Database you will uncoment code from line 29 to 33
![pom.xml](https://github.com/noname163/swp_project/blob/main/Screenshot%20(44).png)

## Run Project
- Download, open project name "swp_project" in VS Code and run by command `mvn spring-boot:run` 
## Error handling
- All error will redirect to `Error Page`
![Error Page](https://github.com/noname163/swp_project/blob/main/Screenshot%20(46).png)
## End point

### GET /account
- General
  - Get all account available
  - Return an account object similar to the one below
```diff
Account [ 
id= 1, address=null, avatar=null, company=null, 
email=datdhse150011@fpt.edu.vn, employee=null, fullName=FPT, 
phone=null, role=STUDENT, status=Enable, student=null]
```

### GET /employee
- General
  - Get all employee available
  - Return an employee object similar to the one below
```
Employee [id=1, account=Account [ id=4, address=null, avatar=null, company=null, 
email=trungskse150457@fpt.edu.vn, employee=null, fullName=test3, 
phone=null, role=EMPLOYEE, status=Enable, student=null], jobList=[], 
processList=[], requestList=[], studentApplyList=[]]
```
### GET /company
- General
  - Get all company available
  - Return an company object similar to the one below
```
Company [id=1, account=Account [id=1, address=null, avatar=null, 
company=null, email=hoannsse150010@fpt.edu.vn, employee=null, 
fullName=FPT SOFTWARE, phone=null, role=COMPANY, status=Enable, student=null],
description=Information Technology & Services  10,001+ employees  377 on LinkedIn
Established since 1999, a leading IT Service provider in Southeast Asia with 52 offices in 18 countries and 700+ customers worldwide.,
jobList=[], processList=[]]
```

### GET /student
- General
  - Get all student available
  - Return an student object similar to the one below
```
Student [id=6, account=Account [address=null, avatar=null, company=null, 
email=datdhse150011@fpt.edu.vn, employee=null, fullName=FPT, phone=null, 
role=STUDENT, status=Enable, student=null], applyList=[], cvList=[], 
dateOfBirth=null, gender=null, id=1, processList=[], 
requestList=[], semester=Semester [applyList=[], endDate=2022-06-20, id=1, 
semester=Spring, startDate=2022-03-06, studentList=[], year=2022], studentId=SE1500000]
```

### GET /major
- General
  - Get all major available
  - Return an major object similar to the one below
```
Major: Major [id=1, name=SE, positionList=[]]
```

### GET /cv
- General
  - Get all curriculum Vitae available
  - Return an curriculum Vitae object similar to the one below
```
CV [id=1, applyList=[], description=front end javascript java C++, id=1, name=test, 
path=null, status=Active, 
student=Student [account=Account [id=6, address=null, avatar=null, 
company=null, email=datdhse150011@fpt.edu.vn, employee=null, 
fullName=FPT, phone=null, role=STUDENT, status=Enable, student=null],
applyList=[], cvList=[], dateOfBirth=null, gender=null, processList=[], 
requestList=[], semester=Semester [id=1, applyList=[], 
endDate=2022-06-20, id=1, semester=Spring, startDate=2022-03-06,
studentList=[], year=2022], studentId=SE1500000]]
```

### GET /job
- General
  - Get all job available
  - Return job object similar to the one below
```diff
 Job [id =1, applyList=[], benefit=null, 
 company=Company [id =1, account=Account [address=null, avatar=null, company=null, 
 email=hoannsse150010@fpt.edu.vn, employee=null, fullName=FPT SOFTWARE, id=1, 
 phone=null, role=COMPANY, status=Enable, student=null], 
 description=Information Technology & Services  10,001+ employees 
 377 on LinkedIn Established since 1999, a leading IT Service provider in 
 Southeast Asia with 52 offices in 18 countries and 700+ customers worldwide.,
 jobList=[], processList=[]],
 description=Clarify requirements, initiative solutions 
 and develop deliverable software in the iterations of Scrum
Participate in building and developing system architecture
Create technical documents such as: system architecture, high level design
Developing new features/product improvements
Research and solve difficult technical issues
, employee=Employee [account=Account [id=1, address=null, avatar=null,
company=null, email=trungskse150457@fpt.edu.vn, employee=null, fullName=test3, 
phone=null, role=EMPLOYEE, status=Enable, student=null], id=1, 
jobList=[], processList=[], requestList=[], studentApplyList=[]],
endDate=2022-09-20, id=1, position=Position [id=2, jobList=[], 
major=Major [id=1, name=SE, positionList=[]], position=Frontend], 
positionId=0, recommend=null, requirement=Strong understanding of WebRTC
Good knowledge with C++, Java or Javascript
2 years Experienced in developing web apps with ReactJS, NodeJS
Experience in building and deploying applications on the cloud (AWS)
Have in-depth knowledge of Object Oriented Design and Data Structures
Knowledge of infra, networking, slot=10, startDate=2022-03-06, status=Accepted]
```
### GET /position
- General
  - Get all position available
  - Return an position object similar to the one below
```
Position: Position [id=1, jobList=[], major=Major [id=1, name=SE, positionList=[]], position=Backend]
```

### GET /studentApplyJob
- General
  - Get all student apply job available
  - Return an student apply job object similar to the one below
```
StudentApplyJob [id =1, cv=CV [applyList=[], description=front end javascript java C++,
id=1, name=test, path=null, status=Active, 
student=Student [account=Account [address=null, avatar=null, company=null, email=datdhse150011@fpt.edu.vn, employee=null, 
fullName=FPT, id=6, phone=null, role=STUDENT, status=Enable, student=null], applyList=[], cvList=[], dateOfBirth=null, 
gender=null, id=1, processList=[], requestList=[], semester=Semester [applyList=[], endDate=2022-06-20, id=1, 
semester=Spring, startDate=2022-03-06, studentList=[], year=2022], studentId=SE1500000]], 
employee=Employee [account=Account [address=null, avatar=null, company=null, 
email=trungskse150457@fpt.edu.vn, employee=null, fullName=test3, id=4, phone=null,
role=EMPLOYEE, status=Enable, student=null], id=1, jobList=[], processList=[], requestList=[], 
studentApplyList=[]], id=3, job=Job [applyList=[], benefit=null, 
company=Company [account=Account [address=null, avatar=null, company=null, 
email=hoannsse150010@fpt.edu.vn, employee=null, fullName=FPT SOFTWARE, id=1, 
phone=null, role=COMPANY, status=Enable, student=null], 
description=Information Technology & Services  10,001+ employees  377 on LinkedIn
Established since 1999, a leading IT Service provider in Southeast
Asia with 52 offices in 18 countries and 700+ customers worldwide., 
id=1, jobList=[], processList=[]], description=Clarify requirements, 
initiative solutions and develop deliverable software in the iterations of Scrum
Participate in building and developing system architecture
Create technical documents such as: system architecture, high level design
Developing new features/product improvements
Research and solve difficult technical issues
, employee=Employee [account=Account [address=null, avatar=null, company=null, email=trungskse150457@fpt.edu.vn,
employee=null, fullName=test3, id=4, phone=null, role=EMPLOYEE, status=Enable, student=null], id=1, jobList=[], 
processList=[], requestList=[], studentApplyList=[]], endDate=2022-09-20, id=1, 
position=Position [id=2, jobList=[], major=Major [id=1, name=SE, positionList=[]], 
position=Frontend], positionId=0, recommend=null, requirement=Strong understanding of WebRTC
Good knowledge with C++, Java or Javascript
2 years Experienced in developing web apps with ReactJS, NodeJS
Experience in building and deploying applications on the cloud (AWS)
Have in-depth knowledge of Object Oriented Design and Data Structures
Knowledge of infra, networking, slot=10, startDate=2022-03-06, status=Accepted], 
process=null, request=null, semester=Semester [applyList=[], endDate=2022-06-20, id=1,
semester=Spring, startDate=2022-03-06, studentList=[], year=2022], status=Waiting, 
student=Student [account=Account [address=null, avatar=null, company=null,
email=datdhse150011@fpt.edu.vn, employee=null, fullName=FPT, id=6, phone=null,
role=STUDENT, status=Enable, student=null], applyList=[], cvList=[], dateOfBirth=null,
gender=null, id=1, processList=[], requestList=[], semester=Semester [applyList=[], endDate=2022-06-20, id=1,
semester=Spring, startDate=2022-03-06, studentList=[], year=2022], studentId=SE1500000]]
```


#### © TEAM7 
