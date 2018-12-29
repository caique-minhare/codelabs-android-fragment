package com.example.android.fragmentexample.utils

import android.view.View
import android.widget.RadioGroup
import com.example.android.fragmentexample.databinding.IncludedHeaderBinding

class OnCheckedChangedListener(val bindingIncludedHeaderBinding: IncludedHeaderBinding) : RadioGroup.OnCheckedChangeListener {
    companion object {
        const val YES = 0
        const val NO = 1
    }
    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        val radioButton = bindingIncludedHeaderBinding.radioGroup.findViewById<View>(checkedId)
        val index = bindingIncludedHeaderBinding.radioGroup.indexOfChild(radioButton)
        when(index){
            YES -> bindingIncludedHeaderBinding.textViewHeaderTitle.text = "YES"
            else -> bindingIncludedHeaderBinding.textViewHeaderTitle.text = "NO"
        }
    }

}