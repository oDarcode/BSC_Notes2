package ru.dariamikhailukova.notes.view

import android.content.Intent

interface View {
    fun initView()
    fun updateViewData()
    fun showToast(resId: Int)
    fun sendIntent(intent: Intent)
}
