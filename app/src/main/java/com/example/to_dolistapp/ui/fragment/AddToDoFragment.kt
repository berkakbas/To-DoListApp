package com.example.to_dolistapp.ui.fragment

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
import com.example.to_dolistapp.databinding.FragmentAddToDoBinding
import com.example.to_dolistapp.ui.viewmodel.ToDoListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddToDoFragment : Fragment() {
    private lateinit var binding: FragmentAddToDoBinding

    private val todoListViewModel by viewModels<ToDoListViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAddToDoBinding.inflate(inflater, container, false)

        binding.addTodoButton.setOnClickListener {
            addTodo(binding.todoEditText.text.toString())
        }
        return binding.root
    }

    private fun addTodo(note: String) {
        val todo = ToDoEntity(note = note, priority = Primacy.HIGH)
        todoListViewModel.insertTodo(todo)
        navigateToListFragment()
    }

    private fun navigateToListFragment() {
        findNavController().navigate(R.id.action_addToDoFragment_to_toDoListFragment)
    }

}