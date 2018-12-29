package com.example.android.fragmentexample

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.android.fragmentexample.databinding.ActivityMainBinding
import com.example.android.fragmentexample.utils.STATE_OF_FRAGMENT

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var isFragmentDisplayed: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        if (savedInstanceState != null) {
            isFragmentDisplayed = savedInstanceState.getBoolean(STATE_OF_FRAGMENT);
            if (isFragmentDisplayed) {
                // If the fragment is displayed, change button to "close".
                binding.button.text = "CLOSE"
            }
        }

        binding.button.setOnClickListener {
            if (!isFragmentDisplayed)
                displayFragment()
            else
                closeFragment()
        }
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        savedInstanceState.putBoolean(STATE_OF_FRAGMENT, isFragmentDisplayed)
        super.onSaveInstanceState(savedInstanceState)
    }

    fun displayFragment() {
        val simpleFragment = SimpleFragment.newInstance()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragment_container, simpleFragment)
                .addToBackStack(null)
                .commit()
        binding.button.text = "CLOSE"
        isFragmentDisplayed = true
    }

    fun closeFragment() {
        val fragmentMananager = supportFragmentManager
        val simpleFragment = fragmentMananager.findFragmentById(R.id.fragment_container) as SimpleFragment
        if (simpleFragment != null) {
            val fragmentTransaction = fragmentMananager.beginTransaction()
            fragmentTransaction.remove(simpleFragment).commit()
        }
        binding.button.text = "OPEN"
        isFragmentDisplayed = false

    }
}