package com.example.viewmodeldemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodeldemo.databinding.FragmentDatenBinding


class DatenFragment : Fragment() {

    lateinit var binding: FragmentDatenBinding
    lateinit var model: DataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDatenBinding.inflate(inflater, container, false)

        activity?.let {
            model = ViewModelProvider(it)[DataViewModel::class.java]
            model.content.observe(it) { value: String ->
                binding.tvFragmentOutput.text = value
            }

        }

        return binding.root
    }


}