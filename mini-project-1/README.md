# Mini Project 1

## Overview

This is a simple Java program that prompts the user to enter a review, processes it to count vowels, and displays the breakdown of vowels per word along with the total count. The program ensures that the review is not empty and provides feedback if it is.

Furthermore, the `S1557984AlanHuynh.java` is the submission version with unreadable variable name, `App.java` is the original version.

## Features

- User Input Handling: Prompts the user to enter a review and ensures that the input is not empty.
- Vowel Counting: Calculates the number of vowels in each word of the review and provides a detailed breakdown.
- Error Handling: Limits the number of invalid attempts to enter a review and exits gracefully if the limit is reached.

## Requirements

- Java Development Kit (JDK): OpenJDK 21.0.4.7 or compatible version.
- Operating System: Fedora 34 (or any system that supports the required JDK version).

## Installation

- Ensure you have JDK 21 installed. You can install OpenJDK 21 on Fedora 34 using:

```bash
    sudo dnf install java-21-openjdk
```

- Clone or download the repository containing the S1557984AlanHuynh Java file

```bash
    git clone https://github.com/alan191006/MelbPoly_BIT111
```

- Navigate to the directory containing the file

```bash
    cd /path/to/your/project
```

- Compile the Java program

```bash
    javac src/S1557984AlanHuynh.java
```

- Run the program

```bash
    java src/S1557984AlanHuynh
```

### Usage

When prompted, enter your review text.
The program will display a breakdown of vowels in each word and the total count of vowels.

### Code Explanation

#### `main` Method

- Initializes a Scanner to read user input.
- Use the scanner to read user input
- Handles empty input with a tolerance of 5 attempts.
- Calls `calculateVowels()` to process the review and prints the result.

#### `calculateVowels` Method

- Splits the input text into words.
- Counts the vowels in each word and appends the count to a breakdown string.
- Returns a string showing the detailed vowel count breakdown.

#### `isVowel` Method

- Checks if a character is a vowel (A, E, I, O, U; both lower and upper case).

### Example

```bash
    Welcome to Alan's North Melbourne Web!
    Please enter your review: I dont know if this will work or not... really
    1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 2 = 11
```

### Error Handling

- If an empty review is entered, the user will be prompted to try again.
- After 5 invalid attempts, the program will exit with an error message.

## Contributing

If you wish to contribute to this project, please fork the repository and submit a pull request with your changes. Ensure that your code adheres to the project's style guidelines and is thoroughly tested.

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Contact

For any questions or issues, please contact Alan Huynh at [s1557984@student.mp.edu.au](mailto:s1557984@student.mp.edu.au).

Illegal plug for my own website [northmelbourneweb.com](https://northmelbourneweb.com) :D
