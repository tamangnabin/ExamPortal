# ExamPortalPrj

#### This a exam portal project. Front end is build using Angular 12.2.7 and Back-end using Spring-Boot. The project was initiated with the help of the tutorial by Durgesh [Tutorial link](https://www.youtube.com/playlist?list=PL0zysOflRCel5kT-AiGyy5oMabnlilkIS) 

## Prerequisites to run the project

  - Java 8 Installed 
  - Database
    - MySQL
  - MySQl Workbench
  - Node.js
  - npm packages
  - Angular CLI
  - IDE's
    - Intellij/Eclipse

## Installation 

#### Java Installation 

  - For Windows OS visit: https://www.java.com/en/download/help/windows_manual_download.html
  - For Ubuntu OS : Run the following command to install Java 'Open JDK 8'
    ```console
     sudo apt-get install openjdk-8-jdk
    ```
  - Verify the version of the JDK
    ```console
     java -version
     ```
    - You should see as below
       ```console
        openjdk version "1.8.0_292"
        OpenJDK Runtime Environment (build 1.8.0_292-8u292-b10-0ubuntu1~20.04-b10)
        OpenJDK 64-Bit Server VM (build 25.292-b10, mixed mode)
       ```
       
#### Database(MySQL) Installation
  
  - For Windows OS Visit: https://dev.mysql.com/downloads/installer/ 
    - Watch this video for installtion[Video Link](https://www.youtube.com/watch?v=WuBcTJnIuzo&ab_channel=ProgrammingKnowledge)
  - For Ubuntu OS: Run the following command or you can follow the steps in this site [MySQL Installation Guide](https://phoenixnap.com/kb/install-mysql-ubuntu-20-04)
    ```console
    sudo apt install mysql-server
    ```
    - MySQL workbench Installation
      ```console
      sudo apt install mysql-workbench-community
      ```
  - Check if MySQL was successfully installed by running:
    ```console
    mysql --version
    ```
    
#### Node.js Installation
  - For Windows OS Visit : https://nodejs.org/en/download/
  - For Ubuntu OS: Run the following command
    ```console
    sudo apt-get install nodejs
    ```
  - Verify the version installed
    ```console
    node --version
    ```
  
#### Angular CLI Installation
  - Run the following command
    ```console
    npm install -g @angular/cli
    ```
    - Verify the version installed
    ```console
    ng version
    ```
  
#### IDE Installation
  - Eclipse [Link](https://www.eclipse.org/downloads/packages/release/kepler/sr2/eclipse-ide-java-ee-developers)
  - Intellij [Link](https://www.jetbrains.com/idea/download)

## Possible Error and solutions
*If you get error shown below when running front end server
  ```console
  Could not find module "@angular-devkit/build-angular"
  ```
    To fix the issue run the following command
     ```console
    npm update
    ```
    OR
    ```console
    npm install --save-dev @angular-devkit/build-angular
    ```
 
