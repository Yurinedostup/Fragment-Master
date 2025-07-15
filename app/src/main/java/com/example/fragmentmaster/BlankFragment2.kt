package com.example.fragmentmaster

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentmaster.databinding.FragmentBlank2Binding

class BlankFragment2 : Fragment() {
    private var _binding: FragmentBlank2Binding? = null
    private val binding get() = _binding!!

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBlank2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Получаем данные из Bundle
        val text = arguments?.getString("key") ?: "Данных нет"
        Log.d("BlankFragment2", "Received: $text")  // Добавили логгирование
        binding.textView.text = text
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(text: String) = BlankFragment2().apply {
            arguments = Bundle().apply {
                putString("key", text)
            }
        }
    }
}