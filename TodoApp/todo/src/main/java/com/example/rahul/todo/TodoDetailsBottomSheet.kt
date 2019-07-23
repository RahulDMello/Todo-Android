package com.example.rahul.todo


import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
//import com.example.rahul.todo.databinding.FragmentTodoDetailsBottomSheetBinding
import com.example.rahul.todo.tools.TodoAdapter
import com.example.rahul.todo.tools.TodoViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * A simple [BottomSheetDialogFragment] subclass.
 *
 */
class TodoDetailsBottomSheet : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        // Inflate the layout for this fragment
//        val binding = FragmentTodoDetailsBottomSheetBinding.inflate(inflater)
//        binding.lifecycleOwner = this
//        val viewModel = ViewModelProviders.of(this)[TodoViewModel::class.java]
//        binding.viewModel = viewModel
//        val adapter = TodoAdapter()
//        binding.recycler.adapter = adapter
//
//        viewModel.todos.observe(viewLifecycleOwner, Observer {
//            it?.let {
//                adapter.submitList(it)
//            }
//        })
//
//        return binding.root
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_todo_details_bottom_sheet, container, false)
    }


    override fun onDismiss(dialog: DialogInterface?) {
        super.onDismiss(dialog)
    }


}
