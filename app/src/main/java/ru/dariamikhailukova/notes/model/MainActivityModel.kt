package ru.dariamikhailukova.notes.model
import ru.dariamikhailukova.notes.contract.ContractInterface.*

class MainActivityModel: Model {
    private var name: String = ""
    private var text: String = ""

    override fun setName(name: String){ this.name = name }

    override fun setText(text: String){ this.text = text }

    override fun getName(): String{ return this.name }

    override fun getText(): String{ return this.text }

}