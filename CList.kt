package com.vinti.quizapplication.content

class CList : Data{

    override var questions = arrayOf(
        "Who Developed C Language?",
        "What is used for printing in C?",
        "Purpose of scanf in C?",
        "Extension for header file in C is : ",
        "strcpy() is defined in : "
    )

   override var options = arrayOf(
        "Dennis Ritchie", "James Gosling", "Jet Brains", "Ryan Dahl",
        "printdata()","printf()", "print()", "ffprintf()",
        "scan integer data", "scan string values", "take user input", "scan result",
        ".ht", ".hx", ".hed", ".h",
        "string.h", "stdio.h", "conio.h", "ctype.h")

    override var answers = arrayOf(
        "Dennis Ritchie",
        "printf()",
        "take user input",
        ".h",
        "string.h"
    )

}