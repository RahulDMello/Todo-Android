package com.example.rahul.todo


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.rahul.todo.databinding.FragmentRegularTodoBinding
import com.example.rahul.todo.tools.TodoAdapter
import com.example.rahul.todo.tools.TodoViewModel


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class RegularTodoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = FragmentRegularTodoBinding.inflate(inflater)
        binding.lifecycleOwner = this
        val viewModel = ViewModelProviders.of(this)[TodoViewModel::class.java]
        binding.viewModel = viewModel
        val adapter = TodoAdapter()
        binding.recycler.adapter = adapter

        viewModel.todos.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        return binding.root
    }

}
