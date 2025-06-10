package com.example.recepty

import android.os.Bundle
import android.view.inputmethod.InputBinding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.recepty.databinding.ActivityInputBinding
import com.example.recepty.databinding.ActivityMainBinding

class InputActivity : AppCompatActivity() {
    //Binding для работы с InputActivity
    private lateinit var inputBinding: ActivityInputBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //Инициализация свойства activityMainBinding
        inputBinding = ActivityInputBinding.inflate(layoutInflater)

        //inputBinding = ActivityInputBinding.inflate(layoutInflater)
        //inflate(layoutInflater)
        setContentView(inputBinding.root)
        //Установка слушателя нажатий на кнопку


    }
}