package ru.dariamikhailukova.notes.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ru.dariamikhailukova.notes.R
import ru.dariamikhailukova.notes.presenter.MainActivityPresenter

class MainActivityView: AppCompatActivity(), View {
    private var presenter: MainActivityPresenter? = null

    private lateinit var titleView: EditText
    private lateinit var textView: EditText
    private lateinit var saveButton: Button
    private lateinit var shareButton: Button
    private lateinit var aboutButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainActivityPresenter(this)
    }

    override fun initView(){
        titleView = findViewById(R.id.nameNote)
        textView = findViewById(R.id.textNote)
        saveButton = findViewById(R.id.buttonSave)
        shareButton = findViewById(R.id.buttonShare)
        aboutButton = findViewById(R.id.buttonAbout)

        saveButton.setOnClickListener {
            presenter?.readNote(
                titleView.text.toString(),
                textView.text.toString()
            )
        }

        aboutButton.setOnClickListener {
            val intent = Intent(this, AboutActivityView::class.java)
            startActivity(intent)
        }

        shareButton.setOnClickListener {
            presenter?.sendEmail()
        }
    }

    override fun sendIntent(intent: Intent) {
        startActivity(Intent.createChooser(intent, "Choose from..."))
    }

    override fun updateViewData(){
        findViewById<EditText>(R.id.nameNote).setText("")
        findViewById<EditText>(R.id.textNote).setText("")
    }

    override fun showToast(resId: Int) {
        Toast.makeText(this, resId, Toast.LENGTH_SHORT).show()
    }
}