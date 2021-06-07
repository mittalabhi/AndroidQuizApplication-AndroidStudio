package com.vinti.quizapplication.controller

import com.vinti.quizapplication.content.CList
import com.vinti.quizapplication.content.Data
import com.vinti.quizapplication.content.JavaList

class Factory {

    fun passData(name : String) : Data? {

        if(name == "C"){
           // var cList = CList()
            return CList()
        }
        else if(name == "Java")
        {
            return JavaList()
        }
        return null
    }

}