# DU1 - Exercise 2 - Java Runtime Class - RuntimeBirthday

This exercise builds on the Java `Runtime` class, focusing on launching a JAR file encapsulated in the project and simulating various cases using random numbers. The goal is to run the `Birthday` argument program multiple times and check the correctness of the execution.

## Tasks

The following tasks are required to complete the exercise:

1. **Place the JAR file**:
    - Place the JAR file generated from the Birthday project into the `resources` folder of this new project.

2. **Use `java.util.Random`**:
    - Use `Random` to generate a random number that determines how many times the `Birthday` program will be executed.
    - Each case should use randomly generated inputs.

3. **Launch the JAR file using the `Runtime` class**:
    - Use `Runtime.getRuntime().exec()` to execute the JAR file with randomly generated arguments.

4. **Display execution results**:
    - Capture and display a message in the standard output informing the user whether the execution of the Birthday argument program was successful or not.

### Execute Jar
java -cp `jarPath`  `className`

java -cp .\src\main\resources\BasicBirthday-1.0-SNAPSHOT.jar org.example.main  