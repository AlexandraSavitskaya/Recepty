package com.example.recepty

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
//Класс MainActivityViewModel, насоедник системного класса ViewModel
//Имеет доступ к жизненному циклу ViewModel
class MainActivityViewModel: ViewModel() {
    //Свойство, которое имеет тип данных MutableLiveData
    private val editText= MutableLiveData<String>()
    fun getEditText(): MutableLiveData<String> = editText
}