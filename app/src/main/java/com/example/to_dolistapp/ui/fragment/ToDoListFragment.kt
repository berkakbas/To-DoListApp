package com.example.to_dolistapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.to_dolistapp.R
import com.example.to_dolistapp.databinding.FragmentToDoListBinding
import com.example.to_dolistapp.ui.adapter.ToDoAdapter

class ToDoListFragment : Fragment() {

    private lateinit var binding: FragmentToDoListBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentToDoListBinding.inflate(inflater, container, false)

        val recyclerView = binding.recyclerView
        recyclerView.adapter = ToDoAdapter(requireContext(), listOf())
        recyclerView.setHasFixedSize(true)

        return binding.root
    }

    fun navigateToAddFragment () {
        findNavController().navigate(R.id.action_toDoListFragment_to_addToDoFragment)
    }

    fun navigateToDetailsFragment() {
        findNavController().navigate(R.id.action_toDoListFragment_to_toDoDetailFragment)
    }

}