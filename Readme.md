## Prequisites for java projects (before the workshop)

To take part on the workshop please verify that the following software is installed and the provided example code can be executed with your device. 

* Java 17 e.g. Adopt
* Java IDE e.g. IntelliJ or Eclipse
* Maven
* On managed devices the browser has to be downloaded and a temp dir created first, see [Managed Devices](#managed-devices)

Start the Main class or MainForManaged respectively and verify that the string `Fast and reliable end-to-end testing for modern web apps | Playwright` is printed on console:

`mvn compile exec:java -e -D exec.mainClass=org.example.Main`

on managed devices:

`mvn compile exec:java -e -D exec.mainClass=org.example.MainForManaged`


### Launching the test code generator
The test code generator can be launched via the following maven command line:

`mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args=codegen`

On managed devices please use the following command (after doing the steps in [Managed Devices](#managed-devices))

`mvn exec:java -e -D playwright.driver.tmpdir=C:/dev/temp -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args=codegen`

If the example code is executing and the test code generator is launching you are ready to go!

### Managed devices

#### Creating a temp dir for playwright
Playwright for java uses a temp directory to launch the tests, which is blocked if it is not in `c:\dev`
* Create the temp dir `C:\dev\temp`
* Set java system property `playwright.driver.tmpdir`, e.g. add following string to vm options in your launch configs: `-Dplaywright.driver.tmpdir=C:\dev\temp`.
  Alternatively you can set it in code via `System.setProperty("playwright.driver.tmpdir", C:\dev\temp)`, see [MainForManaged.java](src/main/java/org/example/MainForManaged.java) for an example.
* Add the system property `playwright.driver.tmpdir=C:\dev\temp` to your playwright related maven commands, e.g. `mvn test -D playwright.driver.tmpdir=C:\dev\temp`

#### Browser download
On managed devices the browser download is blocked, so it must be downloaded manually or a developer proxy must be used.
If you are comfortable using and configuring a proxy, skip the following steps.

* Download and unzip the chrome browser into a temp dir: https://playwright.azureedge.net/builds/chromium/1129/chromium-win64.zip
* Move the folder `chrome-win` into the directory  `C:\dev\progs\playwright\chromium-1129`
* Verify that the executable `C:\dev\progs\playwright\chromium-1129\chrome-win\chrome.exe` can be started, e.g. 
  via command line
* Set the environment variables `PLAYWRIGHT_BROWSERS_PATH=c:/dev/progs/playwright` and `PLAYWRIGHT_SKIP_BROWSER_DOWNLOAD=1`. 
  Restart your IDE or terminal to apply the changes.

## Todos in the workshop

### 1. Write some test cases

- Edit the `ExampleTest.java` or create a new test.
- Find right **Locators** (https://playwright.dev/java/docs/locators)
- Use the Playwright´s Test generator to see **Locator** suggestions (https://playwright.dev/java/docs/codegen) <br>
  `mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args=codegen` 
  <br> on managed devices: `mvn exec:java -e -D playwright.driver.tmpdir=C:/dev/temp -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args=codegen`
- Call **Actions** on the Locators (https://playwright.dev/java/docs/input)
- Do **Assertions** on the Locators (https://playwright.dev/java/docs/test-assertions)
- Run your tests with `mvn test` or from your IDE

### 2. Try out the trace viewer (optional) 
- Run the `TraceTest.java` to generate a trace file 
- Open and analyze the trace file with the Playwright´s Trace Viewer https://trace.playwright.dev/
- The trace viewer can also be started with the following maven command: <br>
`mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="show-trace trace.zip"`
- For further information see https://playwright.dev/java/docs/trace-viewer

### 3. Try out the playwright inspector (optional)
- Run the `InspectorTest.java` with the following command: 
<br> `PWDEBUG=1 PLAYWRIGHT_JAVA_SRC=src/test/java mvn test -Dtest=org.example.InspectorTest`
- Step through the test 
- For further information see https://playwright.dev/java/docs/trace-viewer-intro
### 4. Use page object models

For better maintainability, enhance your test case design with the usage of page object models (POM, https://playwright.dev/java/docs/pom).

- Create a new POM in the `org.poms` package and define Locators (and functions for repetitive tasks).
- Import the new POM into your test case and reuse the Locators (and functions) from there.

