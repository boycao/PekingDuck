package edu.washington.bycao96.pekingduck

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val layout : LinearLayout = findViewById(R.id.layout)
    val editText: EditText = findViewById(R.id.editText)
    val addBtn: Button = findViewById(R.id.button)
    val startBtn:Button = findViewById(R.id.btnStart)
    val stopBtn : Button = findViewById(R.id.btnStop)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Disable all the btn at the initial setup
        addBtn.isEnabled = false
        startBtn.isEnabled = false
        stopBtn.isEnabled = false
    }

    override fun onStart() {
        var content:String
        super.onStart()
        // Set a listener on the editText box
        editText.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(!editText.text.isNullOrBlank())
                    editText.removeTextChangedListener(this)
                 content = s.toString()
            }

            override fun afterTextChanged(s: Editable?) {
                addBtn.isEnabled = true
                startBtn.isEnabled = true
                stopBtn.isEnabled = true
            }
        })
        //Set a listener to the addBtn and add the content to the scroll panel
        addBtn.setOnClickListener(){
            layout.addView(createNewTextView(content))
        }

    }
    /*
        Setup the new textview in the scrollpanel
     */
    private fun createNewTextView(newContent:String){
         val newTextView :TextView?
         newTextView.setText(newContent)
    }




}
