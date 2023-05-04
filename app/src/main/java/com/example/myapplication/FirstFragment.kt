package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentFirstBinding
class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnSTART.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("keyName",binding.etName.text.toString())
            bundle.putString("keySurname",binding.etSurname.text.toString())
            bundle.putString("keyMidlename",binding.etMidleName.text.toString())
            val fragment = SecondFragment()
            fragment.arguments = bundle
           requireActivity()
               .supportFragmentManager
               .beginTransaction()
               .replace(R.id.container,fragment)
               .addToBackStack(null)
               .commit()
        }

    }

}