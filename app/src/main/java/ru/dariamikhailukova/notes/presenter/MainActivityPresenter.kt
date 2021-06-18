package ru.dariamikhailukova.notes.presenter
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
        view.showToast(R.string.saved);
        view.updateViewData()
    }

}