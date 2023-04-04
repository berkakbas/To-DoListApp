package com.example.to_dolistapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.to_dolistapp.R
import com.example.to_dolistapp.data.ToDoEntity
import com.example.to_dolistapp.databinding.FragmentToDoListBinding
import com.example.to_dolistapp.ui.adapter.ToDoAdapter
import com.example.to_dolistapp.ui.viewmodel.ToDoListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ToDoListFragment : Fragment() {

    private lateinit var binding: FragmentToDoListBinding
    private val todoListViewModel by viewModels<ToDoListViewModel>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentToDoListBinding.inflate(inflater, container, false)
        binding.listFragment = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerView.setHasFixedSize(true)

        lifecycleScope.launch {
            todoListViewModel.todos.collect {
                binding.todoAdapter = ToDoAdapter(todoListViewModel.todos.value, todoListViewModel)
                checkEmptyList(it)
            }
        }

        super.onViewCreated(view, savedInstanceState)
    }

    fun navigateToAddFragment() {
        findNavController().navigate(R.id.action_toDoListFragment_to_addToDoFragment)
    }

    private fun checkEmptyList(list: List<ToDoEntity>) {
        if (list.isEmpty()) {
            binding.emptyListTextView.visibility = View.VISIBLE
        } else {
            binding.emptyListTextView.visibility = View.GONE
        }
    }

}