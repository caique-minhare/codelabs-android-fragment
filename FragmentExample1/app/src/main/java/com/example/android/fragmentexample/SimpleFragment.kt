package com.example.android.fragmentexample

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.fragmentexample.databinding.FragmentSimpleBinding
import com.example.android.fragmentexample.utils.OnCheckedChangedListener

class SimpleFragment : Fragment() {
    private lateinit var binding: FragmentSimpleBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_simple, container, false)
        setupUi()
        return binding.root
    }

    private fun setupUi(){
        binding.includedHeader.radioGroup.setOnCheckedChangeListener(OnCheckedChangedListener(binding.includedHeader))
    }

    companion object {
        fun newInstance() : SimpleFragment{
            return SimpleFragment()
        }
    }
}