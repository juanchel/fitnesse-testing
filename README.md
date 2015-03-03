## About This Repository

This repository is required for preparing for L2 - Test Design Exercises. 
It also contains preparation and classroom instructions for L2.

1. Download the repo using the [Download ZIP] link. DO NOT use the [Clone in Desktop] link. Don't try to push your changes back to this repository.  
2. Import the repo into your Eclipse workspace (or your favorite IDE). This should work reasonably well with Eclipse. Make sure you have Eclipse Maven plugin installed. 
3. If the classpath configuration is messed up and dependencencies don't work, see `TROUBLESHOOTING.md`. A `.project` and a `.classpath` file are provided, but these will not work with an IDE other than Eclipse. 

## What the Repository Contains

1. The Fitnesse wiki and framework in its entirety, including all of its directory structure and standalone server. 
2. The coberture code coverage tool, including command-line scripts.
3. A working example that contains java sources, Fitnesse tests that use Fit fixtures, and cobertura 
setup for coverage analysis using both Maven command-line scripts. 

Fitnesse is an acceptance testing framework that allows writing non-developer-friendly tests. The tests are written as wiki pages in a table-like notation. To define tests, we will use Ward Cunninham's _Fit_ (Framework for Integration Testing) fixtures, which look very much like test-case tables in class examples. Test pages are special wiki pages created in a markdown language and may contain documentation and notes... any text really. Fitnesse is run as a wiki web server and can hook up with your Java source code using glue fixture code. 

## Preparation for L2 - Setup

