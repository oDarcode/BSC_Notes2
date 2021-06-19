package ru.dariamikhailukova.notes.contract

import android.content.Intent

interface ContractInterface {
    interface View {
        fun initView()
        fun updateViewData()
        fun getNoteName(): String
        fun getNoteText(): String
        fun showToast(resId: Int)
        fun sendIntent(intent: Intent)
    }

    interface Presenter {
        fun readNote()
        fun sendEmail()
        //TODO: добавить метод считывания данных из модели
    }

    interface Model {
        fun getName(): String
        fun getText(): String
        fun setName(name: String)
        fun setText(text: String)
    }
}