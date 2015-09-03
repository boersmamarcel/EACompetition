Run the following commands
```
javac mysubmissionfile.java -classpath resources/contest.jar
```
then make a jar file
```
 jar -cf submission.jar mysubmissionfile
 ```

*Optional*: test run (run all in test directory)
Don't forget to move your submission jar file to the test directory
```
java -jar testrun.jar -submission=mysubmissionfile -evaluation=EvaluationFile -seed=1
```
