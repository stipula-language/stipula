# Stipula Prototype

Stipula is a domain specific language that may assist legal practitioners in programming legal contracts through specific patterns.
In this repository, we uploaded the prototype and some examples.

## Description

The prototype is a Java application. The development has taken three months and ~3000 lines of Java code. 
We have committed to the ANTLR tool.

## Getting Started

### Dependencies

* The prototype requires a Java version > 8.

### Installation

There are two possibilities:
* It is possible to install the source code (folder Stipula-LAN) with the Grammar and the parser 
* It is possible to download and run the jar of the prototype


#### How to install the source code

##### Requirements:
* Java > 8
* ANTLR > 4.4

##### Instructions:
* Download the zip
* Import the grammar file (Stipula.g4) in the IDE
* Compile with ANTLR and generate the Parser, Visitor, Listener
* Import the rest of the project (package src)

#### How to run the jar

* After downloading the zip, go to the correct folder (./Stipula Executable)
* To run the prototype type the following code
```
java -jar Stipula-LAN.jar name_of_the_example.stipula
```
 
### Execution

* When the prototype starts, it displays the type inference 
* Then the agreement starts and displays a unique code for each party of the contract (see example below)
```
--------------------
Lender ef6h4
Borrower MHWBs
Authority gxhZZ
--------------------
```
* The prototype asks the user to insert these codes and the values for some variables
* Then it shows which functions can start, for instance:
```
# Please, choose which function should run: 
	Lender.offer(Type3 x)[]
```
* The user must call the desired function by inserting the corresponding party's code and the values for the formal parameters
* For instance, if the lender wants to call the function offer with x=10:
```
	ef6h4.offer(10)[]
```
* Then the prototype executes the body of the chosen function and the execution continues
