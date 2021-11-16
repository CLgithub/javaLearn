javac -d . src/day01_add/Demo1.java
touch Mainfest.txt
jar cvfme my.jar Mainfest.txt day01_add/Demo1 day01_add/Demo1.class
rm Mainfest.txt
