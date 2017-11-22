# Adiso Azure Data Base

## SYNOPSYS
this is an example of Data Access Layer, through Java, with JDBC. Using Azure Data Base on the Cloud.

Made it for **Adiso**. Enjoy!
## Install JDBC of Microsoft sqlserver
please use the links below to get information:

- Microsoft Guide: [Use Java to query an Azure SQL database](https://docs.microsoft.com/he-il/azure/sql-database/sql-database-connect-query-java)
- How to install External JDBC library in your project:
  - if you encountered *No Suitable Driver Found Exception* for the JDBC driver, this is where you need to go: (in IntellijJ)
  
  ![intellij image](https://raw.githubusercontent.com/idanizi/adiso-db/master/2017-11-22_16-10-36.gif)

## DataBase and Schemas
> Azure data base, found at adiso-db.database.windows.net, 1433

> please look at the code to see user name (uid) and password (pwd)

![image](https://user-images.githubusercontent.com/9889268/33133196-b9c6b0d0-cfa4-11e7-9f9a-7c8b632d6539.png)

### Schema:
#### Questions
- Primary Key (PK) is **ID**
- **ANSWER_ID**: Forign Key (FK, pointer) to the choice that is the answer to the question
#### Choices
- Primary Key (PK) is **ID**
- **QUESTION_ID**: FK to the question of this choice

![image](https://user-images.githubusercontent.com/9889268/33133184-acf51766-cfa4-11e7-97ef-6d63c835275a.png)

## Author
| Name | Email | Website |
|------|-------|---------|
| idan izicovich | <idanizi@gmail.com> | [www.idanizi.com](http://www.idanizi.com) |
