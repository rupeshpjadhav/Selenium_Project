
# Test Automation Project

http://www.automationpractice.pl/


## Authors

- [Rupesh Jadhav](https://www.github.com/rupeshpjadhav)


## Tech Stack

**Language:** Java

**Automation:** Selenium

**Framework:** TestNG

**Reports:** Extent Reports

**Implemented Following:**
1. Page Object Model
2. Reports using Extent Reports
3. Excel utility is handled
4. Selenium Grid with standalone as well as hub-node using docker.
5. Cross browser and parallel testing using TestNG
6. Added maven plugins for execution from pom.xml - maven-compiler-plugin and maven-surefire-plugin
7. Implemented logging using Log4j


**Pre-requisites for Selenium Grid:**
1. Create the Grid either using Standalone or hub-node using docker.
2. For Selenium grid using Docker, do following:-
3. Create a file docker-compose.yaml with required config.
4. To up the docker environment, run command -> docker-compose up 
5. Using the grid URL, then we can run the tests remotely. 
5. To down the docker environment, run command -> docker-compose down 
   