1. Browse to `FitnesseDir` directory. 
3. Start the Fitnesse server on localhost: `java -jar fitnesse-standalone.jar -p 8080` (if port 8080 is used, substitute an usused port).
4. Open your browser and go to  `localhost:8080`. 
5. Read about Fitnesse: read the _One-Minute Description_; try the _Two-Minute Example_.
6. Browse the _User Guide_: review _Getting Started_, _Working with the Fitnesse Wiki_, _Writing Acceptance Tests_, and then jump staight to _Fit_.
7. Navigate to _FitNesse_ -> _My Fit Examples_ -> _Weekly Timesheet_ -> _Timesheet Header_. Read this wiki page. Edit the wiki page to change the value of the `net.sourceforge.cobertura.datafile` system property so that this will point to the correct file in your local directory structure. Run a Maven build with goal `compile` to install necessary dependencies (your project must have Maven nature. If necessary, select the project folder in Eclipse and try Eclipse->Project->Clean to remove any stale build state.  If this does not work, add add JUnit (as a reference library), as well as the Fitnesse Standalone jar file and the cobertura jar file (as external jars) explicitly to your project classpath. You'll find the latter jar files under `FitnesseDir` and its subfolder`cobertura-2.0.3`. 
8. Navigate to _Weekly Timesheet_ -> _Timesheet Suite_. This is a suite that contains only one test case. Inspect this suite page. Then run the suite by hitting `Suite`.
9. Navigate to _Weekly Timesheet_ -> _Timesheet Suite_ -> _Weekly Compensation_. Inspect this test case page. Then run the test by hitting `Test`. 
10. Experiment with creating new Fitnesse pages and editing existing pages. 
11. Browse the Java source to see how the Fitnesse test case is connected to the source code through a fixture class. Look under`src/main/java`. The source code is in  `timesheet` package. The Fit fixture code is located under  `fit.timesheet` package.
12. Look under `src/test/java` to see how to run the Fitnesse tests from JUnit using the`FitNesseRunner` test runner. Regular unit tests are located in `junit.timesheet` package. Fitnesse test suites are under the  `junit.fitnesse.timesheet` package. 
13. Now try the Maven setup (your project must have Maven nature). Run a Maven build using the `test` goal to execute both regular unit tests and Fitnesse tests (from console, this is done by: `mvn test`). The fist time this goal is executed, all plugin dependencies will be installed into your project. Inspect the `pom.xml` file for the Maven setup. This setup uses the `maven-sure-fire-plugin` to run both JUnit and Fitnesse tests. For now, running the regular JUnit tests are disabled in the pom file inside the sure-fire configuration. Fitnesse and sure-fire html reports will be generated and stored in subfolders `/target/fitnesse-reports` and `/target/surefire-reports `, respectively. You may browse and render them within your IDE's web browser. 
14. Now try the Maven setup to test coverage analysis. For this run Maven with the `cobertura:cobertura` goal, which uses the `cobartura-maven-plugin`. This will create instrumented Java source files for coverage analysis, which regular JUnit test and Fitnesse tests will use to create coverage data files and html reports. Cobertura coverage data and reports will be accessible in the subfolders `/target/cobertura` and `/target/coverage-reports`, respectively. 
15. Problems with Maven builds? Make sure that your IDE has a Maven plugin installed. You may run coverage analysis manually too. Open a console shell. Browse to  `FitnesseDir/cobertura-2.0.3`. Instrument the classes (if they have already been instrumented and haven't changed since last instrumentation, no need to re-instrument) by running the `cobertura-instrument` script with the proper arguments. Run the required Fitnesse tests from the Fitnesse web server. Then run the `cobertura-report.sh` script with proper arguments to generate the coverage reports. Check the reports under the `/targe/coverage-reports` subfolder. For more information on how to specify the arguments, see _TimesheetHeader_ page. Attention Windows users: the `.bat` scripts must still be updated to fix the old dependencies as described in _TimesheetHeader_. I have already updated the `.sh` shell scripts for Linux/OSX/Unix users. 
16. You may delete the reports folders under the `target` directory by executing a Maven build with `clean` goal (from console: `mvn clean`). The `.pom ` file has a `maven-clean-plugin` configuration to delete the right folders when the `clean ` goal is executed. If the build state gets corrupted after a `clean`, select project folder and try Eclipse-Project->Clean. 
17. Come to class with your setup ready and working. There won't be any time to fix dependencies and install missing components. 

## Preparation for L2 - Java Programs

Implement the following specs using two small Java programs. In the `FixExample` project structure, put their source classes under different packages named `triangle` and `date`. Both packages should be placed in the `/src/main/java` subfolder. 

1. A `Triangle` is represented by three integers `a`, `b`, `c`, each corresponding to the lengh of one of the three sides. The `classify()` method of a `Triangle` object classifies the triange as either `TRIANGLE.SCALENE` (all sides are of different lengths), `TRIANGLE.EQUILATERAL` (all sides are of equal length), or `TRIANGLE.ISOSCELES` (two sides are of equal length). The `isRightAngled()` method returns `true` if the triangle is right-angled; `false` otherwise. For a valid triangle, the sum of any two sides must exceed the third side. 
2. A `Date` object represents a date using three integers: `day`, `month`, and `year`. The `nextDate()` methods returns a new `Date` object that gives the date of the next day. The `isLeapYear()` method returns `true` if the `year` of the `Date` object  is a leap year; `false` otherwise. The `year` must be between 1900 and 2200 (1899 and 2201 are not a valid years). A leap year is a year that is divisible by 4; but if it's a century year, it should also be divisible by 400. 

## In-Class Instructions

Perform the following tasks during the lab.

### Systematic Spec-Based Testing of _Triangle_

--1. Desing an input space model for the _Triangle_ spec (including both interface methods `classify()` and `isRightAngled()`).  
---1.1. Identify attributes.   
---1.2. Identify characteristics.    
---1.3. Partition the characteristics into blocks that are equivalence classes.   
---1.4. Identify the contstraints and dependencies among blocks from different characteristics.    
 
--2. Derive test case specs from the input space model.    
---2.1. Form feasible combinations of blocks into test cases.    
---2.2. Choose representative values for attributes for each combination, identifing the oracle for when required.     
---2.3. Organize your test cases into a table with columns representing attributes and rows representing test cases.       

-- 3. Create the necessary page hierarchy in the Fitnesse wiki. Create an entry page _Triangle_ under _My Fit Examples_.    _Triangle Header_, _Triangle Suite_, and _Triangle Test_ (and any other test pages you may need under _Triangle Suite_) should mirror the hiearchy and structure in the _Weekly Timesheet_ example.   

-- 4. Create and run Fitnesse tests.   
--- 4.1 Convert test case specs to test cases expressed as Fitnesse test pages using the _Column Fixture_. For each test case, you need to choose values for all attibutes and determine the oracle. Add these test cases to the appropriate test page.      
--- 4.2 Add the required fixture code to your Java source. This should go under `/src/main/java` in a package `fit.triangle`.     
--- 4.3 Run your fitnesse tests (or test suite). Inspect the results. Don't modify your code. Note any faults found to report in your lab report.    

-- 5. Calculate the coverage of your tests. Visualize the resulting reports. Take notes for your lab report.     

### Systematic Spec-Based Testing of _Date_

Repeat _Triangle Testing_ for the _Date_ spec. Differences are below. 

--- 1.1 The interface methods are: `nextDate()` and `isLeapYear()`.   
  
-- 3. Fitnesse page hierarchy: create an entry page _Date_ under _My Fit Examples_.    _Date Header_, _Date Suite_, and _Date Test_ (and any other test pages you may need under _Date Suite_) should mirror the hiearchy and structure in the _Weekly Timesheet_ example.   
  
--- 4.2. The Java fixture code should go under `/scr/main/java` in a package `fit.date`. 

Note: use _Comment Fixture_ tables to document your test design (attributes, characteristics, decision tables, etc.) - comment fixtures are not executed if included in a test or suite page, but will improve the readability of your test pages.


## Creating and Submitting Your Lab Report

Create a _Lab Report_ wiki page under _My Fit Examples_. Copy the following report template below and paste it into the _Lab Report_ page. Fill out the report, removing `//` placeholder lines. Print/save your _Lab Report_ page and all your test pages as a single PDF file. Submit to Blackboard. 
Naming convention for the aggregate report file (_Lab Report_ + test pages): NameLastName-L2Report.pdf

-------

LAB REPORT - Test Design Exercises

Name: ..........    
Andrew ID: .........   
URL of your github repo: .........    

// IMPORTANT: Replace/remove these comment lines in your report.   

-- 1. Summary 

// Describe briefly what you did during this lab.   
// List the tasks performed and completed.   
// List which tasks are outstanding or partially completed.   
// Use bullet points.   
 
-- 2. Lessons Learned

// What did you learn?   
// What worked well?   
// What challenges did you face?   
// Comment on effectiveness of your tests? Did the uncover any faults in your code? Elaborate.
// Comment on the coverage of your tests? 
// List any other insights gained. Are you comfortable with modeling input spaces? Can you create test cases from simple input space models? 
// Use bullet points.

-- 3. Suggestions for Improvements (Optional)

// List any suggestions for improving this lab.    
// Be as specific as possible.    
// Use bullet points.   

// This report should be about one page long. //   







