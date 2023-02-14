package com.example.an10_onl.utils.validation

import com.google.android.material.textfield.TextInputLayout

fun TextInputLayout.getStringText(): String = editText?.text.toString()