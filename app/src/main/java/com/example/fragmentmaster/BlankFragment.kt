package com.example.fragmentmaster

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import com.example.fragmentmaster.SharedViewModel

class BlankFragment : Fragment() {
    private val viewModel: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Отправляем данные при нажатии на кнопку (пример)
        view.findViewById<Button>(R.id.button_send).setOnClickListener {
            viewModel.sharedText = "Привет из FragmentA!"
            viewModel.isRed = false  // Переключаем состояние
            parentFragmentManager.beginTransaction()
                .setCustomAnimations(   // Установка анимаций смены фрагментов
                    R.anim.slide_in_right, // Анимация "вперёд"
                    R.anim.slide_out_left,
                    R.anim.slide_in_left,  // Анимация "назад"
                    R.anim.slide_out_right
                )
                .replace(R.id.fullscreenFragment, BlankFragment2.newInstance(viewModel.sharedText!!))
                .addToBackStack(null)
                .commit()
        }

    }

//    val fragmentB = Fragment().apply { arguments = bundle }
//    parentFragmentManager.beginTransaction().replace(R.id.container, fragmentB).commit()


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment()
    }
}