package com.example.fragmentmaster

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.fragmentmaster.databinding.ActivityMainBinding
import com.example.fragmentmaster.SharedViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: SharedViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Устанавливаем фрагмент в контейнер на макете
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fullscreenFragment, BlankFragment.newInstance()).commit()

        /*Обработка нажатия кнопки "сменить фрагмент"
        Добавление логики если фрагмент (уже) стоит карсный, то сменить на синий. И наоборот.
        Добавление кастомных анимаций смены фрагментов(перехода), см. в res/anim
        с помощью функции .setCustomAnimations(первые две анимации за "вперёд",
        следующие две за "назад"
        */
        binding.change.setOnClickListener {
            val fragment = if (viewModel.isRed) { // Используем состояние из ViewModel
                BlankFragment2.newInstance(viewModel.sharedText ?: "Данных нет")
            } else {
            BlankFragment.newInstance()
        }
            supportFragmentManager.beginTransaction()
                .setCustomAnimations(   // Установка анимаций смены фрагментов
                    R.anim.slide_in_right, // Анимация "вперёд"
                    R.anim.slide_out_left,
                    R.anim.slide_in_left,  // Анимация "назад"
                    R.anim.slide_out_right
                )
                .replace(R.id.fullscreenFragment, fragment) //смена фрагмента
                .addToBackStack(null)
                .commit()
            viewModel.isRed = !viewModel.isRed
        }
    }
}