package Testing.utilities;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;


public class Driver {
    //create a private constructor to remove access to this object
    private Driver(){}

    /*
    We make the WebDriver private, because we want to close access from outside the class.
    We are making it static, because we will use it in a static method.
     */
    // private static WebDriver driver; // default value = null





    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    /*
    Create a re-usable utility method which will return the same driver instance once we call it.
    - If an instance doesn't exist, it will create first, and then it will always return same instance.
     */
    public static WebDriver getDriver(){
        ChromeOptions options = new ChromeOptions();
        if (driverPool.get() == null){

            /*
            We will read our browserType from configuration.properties file.
            This way, we can control which browser is opened from outside our code.
             */
            String browserType = ConfigurationReader.getProperty("browser");
            browserType=browserType.trim().toLowerCase();

            /*
            Depending on the browserType returned from the configuration.properties
            switch statement will determine the "case", and open the matching browser.
             */
            switch (browserType){
                case "chrome":
                    // WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver(options.addArguments("--remote-allow-origins=*")));
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    //WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
            }

        }

        return driverPool.get();

    }

    /*
    Create a new Driver.closeDriver(); it will use .quit() method to quit browsers, and then set the driver value back to null.
     */
    public static void closeDriver(){
        if (driverPool.get()!=null){
            /*
            This line will terminate the currently existing driver completely. It will not exist going forward.
             */
            driverPool.get().quit();
            /*
            We assign the value back to "null" so that my "singleton" can create a newer one if needed.
             */
            driverPool.remove();
        }
    }
}

/*
This is a Java class that provides a utility method for creating and managing a WebDriver instance that can be used for automated testing with Selenium. The class defines a static method called getDriver() which returns a WebDriver instance that matches the browser type specified in a configuration file.

The class uses a private constructor to ensure that only the static methods of the class can be used to create and manage a WebDriver instance. It also uses a ThreadLocal variable to ensure that each thread in a multi-threaded environment has its own instance of the WebDriver, so that tests can run concurrently without interference.

The getDriver() method checks if a WebDriver instance has already been created and stored in the ThreadLocal variable, and returns it if it exists. If no instance exists, it creates one based on the browser type specified in the configuration file. The method then sets the implicit wait time and maximizes the browser window before returning the WebDriver instance.

The class also defines a closeDriver() method, which is used to close the WebDriver instance and clean up any resources used by it. This method uses the .quit() method to terminate the driver completely and sets the ThreadLocal variable back to null, so that a new instance can be created if needed.

The supported browser types are currently Chrome and Firefox, and the Chrome browser is configured with remote-allow-origins set to *, which allows it to work with some external web applications.

The driverPool variable is an InheritableThreadLocal object, which is used to store the WebDriver instance. This variable is defined as static, so that there is only one instance of it that can be shared by all threads in the test suite. The InheritableThreadLocal class is used to create a copy of the variable for each new thread that is created, so that each thread has its own copy of the WebDriver instance.




 */