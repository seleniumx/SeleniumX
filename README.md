[![Circle CI](https://circleci.com/gh/seleniumx/SeleniumX.svg?style=shield&circle-token=:circle-ci-badge-token)](https://circleci.com/gh/seleniumx/SeleniumX/tree/master) [![Build Status](https://travis-ci.org/seleniumx/SeleniumX.svg?branch=master)](https://travis-ci.org/seleniumx/SeleniumX) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.seleniumx/seleniumx/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.seleniumx/seleniumx)![codecov](https://codecov.io/gh/seleniumx/SeleniumX/branch/master/graph/badge.svg)

![alt text](https://github.com/seleniumx/seleniumx/blob/master/Seleniumx_logo.png)

# [Seleniumx](https://www.seleniumx.com)
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
## Get more details from [Seleniumx website](https://www.seleniumx.com)
