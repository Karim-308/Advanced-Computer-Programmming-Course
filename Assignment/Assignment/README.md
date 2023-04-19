# Readme

This Java program reads an AUTOSAR XML file with the extension `.arxml`, extracts the data from the `<CONTAINER>` elements, sorts them alphabetically by the `Short-Name` element, and writes them to a new file with the name `<original_file_name>_mod.arxml`.

## Requirements

- Java 8 or higher

## Usage

To run the program, use the following command:

```
java App <filename>
```

where `<filename>` is the path to the input file.

The output file will be saved in the same directory as the input file with the name `<original_file_name>_mod.arxml`.

## Exceptions

The program will throw three types of exceptions:

- `IllegalArgumentException` if no filename is passed as an argument.
- `NotValidAutosarFileException` if the input file is not a valid AUTOSAR file (i.e., the file extension is not `.arxml`).
- `EmptyAutosarFileException` if the input file is an empty file.

## Class Structure

### Container

The `Container` class represents the data fields of each `<CONTAINER>` element in the input file. It implements the `Comparable` interface to allow sorting the containers based on their `Short-Name`.

### EmptyAutosarFileException and NotValidAutosarFileException

These are custom exceptions that extend `RuntimeException` and `Exception`, respectively. They are used to handle input file-related errors.

### App

This is the main class that reads the input file, extracts the `<CONTAINER>` elements, sorts them, and writes them to the output file. It also contains the helper methods that extract the data fields of each container and the method to count the number of containers in the input file.
