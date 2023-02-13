# cucumber-framework - Functional Framework built wit Cucumber

### Brief explanation
In order to test this FW the following app was used [GreenKart](https://rahulshettyacademy.com/seleniumPractise/#/).

There are 2 TestRunners: **RegressionTestRunner.java** and **SmokeTestRunner.java**. Both files are located under the following path: `src/test/java/testRunner`.

**RegressionTestRunner.java** will run all scenarios whereas **SmokeTestRunner.java** will run only those scenarios tagged as ***@Smoke***

> ***You can refer to the tested scenarios by opening the feature files under: `features` folder***

### How to use it 
* Open any TestRunner file and run it as a **JUNIT Test**.
* Once the execution is done, the runner will generate a HTML report located under `target/html-report` folder with the name as following: `<testRunnerPrefix>Report.html`, e.g: If you run **RegressionTestRunner.java** the report name will be `regressionReport.html`

