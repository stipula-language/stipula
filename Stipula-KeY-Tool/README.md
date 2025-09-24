# Stipula KeY Tool

## Overview

The Stipula-KeY-Tool is a software verification tool designed to formally prove the correctness of Stipula contracts. It integrates with the [KeY Project](https://www.key-project.org/), a powerful and well-established formal verification tool for Java programs.

This tool is designed to analyze contracts written with Stipula after translating them into Java and equipping them with specifications in the Java Modeling Language (JML). It allows users to perform deductive verification to ensure that the software behaves exactly as specified and is free of certain types of errors.

## Features

* **Formal Verification:** Leverages the power of the KeY prover to formally verify program correctness.
* **JML Integration:** Likely uses the Java Modeling Language (JML) for specifying program contracts and properties.

## Usage

There are two ways to use the Stipula-KeY-Tool: running the pre-compiled JAR file or building the project from source.

### Option 1: Running the Pre-compiled JAR (Recommended)

This is the easiest way to get started. The repository includes a ready-to-use JAR file (`key-stipula.jar`).

1.  **Download the repository or just the `Java-Translator.jar` and the `examples` folder.**
2.  **Run the tool from your terminal.** You can test the tool with the provided examples. From the `Stipula-KeY-Tool` directory, run the following command:

    ```bash
    java -jar Java-Translator.jar <path-to-example-file>
    ```

    For instance:

    ```bash
    java -jar Java-Translator.jar examples/Deposit.stipula
    ```

### Option 2: Building from Source

If you want to modify the code or build the project yourself, you can compile it from the source files located in the `code` directory.

#### Prerequisites

* **Java Development Kit (JDK):** Version 8 or higher.
* **Apache Maven:** A build automation tool for Java projects.

#### Build Steps

1.  **Clone the repository:**

    ```bash
    git clone [https://github.com/stipula-language/stipula.git](https://github.com/stipula-language/stipula.git)
    ```

2.  **Navigate to the project directory:**

    ```bash
    cd stipula/Stipula-KeY-Tool
    ```

3.  **Build the project using Maven:**

    ```bash
    mvn clean install
    ```

    This command will automatically use **ANTLR** to generate the necessary parser files from the grammar, compile the source code, run tests, and package the application into a new `.jar` file in the `target/` directory.

