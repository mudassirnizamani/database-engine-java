# Database-Engine
Database Engine that supports some features like:
- Creating a table
- Inserting into a table
- Updating a table
- Deleting from a table
- Selecting from a table
- Writing SQL queries
- Supported data types: **int** (java.lang.Integer), **double** (java.lang.Double), **date** (java.util.Date), **varchar** (java.lang.String)   
</br>

[![Java CI with Maven](https://github.com/YehiaFarghaly/Database-Engine/actions/workflows/maven.yml/badge.svg)](https://github.com/YehiaFarghaly/Database-Engine/actions/workflows/maven.yml)  
<div style="display: flex;">
  <img src="https://img.shields.io/badge/Apache-maven-%23C71A36?style=for-the-badge&logo=ApacheMaven" alt="Apache Maven badge">
  <img src="https://img.shields.io/badge/Github-Actions-%232088FF?style=for-the-badge&logo=GithubActions" alt="Github Actions badge">
  <img src="https://img.shields.io/badge/Junit5-tests-%2325A162?style=for-the-badge&logo=Junit5" alt="Junit 5 badge">
  <img src="https://img.shields.io/badge/Git--%23F05032?style=for-the-badge&logo=Git" alt="Git badge">
  <img src="https://img.shields.io/badge/-Github-%23181717?style=for-the-badge&logo=Github" alt="Github badge">
  <img src="https://img.shields.io/badge/-Dependabot-%23025E8C?style=for-the-badge&logo=Dependabot" alt="Dependabot badge">
  <img src="https://img.shields.io/badge/-Checkstyle-%234c6ef5?style=for-the-badge&logo=Checkstyle&logoColor=white" alt="Checkstyle badge">
  <img src="https://img.shields.io/badge/-Java-%23ED8B00?style=for-the-badge&logo=java&logoColor=white" alt ="Java badge">
  <img src = "https://img.shields.io/badge/-ANTLR-%237231d6?style=for-the-badge&logo=ANTLR&logoColor=white" alt = "ANTLR badge">
</div>

---
## Tools
- Language used is [Java](https://www.java.com/en/)
- Project is built using [maven](https://maven.apache.org/)  
- CI pipeline using [Github Actions](https://github.com/features/actions)
- Tests are written in [Junit5](https://junit.org/junit5/)
- Style is preserved using [checkStyle](https://checkstyle.sourceforge.io/)
- SQL is parsed using [ANTLR](https://www.antlr.org/)

---
## How to run tests and checks:
* Make sure to have [Apache Maven](https://maven.apache.org/) installed on your pc.
<!-- * To run checkStyle checks run the following command : `mvn checkstyle:check` -->
* To run Junit5 tests run the following command : `mvn test`  

---

## Code examples

### Normal Selection
```java
SQLTerm[] sqlTerms = new SQLTerm[2];
sqlTerms[0] = new SQLTerm("Students", "gpa", "=", 4.0);
sqlTerms[1] = new SQLTerm("Students", "id", ">", 100);
String[] strArrOperator = new String[] { "AND" };
engine.selectFromTable(sqlTerms, strArrOperator);
```
### Selection Using SQL
```java
StringBuffer command = new StringBuffer("SELECT * FROM Students WHERE gpa = 4.0 AND id > 100");
engine.parseSQL(command);
```
---

### Normal Insertion
```java
Hashtable<String, Object> htblColNameValue = new Hashtable<>();
htblColNameValue.put("id", 1);
htblColNameValue.put("name", "student1");
htblColNameValue.put("gpa", 3.3);
engine.insertIntoTable("Students", htblColNameValue);
```
### Insertion Using SQL
```java
StringBuffer command = new StringBuffer("INSERT INTO Students(id, gpa, name) VALUES(1, 3.3, 'student1')");
		engine.parseSQL(command);
```
---

### Normal Deletion
```java
Hashtable<String, Object> htblColNameValue = new Hashtable<>();
htblColNameValue.put("gpa", 3.3);
engine.DeleteFromTable("Students", htblColNameValue);
```
### Deletion Using SQL
```java
StringBuffer command = new StringBuffer("DELETE FROM  Students WHERE gpa = 3.3");
		engine.parseSQL(command);
```

### Notes
- There is a ready table called student with the following columns (ID: int, GPA: Double, Name: String)
