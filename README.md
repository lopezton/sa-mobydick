# Moby Dick

## About
This repository holds the source for a programming I am doing for a technical showcase.

**Problem Statement**  
> Pick any programming language of your choice and test-drive creating a list of the top 100 most frequently occurring words (excluding stop words) paired with the count of occurrences of the word, found in the attached text for Herman Melville's book Moby Dick.  Please share your code, including a README, by pushing to your GitHub account and sharing the repository link with us.  Please do not squash your commit history as we would like to view your commits to understand how you progressed towards your solution.

## Building the Project
The project is built with Maven, but `mvnw` is supplied if you don't want to install Maven. The following instructions will show how to build an executable `.jar` file.

### Prerequisites
Please be sure to have the following installed:  

* Java 8

<i>Note: Newer versions may work, but the versions listed above are what have immediately been tested.</i>

### Execute a Build
Execute the following from the project root directory:
```sh
./mvnw clean install
```

## Usage
After executing a successful build, execute the following from the project root directory:

```sh
java -jar target/moby-dick.jar
```

**Help**  
```sh
Usage: moby-dick.jar TEXT_FILE_PATH [STOP_WORD_FILE_PATH]

Count and display the number of words in the given file.

TEXT_FILE_PATH
    The file path to the text file to read. All text will be read and considered for word count with the exception of spaces and punctuation.

[STOP_WORD_FILE_PATH]
    The file path to a text file containing stop words, one per line. A stop word is a word that will essentially be ignored when reading TEXT_FILE_PATH and will not be considered in the final count.
```

**Examples**  
```sh
java -jar target/moby-dick.jar "src/test/resources/count-words-test-1.txt" "src/test/resources/count-words-stop-test-1.txt"

...
malesuada: 1
amet: 1
ipsum: 1
elit: 1
consectetur: 1
```

## Developer Setup
The following instructions will instruct developers on how to setup a working development environment.

### Prerequisites
Please be sure to have the following installed:  

* Java 8
* Eclipse Photon

<i>Note: Newer versions may work, but the versions listed above are what have immediately been tested.</i>

## Testing Information
This project uses JUnit 5 for unit testing.

### Executing the Tests
Execute the following from the project root directory:
```sh
./mvnw clean test
```