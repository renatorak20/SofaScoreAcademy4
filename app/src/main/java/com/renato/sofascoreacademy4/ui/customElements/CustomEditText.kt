package com.renato.sofascoreacademy4.ui.customElements

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.Toast
import com.renato.sofascoreacademy4.R
import com.renato.sofascoreacademy4.databinding.CustomEditTextBinding

const val INPUT_TYPE_NUMBER = 2

class CustomEditText(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs) {

    private val binding: CustomEditTextBinding

    init{
        inflate(context, R.layout.custom_edit_text, null)
        binding = CustomEditTextBinding.inflate(LayoutInflater.from(context), null, false)
        addView(binding.root)

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CustomEditText, 0, 0).apply {
            try {
                binding.field.hint = getString(R.styleable.CustomEditText_hint)
                binding.field.editText?.inputType = when(getInt(R.styleable.CustomEditText_inputType, InputType.TYPE_NULL)){
                    INPUT_TYPE_NUMBER -> InputType.TYPE_CLASS_NUMBER
                    else -> InputType.TYPE_CLASS_TEXT
                }
            } finally {
                recycle()
            }
        }
    }

    fun getText() : String{
        return binding.field.editText?.text.toString()
    }
    private fun getHint() : String{
        return binding.field.editText?.hint.toString()
    }
    private fun getInputType(): Int? {
        return binding.field.editText?.inputType
    }
    fun clear(){
        binding.field.editText?.text?.clear()
    }

    fun isValid() : Boolean{
        when(getInputType()){
            1 -> if(getText().isEmpty()) {
                showTextError(getHint())
                showToast()
                return false
            }
            2 -> if(getText().toInt() > 2023 || getText().toInt() < 1500) {
                showNumberError(getHint())
                showToast()
                return false
            }
        }
        binding.field.error = null
        return true
    }

    private fun showTextError(hint:String){
        when(hint){
            resources.getString(R.string.name) -> binding.field.error = resources.getString(R.string.error_name)
            resources.getString(R.string.address) -> binding.field.error = resources.getString(R.string.error_address)
            resources.getString(R.string.city) -> binding.field.error = resources.getString(R.string.error_city)
            resources.getString(R.string.country) -> binding.field.error = resources.getString(R.string.error_country)
            resources.getString(R.string.founder) -> binding.field.error = resources.getString(R.string.error_founder)
            resources.getString(R.string.email) -> binding.field.error = resources.getString(R.string.error_email)
            resources.getString(R.string.website) -> binding.field.error = resources.getString(R.string.error_website)
            resources.getString(R.string.description) -> binding.field.error = resources.getString(R.string.error_desc)
        }
    }
    private fun showNumberError(hint:String){
        when(hint){
            resources.getString(R.string.yearFounded) -> binding.field.error = resources.getString(R.string.error_foundation_year)
        }
    }
    private fun showToast(){
        Toast.makeText(context, R.string.error_fill_all, Toast.LENGTH_SHORT).show()
    }
}