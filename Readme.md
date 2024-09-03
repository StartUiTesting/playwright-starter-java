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

#### Browser download
On managed devices the browser download is blocked, so it must be downloaded manually or a developer proxy must be used.
If you are comfortable using and configuring a proxy, skip the following steps.

* Download and unzip the chrome browser into a temp dir: https://playwright.azureedge.net/builds/chromium/1129/chromium-win64.zip
* Move the folder `chrome-win` into the directory  `C:\dev\progs\playwright\chromium-1129`
* Verify that the executable `C:\dev\progs\playwright\chromium-1129\chrome-win\chrome.exe` can be started, e.g. 
  via command line
* Set the environment variables `PLAYWRIGHT_BROWSERS_PATH=c:/dev/progs/playwright` and `PLAYWRIGHT_SKIP_BROWSER_DOWNLOAD=1`. 
  Restart your IDE or terminal to apply the changes.

