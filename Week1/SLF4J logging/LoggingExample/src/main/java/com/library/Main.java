package com.library;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; //logger is basically used to log the output of code instead os just printing the output using system.out.println

public class Main {

    private static final Logger logger =
            LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.error("This is an error message");
        logger.warn("This is a warning message");
    }
}

//definition : SLF4J (Simple Logging Facade for Java) is a logging API that provides a common interface for various Java logging frameworks, allowing developers to write logging code independent of the underlying logging implementation.

//defendency code for Logger: <dependency>
//            <groupId>org.slf4j</groupId>
//            <artifactId>slf4j-api</artifactId>
//            <version>1.7.30</version>
//        </dependency>
//
//        <dependency>
//            <groupId>ch.qos.logback</groupId>
//            <artifactId>logback-classic</artifactId>
//            <version>1.2.3</version>
//        </dependency>