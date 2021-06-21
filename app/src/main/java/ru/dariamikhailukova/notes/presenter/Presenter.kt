package ru.dariamikhailukova.notes.presenter

interface Presenter {
    fun readNote(name: String, text: String)
    fun sendEmail()
}