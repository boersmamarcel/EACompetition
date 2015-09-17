#!/bin/sh

javac submission.java -classpath resources/contest.jar
jar -cf submission.jar submission.class
mv submission.jar test/
cd test/
java -jar testrun.jar -submission=submission -evaluation=SphereEvaluation -seed=1
rm submission.jar
cd ..
rm submission.class
