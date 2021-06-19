package ru.dariamikhailukova.notes.presenter
import android.content.Intent
import android.text.TextUtils
import ru.dariamikhailukova.notes.R
import ru.dariamikhailukova.notes.contract.ContractInterface.*
import ru.dariamikhailukova.notes.model.MainActivityModel


class MainActivityPresenter(_view: View):Presenter {
    private var view: View = _view
    private var model: Model = MainActivityModel()

    init {
        view.initView()
    }

    override fun readNote(){
        if(TextUtils.isEmpty(view.getNoteName()) || TextUtils.isEmpty(view.getNoteText())){
            view.showToast(R.string.emptyValue)
            view.updateViewData()
            return
        }

        model.setName(view.getNoteName())
        model.setText(view.getNoteText())
        view.showToast(R.string.saved)
        view.updateViewData()
    }

    override fun sendEmail() {
        if(TextUtils.isEmpty(model.getName()) || TextUtils.isEmpty(model.getText())){
            view.showToast(R.string.emptyError)
            view.updateViewData()
            return
        }

        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_SUBJECT, model.getName())
            putExtra(Intent.EXTRA_TEXT, model.getText())
            type = "text/plain"
        }
        view.sendIntent(sendIntent)
    }

}