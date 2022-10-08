package com.example.awaistrail.utils

import com.google.gson.Gson
import java.util.regex.Matcher
import java.util.regex.Pattern

object Helper {

    fun jsonToAny(`object`: Any?, type: Class<*>): Any? {
        if (`object` == null)
            return null
        val gsn = Gson()
        var gsnString = gsn.toJson(`object`)
        var any: Any?
        val clazz = type.javaClass
        if (`object` is ArrayList<*>) {
            val objects = ArrayList<Any>()
            for (objectA in (`object` as ArrayList<*>?)!!) {
                gsnString = gsn.toJson(objectA)
                any = gsn.fromJson<Any>(gsnString, type)
                objects.add(any)
            }
            return objects
        } else {
            any = gsn.fromJson<Any>(gsnString, type)
        }
        return any
    }

    fun isValidHexaCode(str: String?): Boolean {
        // Regex to check valid hexadecimal color code.
        val regex = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$"

        // Compile the ReGex
        val p: Pattern = Pattern.compile(regex)

        // If the string is empty
        // return false
        if (str == null) {
            return false
        }

        // Pattern class contains matcher() method
        // to find matching between given string
        // and regular expression.
        val m: Matcher = p.matcher(str)

        // Return if the string
        // matched the ReGex
        return m.matches()
    }

}