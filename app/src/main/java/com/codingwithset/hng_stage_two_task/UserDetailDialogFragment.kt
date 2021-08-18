package com.codingwithset.hng_stage_two_task

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.codingwithset.hng_stage_two_task.databinding.UserDetailsDialogBinding
import com.google.android.material.textfield.TextInputEditText

class UserDetailDialogFragment(
    private val email: TextInputEditText,
    private val nameEdt: TextInputEditText,
    private val phoneEdt: TextInputEditText,
) :
    DialogFragment(R.layout.user_details_dialog) {
    private var _binding: UserDetailsDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        _binding = UserDetailsDialogBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.emailTxt.text = email.text.toString()
        binding.fullnameTxt.text = nameEdt.text.toString()
        binding.phoneNumberTxt.text = phoneEdt.text.toString()

        binding.closeBtn.setOnClickListener {
            dialog?.dismiss()
            nameEdt.setText("")
            phoneEdt.setText("")
            email.setText("")
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
    }


}
