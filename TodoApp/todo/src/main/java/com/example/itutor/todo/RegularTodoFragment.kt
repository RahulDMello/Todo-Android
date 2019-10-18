package com.example.itutor.todo


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.itutor.todo.databinding.FragmentRegularTodoBinding
import com.example.itutor.todo.tools.TodoAdapter
import com.example.itutor.todo.tools.TodoViewModel

/**
 * A simple [Fragment] subclass.
 *
 */
class RegularTodoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = FragmentRegularTodoBinding.inflate(inflater)
        binding.lifecycleOwner = this
        val viewModel = ViewModelProviders.of(this)[TodoViewModel::class.java].apply {
            selectedTodoIndex.value = -1
        }
        binding.viewModel = viewModel
        val adapter = TodoAdapter{index: Int ->
            viewModel.selectedTodoIndex.value = index
        }
        binding.recycler.adapter = adapter

        viewModel.todos.observe(viewLifecycleOwner, Observer { todos ->
            todos?.let {
                adapter.submitList(it)
                adapter.notifyDataSetChanged()
                Toast.makeText(context, "list updated", Toast.LENGTH_SHORT).show()
            }
        })

        viewModel.selectedTodoIndex.observe(viewLifecycleOwner, Observer {index ->
            index.takeIf { it != -1 }?.let {
                // TODO: change to use navigation component 2.1.0-alpha3 ++
                // findNavController().navigate(R.id.action_regularTodoFragment_to_todoDetailsBottomSheet)
                TodoDetailsBottomSheet(viewModel.todos.value?.get(it)).show(fragmentManager!!, TodoDetailsBottomSheet::class.java.canonicalName)
                // TODO: remove and add actual add list functionality
                viewModel.addTodoList(viewModel.todos.value!![it].copy())
            }
        })

        binding.fab.setOnClickListener {
            Toast.makeText(context, "Created new Todo!", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

}
