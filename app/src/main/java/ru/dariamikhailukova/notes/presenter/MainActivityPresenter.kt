package ru.dariamikhailukova.notes.presenter
import android.content.Intent
import android.text.TextUtils
import ru.dariamikhailukova.notes.R
import ru.dariamikhailukova.notes.view.View
import ru.dariamikhailukova.notes.model.MainActivityModel

class MainActivityPresenter(_view: View):Presenter {
    private var view: View = _view
    private var model: MainActivityModel = MainActivityModel("","")

    init {
        view.initView()
    }

    override fun readNote(name: String, text: String){
        if(TextUtils.isEmpty(name) || TextUtils.isEmpty(text)){
            view.showToast(R.string.emptyValue)
            view.updateViewData()
            return
        }

        model = MainActivityModel(name,text)
        view.showToast(R.string.saved)
        view.updateViewData()
    }

    override fun sendEmail() {
        if(TextUtils.isEmpty(model.name) || TextUtils.isEmpty(model.text)){
            view.showToast(R.string.emptyError)
            view.updateViewData()
            return
        }

        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_SUBJECT, model.name)
            putExtra(Intent.EXTRA_TEXT, model.text)
            type = "text/plain"
        }
        view.sendIntent(sendIntent)
    }
}