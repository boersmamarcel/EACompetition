#!/bin/sh
javac player39.java  -classpath "./:resources/contest.jar"
jar -cf submission.jar player39.class evo/Child.class evo/EvoAlgorithm.class evo/Population.class evo/combination/Combination.class evo/combination/Singlepoint.class evo/combination/Simple.class evo/combination/Blend.class evo/mutation/Mutation.class evo/mutation/Uniform.class evo/selection/parent/Parent.class evo/selection/parent/FitnessProportional.class evo/selection/parent/UniformSelection.class evo/selection/survivor/Survivor.class evo/selection/survivor/Elitism.class 
cp submission.jar test/
cd test/
java -jar testrun.jar -submission=player39 -evaluation=SphereEvaluation -seed=1
rm submission.jar
cd ..
rm player39.class
