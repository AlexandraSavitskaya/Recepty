package com.example.recepty

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.recepty.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    //Binding MainActivity
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
    }


//Класс MainActivity,наследник AppCompatActivity
/*class MainActivity : AppCompatActivity() {
    //Свойство, которое хранит информацию о том, было ли показано всплывающее сообщение пользователю
    private var showToast = false

    //Метод,который будет срабатывать при нажатии на кнопку через xml-параметр onClick
    fun buttonClick(view: View) {
        Toast.makeText(this, "Вы нажали на кнопку через xml макет", Toast.LENGTH_SHORT).show()
    }

    //Свойство для использования библиотеки viewBuinding
    private lateinit var activityMainBinding: ActivityMainBinding

    //Свойство,отвечающее за работу с ViewModel
    private lateinit var mainActivityViewModel: MainActivityViewModel



    //Метод onCreate - запускается при старте приложения самым первым, либо после вызова onPause
    //Создает объекты пользовательского интерфейса для показа пользователю
    override fun onCreate(savedInstanceState: Bundle?) {
        //Вызов родительского метода
        super.onCreate(savedInstanceState)

        //Инициализация свойства activityMainBinding
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)

        //Инициализация MainActivityViewModel
        val viewModelProvider = ViewModelProvider(this)
        mainActivityViewModel= viewModelProvider[MainActivityViewModel::class.java]

        //Присвоение свойству showToast значения из Bundle-хранилища с ключом SHOW_TOAST
        if (savedInstanceState != null)
            showToast = savedInstanceState.getBoolean("SHOW_TOAST")

        //Игнорирование системных рамок
        enableEdgeToEdge()


        //Определяет то, как будет выглядеть экран
        //Содержит ссылку на файл activity.main.xml
        setContentView(R.layout.activity_main)

        //Аналог вызова setContentView с использованием viewBinding
        setContentView(activityMainBinding.root)

        //Задание отступов для элементов попльзовательского интерфейса
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        /*Verbose - полный протокол системных действий.

Debug - отладочная информация: параметры,порождаемые в процессе работы приложения.
Info - информационные сообщения.
Warn - предупреждения.
Error - ошибки, возникающие в процессе работы приложения. В протоколе выделяются красно-коричневым цветом, чтобы их было сразу заметно.
Assert - предложения, введённые в программу программистом для отслеживания состояний выполнения.
*/
        //Логирование сообщений
        Log.i("Метод жизненного цикла", "onCreate")
        //Проверка того, было ли показано сообщение пользователю
        if (!showToast && savedInstanceState == null) {
            //Всплывающее сообщение
            Toast.makeText(this, "Привет, пользователь", Toast.LENGTH_SHORT).show()
            showToast = true
        }

        //Создание объектов пользовательского интерфейса в коде
        val textView: TextView = findViewById(R.id.textView)
        val textView2: TextView = findViewById(R.id.textView2)
        val button: Button = findViewById<Button>(R.id.button)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val editText = findViewById<EditText>(R.id.editTextText)

        //Работа с объектами пользовательского интерфейса в коде
        //Замена текста в TextView
        textView.text = "Hello"
        textView.setText("New text")
        //Слушатель нажатий в TextView
        textView.setOnClickListener {
            textView.text = "New text"
        }
        //Замена текста в Button
        button.text = "Click me"

        //Слушатель нажатий в Button
        button.setOnClickListener {
            Toast.makeText(this, "Кнопка нажатий", Toast.LENGTH_SHORT).show()
            button.text = "You click!"
        }
        //Слушатель удержания кнопки
        button.setOnLongClickListener {
            button.text = "Long click!"
            return@setOnLongClickListener true
        }
        //Использование объекта activityMainBinding для взаимодействия с элементами пользовательского интерфейса
        //Смена текста в поле для ввода текста
        activityMainBinding.editTextText.setText("New text in edit text")
        Toast.makeText(this, activityMainBinding.editTextText.text.toString(), Toast.LENGTH_LONG)
            .show()


        //Работа со Spinner
        //Создание адаптера, который содержит созданный список
        val spinnerAdapter = ArrayAdapter(
            this,
            com.google.android.material.R.layout.support_simple_spinner_dropdown_item,
            listOf("Завтрак", "Обед", "Ужин")
        )
        //Передача созданного адаптера в spinner
        activityMainBinding.spinner2.adapter = spinnerAdapter

        //Отображение введенного в поле для ввода текста в textView
        activityMainBinding.floatingActionButton.setOnClickListener{
            activityMainBinding.textView2.text =
                activityMainBinding.editTextTextPassword.text.toString()

        }

        //Создание наблюдателя за свойством EditText
        mainActivityViewModel.getEditText().observe(this){
            Log.i("ИЗМЕНЕНО", "ЗНАЧЕНИЕ")
            activityMainBinding.textView2.text = it.toString()
        }
        //Слушатель введенного в поле для ввода текста
            //activityMainBinding.editTextText.addTextChangedListener {
            //Изменение значения editText
            //mainActivityViewModel.getEditText().value = it.toString()
        //}


        //Работа с ресурсами в коде
        activityMainBinding.button.setOnClickListener{
            button.text = getString(R.string.new_text)
            button.setBackgroundColor(getColor(R.color.blue))
        }
    }



    //Метод onStart - запускается после onCreate
    //Подготавливает пользовательский интерфейс к показу пользователю
    override fun onStart() {
        super.onStart()
        Log.v("Метод жизненного цикла","onStart")
    }
    //Метод onResume запускается после onStart, либо после onPause/onStop
    //Демонстрирует пользователю интерфейс активности
    //После его вызова пользователь может взаимодействовать с интерфейсом
    override fun onResume() {
        super.onResume()
        Log.d("Метод жизненного цикла", "onResume")
    }
    //Метод onPause запускается после onResume
    //Готовит активность к переходу в спящий режим, перезапуску или возобновлению работы
    override fun onPause() {
        super.onPause()
        Log.w("Метод жизненного цикла", "onPause")
    }

    //Метод onStop запускается после onPause
    //Готовит активность к переходу в спящий режим, возобновлению работы или уничтожению
    override fun onStop() {
        super.onStop()
        Log.e("Метод жизненного цикла", "onStop")
    }

    //Метод onRestart запускается после onStop
    //Перезагружает пользовательский интерфейс, но создает его заново
    override fun onRestart() {
        super.onRestart()
        Log.i("Метод жизненного цикла", "onRestart")
    }

    //Метод onDestroy запускается после onRestart
    //Вызывается после уничтожения активности и после возвращения ее работы
    override fun onDestroy() {
        super.onDestroy()
        Log.i("Метод жизненного цикла", "onDestroy")
    }

    /*Метод onSaveInstanceState - вызывается для записи значения в Bundle-хранилище
    перед перезагрузкой активности
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //Запись в Bundle хранилище значения showToast с ключом SHOW_TOAST
        outState.putBoolean("SHOW_TOAST", showToast)*/
    }
}