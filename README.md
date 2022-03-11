# ACME IOET

The company ACME offers their employees the flexibility to work the hours they want. But due to some external circumstances they need to know what employees have been at the office within the same time frame.

### Requirements 📋
The goal of this exercise is to output a table containing pairs of employees and how often they have coincided in the office.
Input: the name of an employee and the schedule they worked, indicating the time and hours. This should be a .txt file with at least five sets of data.

### Example

INPUT
- RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00                                                              
- ASTRID=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00
- ANDRES=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00

OUTPUT
- ASTRID-RENE: 2
- ASTRID-ANDRES: 3
- RENE-ANDRES: 2

### Steps to run the program 🔧

1. Open CMD, and use the javac command, if the cmd displays options we can go to the next step, if this don't work we need to add java jdk to the systems variables.
2. Change the directory of CMD to the src directory and use the next command 
```
javac Employee.java
```
4. Now we can run the program with the following command 
```
java Employee \Data\AcmeData.txt
```

## Builded with 🛠️

Java 1.8

## Author ✒️

Eddie Verdesoto - https://www.linkedin.com/in/eddie-verdesoto/
