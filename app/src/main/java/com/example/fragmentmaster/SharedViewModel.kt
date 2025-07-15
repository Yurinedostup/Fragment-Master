package com.example.fragmentmaster

import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    var sharedText: String? = null
    var isRed: Boolean = true
}