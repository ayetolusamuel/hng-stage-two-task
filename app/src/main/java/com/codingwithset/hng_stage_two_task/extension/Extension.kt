package com.codingwithset.hng_stage_two_task.extension

import android.text.TextUtils
import android.util.Patterns

fun String.isValidEmail() =
    !TextUtils.isEmpty(this) && Patterns.EMAIL_ADDRESS.matcher(this).matches()