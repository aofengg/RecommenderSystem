javac: *.java
	javac *.java
clean: *.class
	rm *.class
run: Driver.class
	java Driver
