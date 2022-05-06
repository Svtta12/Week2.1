package science.example.week21

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private var button_next: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_next = findViewById<View>(R.id.button_next) as Button
        button_next?.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}


//Задание 2.7: Открывать-закрывать-сворачивать экран и смотреть, что будет происходить
//Наблюдаем за жизненным циклом Fragment
//Запуск приложения: onAttach() -> OnCreate() -> OnCreateView() -> OnActivityCreate(устарел) -> onStart() -> onResume()
//Выход из приложения(через кнопку Back): onPause() -> onStop() -> onDestroyView() -> onDestroy() -> onDetach()
//Нажать кнопку "Домой": onPause() -> onStop()
//Запуск приложения из недавно открытых: onStart() ->onResume()
//При замещении первого фрагмента вторым:
//Первый фрагмент: onStop() -> onDestroyView()
//Второй фрагмент: onAttach() -> OnCreate() -> OnCreateView() -> onStart() -> onResume()

//Задание 2.9: Отличия жизенного цикла фрагмента от жизненного цикла активити. Для чего нужны? Почему возникают?
//Activity - часть приложения, в которой пользователь взаимодействует с приложением.
//Фрагмент представляет собой часть пользовательского интерфейса Activity. В одном Activity может быть
//несколько фрагментов.
//У фрагмента есть несколько дополниельных методов жизненного цикла, которых нет у Activity
//onAttach(): вызывается, когда фрагмент связывается с активностью. С этого момента можно получить
//ссылку на активность, через getActivity()
//onCreateView(): вызывается для создания компонентов внутри фрагмента
//onViewCreate(): вызывается после создания представления фрагмента
//onDestroyView(): уничтожается представление фрагмента
//onDetach() вызывается, когда фрагмент удаляется из FragmentManager и открепляется от класса Activity.
//Этот метод вызывается после всех остальных методов жизненного цикла.
//Различие фрагмента от активити в том, что фрагмент живет только в тот момент, пока живет активити
//Если же будет унечтожено активити, то унечтожатся и все фрагменты
//Но активити существует независимо от фрагмента.