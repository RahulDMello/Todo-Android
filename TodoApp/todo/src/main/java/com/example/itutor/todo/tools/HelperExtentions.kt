package com.example.itutor.todo.tools

fun String.toColorInt(): Int {
    return this.toLong(16).toInt()
}