[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.aravindaw/driver/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.aravindaw/driver)

# driver
This project is developed based on selenium webdriver. I developed this project for the easiness of
test automation engineers who is using selenium webdriver frequently. Users who is using this library 
can config Selenium webdriver main configurations within few easy steps. 

### driver configuration steps
* Import maven dependency
* Use ```@DriverSettings``` annotation before the test method

##### @DriverSettings config parameters
* OS = Your os (WINDOWS, LINUX, MAC)
* WINDOW_SIZE = Webdriver window size (FULLSCREEN, MAXIMIZE, DEFAULT)
* BASE_URL = your base url (Type String)
* IMPLICIT_WAIT = default 100 milliseconds (Type int)
 
    ```
    @DriverSettings(
               OS = DriverSet.OS.LINUX,
               WINDOW_SIZE = DriverSet.WINDOW_SIZE.DEFAULT,
               BASE_URL = "https://www.samplewebsite.com",
               IMPLICIT_WAIT = 100
    )
    ```
