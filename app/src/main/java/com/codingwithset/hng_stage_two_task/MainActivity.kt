package com.codingwithset.hng_stage_two_task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codingwithset.hng_stage_two_task.databinding.ActivityMainBinding
import com.codingwithset.hng_stage_two_task.extension.isValidEmail

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submitBtn.setOnClickListener {
            if (isValidateFields()) {
                val dialog = UserDetailDialogFragment(binding.emailEdt,binding.nameEdt,binding.phoneEdt)
                dialog.isCancelable = false
                dialog.show(
                    supportFragmentManager,
                    "user_fragment"
                )
            }
        }
    }

    private fun isValidateFields(): Boolean {
        var flag = true;
        when {
            binding.emailEdt.text.toString().isEmpty() -> {
                binding.emailEdt.error = "email address can't be empty."
                flag = false
            }
            !binding.emailEdt.text.toString().isValidEmail() ->{
                binding.emailEdt.error = "invalid email"
                flag = false
            }
            binding.nameEdt.text.toString().isEmpty() -> {
                binding.nameEdt.error = "full name can't be empty."
                flag = false
            }
            binding.phoneEdt.text.toString().isEmpty() -> {
                binding.phoneEdt.error = "phone number can't be empty."
                flag = false
            }
            binding.phoneEdt.text.toString().length != 11 -> {
                binding.phoneEdt.error = "invalid phone number."
                flag = false
            }
        }
        return flag
    }



    companion object {
        val CLEAR_CONSTANT = "clear"
    }
}