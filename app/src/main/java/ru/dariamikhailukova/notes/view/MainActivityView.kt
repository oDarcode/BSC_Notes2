package ru.dariamikhailukova.notes.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ru.dariamikhailukova.notes.contract.ContractInterface.*
import ru.dariamikhailukova.notes.databinding.ActivityMainBinding
import ru.dariamikhailukova.notes.presenter.MainActivityPresenter

class MainActivityView: AppCompatActivity(), View {
    private lateinit var binding: ActivityMainBinding
    private var presenter: MainActivityPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = MainActivityPresenter(this)
    }

    override fun initView(){
        binding.buttonSave.setOnClickListener {
            presenter?.readNote()
        }

        binding.buttonAbout.setOnClickListener {
            val intent = Intent(this, AboutActivityView::class.java)
            startActivity(intent)
        }

        binding.buttonShare.setOnClickListener {
            presenter?.sendEmail()
        }

    }

    override fun sendIntent(intent: Intent) {
        startActivity(Intent.createChooser(intent, "Choose from..."))
    }

    override fun updateViewData(){
        binding.nameNote.setText("")
        binding.textNote.setText("")
    }

    override fun getNoteName(): String{
        return binding.nameNote.text.toString()
    }

    override fun getNoteText(): String{
        return binding.textNote.text.toString()
    }

    override fun showToast(resId: Int) {
        Toast.makeText(this, resId, Toast.LENGTH_SHORT).show()
    }

}