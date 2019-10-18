package com.example.itutor.todo.tools

import androidx.lifecycle.MutableLiveData

fun String.toColorInt(): Int {
    return this.toLong(16).toInt()
}

fun <E> MutableLiveData<MutableList<E>>.add(item: E) {
    val value: MutableList<E> = (this.value ?: mutableListOf()).apply { add(item) }
    this.value = value
}