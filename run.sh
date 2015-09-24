#!/bin/sh
javac player39.java  -classpath "./:resources/contest.jar"
jar -cf submission.jar player39.class evo/child.class
cp submission.jar test/
cd test/
java -jar testrun.jar -submission=player39 -evaluation=SphereEvaluation -seed=1
rm submission.jar
cd ..
rm player39.class
