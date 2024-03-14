# XMLAlchemy

XMLAlchemy is a command line tool that can be used to parse XML files and evaluate queries. It supports the following operations:
1. Evaluate XPath expressions.
2. Evaluate XQuery expressions.
3. Rewrite certain class of XQuery expressions and optimize its evaluation.

## Setup

1. `mvn clean install -U` to install the dependencies.
2. `mvn clean package` to package the project and create the jar file.
3. `java -jar target/xmlalchemy-1.0.0.jar --help` to run the program.

## Authors

1. [Mayank Jain](https://jainmayank.me)
2. [Jonathan Woenardi](https://github.com/jonathanwoenardi)

## Architecture

### Directory Structure

```plaintext
├── main                                   # Main source code
│   ├── antlr4                             # ANTLR4 grammar files
│   │   └── edu/ucsd/xmlalchemy
│   ├── java
│   │   └── edu/ucsd/xmlalchemy            # Main package
│   │                ├── xpath             # Classes for XPath expressions
│   │                ├── xquery            # Classes for XQuery expressions
│   │                ├── Expression.java   # Interface which all other expressions implement
│   │                ├── Formatter.java    # Format XQuery expressions
│   │                ├── Optimizer.java    # Rewrite and optimize XQuery expressions
│   │                ├── Visitor.java      # Parses query and constructs IR/expressions
│   │                ├── XPath.java        # XPath CLI
│   │                └── XQuery.java       # XQuery CLI
│   └── resources/style.xslt               # Style file for formatting XML output
├── test                                   # Test source code
│   ├── java
│   │   └── edu/ucsd/xmlalchemy            # Main package
│   └── resources
│        └── milestone{1,2,3}              # Test cases for each milestone
│           ├── document                   # XML files
│           ├── input                      # Input queries
│           └── output                     # Expected output and rewritten queries
├── README.md                              # This file
└── pom.xml                                # Maven configuration file
```

### Program Flow

![Program Flow](./docs/Architecture.png)

## Highlights

1. Internal representation for all kinds of XQuery constructs which provides modularity, extensibility, and rewriting without string manipulation.
2. Implement Wong-Youseffi algorithm for join order optimization.
3. Optimize hash-based join by choosing the smaller table to build the hash table.
4. Cache file reads for better performance.
5. Implement custom serializer and formatter for XQuery queries.
6. CLI for evaluating XPath and XQuery expressions with support for output and optimize flags.
7. Maven project setup for dependency management and build automation.
8. 100% test coverage powered by a comprehensive and fully-automated test suite with ~100 test cases testing evaluation, serialization and query rewriting.
9. Actively asking and answering questions on Piazza and helping other students with their queries.
