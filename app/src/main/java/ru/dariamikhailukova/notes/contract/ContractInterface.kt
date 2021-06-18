package ru.dariamikhailukova.notes.contract

interface ContractInterface {
    interface View {
        fun initView()
        fun updateViewData()
        fun getNoteName(): String
        fun getNoteText(): String
        fun showToast(resId: Int)
    }

    interface Presenter {
        fun readNote()
        //fun getText(): String
    }

    interface Model {
        fun getName(): String
        fun getText(): String
        fun setName(name: String)
        fun setText(text: String)
    }
}