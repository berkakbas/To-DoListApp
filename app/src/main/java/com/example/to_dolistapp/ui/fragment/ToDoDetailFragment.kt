package com.example.to_dolistapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.to_dolistapp.databinding.FragmentToDoDetailBinding

class ToDoDetailFragment : Fragment() {
    private lateinit var binding: FragmentToDoDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentToDoDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

}