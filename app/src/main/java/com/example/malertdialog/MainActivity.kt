package com.example.malertdialog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val alertBtn = findViewById<Button>(R.id.alertBtn)

        alertBtn.setOnClickListener {
            customAlert()
        }
    }

    private fun customAlert() {

        val dialog = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.alert_dialog, null)
        dialog.setView(dialogView)

        val edText = dialogView.findViewById<EditText>(R.id.edText)
        val tvText = dialogView.findViewById<TextView>(R.id.textView2)
        val tvBtn = dialogView.findViewById<Button>(R.id.tvBtn)
        val goBtn = dialogView.findViewById<Button>(R.id.goBtn)
        val cancelBtn = dialogView.findViewById<Button>(R.id.cancelBtn)


        tvBtn.setOnClickListener {
            tvText.text = edText.text.toString()
        }

        goBtn.setOnClickListener {
            startActivity(
                Intent(this, MainActivity2::class.java)
                    .putExtra("data", edText.text.toString())
            )
        }

        cancelBtn.setOnClickListener{
            Intent(this, MainActivity::class.java)
//                IDK how to get cancel in this case, I try with more way
        }

        dialog.show()

    }
}