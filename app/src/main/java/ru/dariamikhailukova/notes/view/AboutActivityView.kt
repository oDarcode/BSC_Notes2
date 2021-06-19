package ru.dariamikhailukova.notes.view

import android.app.Activity
import android.os.Bundle
import ru.dariamikhailukova.notes.R


class AboutActivityView: Activity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
    }
}