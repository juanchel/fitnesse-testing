If builds are broken, Maven is not working properly, or classpaths are not configured
right or if they are corrupted, try the following steps. 

Build path configuration... (Project -> Properties -> Java Build Path)

### Source folders

-- `FitExample/src/main/java` -> contains java source packages  
-- `FitExample/src/test/java` -> contains java test packages with JUnit and JUnit fitnesse tests and suites   
Output folders (binaries)   
-- `FitExample/target/classes` -> contains java source class files  
-- `FitExample/target/test-classes` -> contains java test class files  

### To reconfigure source folders in build path

a. Remove present source folder  
b. Add source folders ending with `/java` suffix as above  
c. Define output folders for each as above (select "Allow output folders for source folders")  

### To add libraries (jar files) explicitly to build path  

a. Go to Libraries  
b. Add latest JRE as a library  
c. Add JUnit 4 as a library if not present  
d. Add `cobertura-2.0.3.jar` as an external jar (in `FitnesseDir`)  
e. Add `fitnesse-standalone.jar` as an external jar  
  
### Rebuilding Maven project (command line: `mvn <goal>`)

- Maven build: use goal `compile` (should download all dependencies specified in `.pom` at first run)  
- Maven cobertura coverage analysis : use goal `cobertura:cobertura` (instruments source files, runs tests, and creates coverage reports) => output in `target/coverage-reports`  
- Maven test: use goal `test` (runs unit and fitnesse tests using sure-fire plugin; no coverage analysis) => output in `target/surefire-reports` and `target/fitnesse-reports`  
- Maven clean: use goal `clean` (deletes all reports folders)   
- If things look odd: perform Maven->Update Project after a run/build to update folders  
- If build state is corrupted: try Project->Clean and don't run Maven `clean`  

### Running Fitnesse server (located inside `FitnesseDir`)	

`java -jar fitnesse-standalone.jar -p 8080`  (or use another port, don't use port `80`)  
	
Open a browser window, go to:  

`http://localhost:8080/FitNesse.MyFitExamples.WeeklyTimesheet.TimesheetHeader?edit&redirectToReferer=true&redirectAction=`  

and edit path files if necessary. Normally only one path, the one in the `System Property Fixture`, needs to be absolute and and changed. The other classpaths should work if you retain the folder structure. 
	
Try that this works buy a Maven build with goal `cobertura:cobertura`. This should generate coverage reports in `target/coverage-reports`.   

###  If not using Maven

Include `cobertura-2.0.3.jar` and `fitnesse-standalone.jar` in the Java buildpath.   

For test converage reports:   
1) Run in console the `cobertura-instrument.sh` with the right arguments.    
2) Rerun all tests and suites in the browser using Fitnesse server.   
3) Run in console the `cobertura-report.sh` with the right arguments.   
  
`FitNesse.MyFitExamples.WeeklyTimesheet.TimesheetHeader` describes the arguments of the scripts.   

Windows (`.bat`) scripts need to be updated since they use stale libraries in the classpath options. The Linus (`.sh`) scripts should be correct.   

### To view reports

To view test run and coverage reports, check `*.html` files in `target/coverage-reports`, `target/surefire-reports` and `target/fitnesse-reports`. The root, if it exists, is the `index.html` in each case.   

