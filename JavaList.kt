package com.vinti.quizapplication.content

class JavaList : Data{

    override var questions = arrayOf(
        "Who Developed Java Language?",
        "What is used for printing in Java?",
        "Purpose of Scanner in Java?",
        "Default imported package in Java ",
        "substring() is available in class: "
    )

    override var options = arrayOf(
        "Dennis Ritchie", "James Gosling", "Jet Brains", "Ryan Dahl",
        "print()","printf()", "print()", "System.out.println()",
        "scan integer data", "scan string values", "take user input", "scan result",
        "java.util.*", "java.lang.*", "java.awt.*", "java.*",
        "String", "System", "Substring", "StringBuilder")

    override var answers = arrayOf(
        "James Gosling",
        "System.out.println()",
        "take user input",
        "java.lang.*",
        "String"
    )
}