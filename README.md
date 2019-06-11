# Berlin Clock

## About this Kata

This short and simple Kata should be performed using **Test Driven Development** (TDD).

## Rules

The Berlin Clock (Mengenlehreclock or Berlin Uhr) is a clock that tells the time using a series of illuminated coloured blocks, as you can see in the picture for this project.

The top lamp blinks to show seconds- it is illuminated on even seconds and off on odd seconds.

The next two rows represent hours. The upper row represents 5 hour blocks and is made up of 4 red lamps. The lower row represents 1 hour blocks and is also made up of 4 red lamps.

The final two rows represent the minutes. The upper row represents 5 minute blocks, and is made up of 11 lamps- every third lamp is red, the rest are yellow. The bottom row represents 1 minute blocks, and is made up of 4 yellow lamps.

This application prints textual representation of Berlin Clock like below

**0** - Second\
**RRRR** - Five Hour Row\
**RR00** - Single Hour Row \
**YYRYY000000** - Five Minute Row \
**0000** - Single Minute Row


0 - No Light\
R - Red Light\
Y - Yellow Light

### Prerequisite for this application

JDK 1.8\
Maven 3.x\
Git

###Set up application
#### IDE
1. Clone the repository 
2. Add as Maven project
3. Select Project SDK as JDK 1.8

#### Command prompt
1. Clone repository from GIT
2. Run `mvn clean install`

### Run Test Cases
#### IDE
1. Go to Maven Toolbar
2. Select `test`

#### Command Prompt
1. Go to project directory
2. Run `mvn test` under lifecycle menu

**Code coverage and Mutation coverage Report**
Application uses pitest dependency to check code coverage and mutation testing coverage
1. Open the command prompt / terminal from project directory 
2. Run `mvn pitest:mutationCoverage` or `mvn clean install`
3. Go to target -> pit-reports -> directory in the name of YYYYMMddHHmm -> index.html
4. Code coverage and mutation coverage report will be displayed as summary and package wise report

###Run Application
#### IDE
1. Go to Run configuration
2. Select BerlinClockApplication as main class and enter valid digital time in arguments section example 23:34:34
3. Click Run
#### Command prompt
1. Go to your project directory
2. Run `mvn clean install` to build the project
2. Run `mvn exec:java -Dexec.args={arguments}`


