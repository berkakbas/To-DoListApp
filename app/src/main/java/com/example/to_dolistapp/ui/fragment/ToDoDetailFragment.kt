package com.example.to_dolistapp.ui.fragment

import android.os.Build.VERSION_CODES.P
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.to_dolistapp.R
import com.example.to_dolistapp.data.Primacy
import com.example.to_dolistapp.data.ToDoEntity
import com.example.to_dolistapp.databinding.FragmentToDoDetailBinding
import com.example.to_dolistapp.ui.viewmodel.ToDoDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ToDoDetailFragment : Fragment() {
    private lateinit var binding: FragmentToDoDetailBinding
    private val todoDetailViewModel by viewModels<ToDoDetailViewModel>()

    lateinit var todo: ToDoEntity
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentToDoDetailBinding.inflate(inflater, container, false)

        todo = arguments?.getSerializable("todo") as ToDoEntity
        binding.updateEditText.setText(todo.note)

        binding.updateTodoButton.setOnClickListener {
            updateTodo(binding.updateEditText.text.toString())
        }

        return binding.root
    }

    private fun updateTodo(note: String) {
        val updatedTodo = ToDoEntity(id= todo.id, note = note, priority = todo.priority)
        todoDetailViewModel.updateTodo(updatedTodo)
        navigateToListFragment()
    }

    private fun navigateToListFragment() {
        findNavController().navigate(R.id.action_toDoDetailFragment_to_toDoListFragment)
    }

}