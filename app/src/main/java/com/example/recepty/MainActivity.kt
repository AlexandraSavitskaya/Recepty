package com.example.recepty

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
//Класс MainActivity,наследник AppCompatActivity
class MainActivity : AppCompatActivity() {
    //Метод onCreate - запускается при старте приложения самым первым
    //Создает объекты пользовательского интерфейса для показа пользователю
    override fun onCreate(savedInstanceState: Bundle?) {
        //Вызов родительского метода
        super.onCreate(savedInstanceState)
        //Игнорирование системных рамок
        enableEdgeToEdge()
        //Определяет то, как будет выглядеть экран
        //Содержит ссылку на файл activity.main.xml
        setContentView(R.layout.activity_main)
        //Задание отступов для элементов попльзовательского интерфейса
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    //Метод onStart - запускается после onCreate
    //Подготавливает пользовательский интерфейс к показу пользователю
    override fun onStart() {
        super.onStart()
    }
    //Метод onResume запускается после onStart, либо после onPause
    //Демонстрирует пользователю интерфейс активности
    //После его вызова пользователь может взаимодействовать с интерфейсом
    override fun onResume() {
        super.onResume()
    }
    //Метод onPause запускается после onResume
    //Готовит активность к переходу в спящий режим, перезапуску или возобновлению работы
    override fun onPause() {
        super.onPause()
    }
    
}