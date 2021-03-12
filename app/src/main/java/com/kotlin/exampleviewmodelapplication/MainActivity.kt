package com.kotlin.exampleviewmodelapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    lateinit var viewModel : TextViewModelView
    lateinit var myTextView : TextView
    lateinit  var textViewBoolean : TextView
    lateinit var viewNotViewModel : TextView
    var a : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        a =0
        viewModel = ViewModelProvider(this).get(TextViewModelView::class.java)
        increamentText()
        viewModel.currentNubmer.observe(this, Observer {
            myTextView.setText(viewModel.currentNubmer.value.toString())
            textViewBoolean.text ="Hello"

        })

        viewModel.currentBoolean.observe(this, Observer {
            textViewBoolean.text =  viewModel.currentBoolean.value.toString()
        })

        increamentText()
    }

    private fun increamentText()
    {
        var button = findViewById(R.id.button) as Button
        myTextView = findViewById(R.id.mytestview) as TextView
        textViewBoolean =  findViewById(R.id.textView) as TextView
        viewNotViewModel = findViewById(R.id.viewNotViewModel) as TextView

        var a : Int = 0
        button.setOnClickListener(View.OnClickListener {
            viewModel.currentNubmer.value = ++viewModel.number
            viewModel.currentBoolean.value = viewModel.number % 2 == 0
            viewNotViewModel.setText("Hello"+a++)

         })


    }
}