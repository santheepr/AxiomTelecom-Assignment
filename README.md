# AxiomTelecom-Assignment
-------------------------

This project includes solution for Scenario 1 and Scenario 2 of QA Assignment from Axiom Telecom

Built With:
-----------
1. Java 8
2. RestAssured
3. TestNG
4. Maven
5. Extent Reports

Logging - Log4j is used for Logging and logs are generated in "Project\log.log".
Reporting - Extent report is used for reporting, and reports are generated in "Project\test-output\Report.html".

Run instructions:
-----------------
Open command prompt and navigate to the project directory. Run the below command:
mvn clean test

Approach Implemented:
--------------------
1. BaseURI is kept in "Project\src\main\resources\config.properties", and accessed using Config.<methodname>
2. POJO classes are used for Deserialization of Reponse body. Separate Pojo classes are used for Scenario_1(com.employees.pojo.employeelistapi) & Scenario_2(com.employee.pojo.singleemployeeapi)
3. Test data is kept in "Project\src\main\resources\TestData.xlsx. Apache POI is used for reading data from excel sheet.
4. The Employee ID is selected dynamically from a random generator utility "Project\src\main\java\com\employee\utils\RandomEmployeeIDGenerator.java"
