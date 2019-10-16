package com.example.itutor.todo

import android.app.Dialog
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.itutor.todo.databinding.FragmentTodoDetailsBottomSheetBinding
import com.example.itutor.todo.service.dto.TodoListDto
import com.example.itutor.todo.tools.TodoItemAdapter
import com.example.itutor.todo.tools.TodoItemViewModel
import com.example.itutor.todo.tools.TodoItemViewModelFactory
import com.example.itutor.todo.tools.toColorInt
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * A simple [BottomSheetDialogFragment] subclass.
 *
 */
class TodoDetailsBottomSheet(private val todoListDto: TodoListDto?) : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTodoDetailsBottomSheetBinding.inflate(inflater)
        binding.lifecycleOwner = this
        val factory = TodoItemViewModelFactory(todoListDto ?: TodoListDto("", listOf()))
        val viewModel = ViewModelProviders.of(this, factory)[TodoItemViewModel::class.java]
        binding.viewModel = viewModel
        binding.headerColorPlaceholder.imageTintList =
            ColorStateList.valueOf(viewModel.todoList.value?.color?.toColorInt() ?: 0)

        val adapter = TodoItemAdapter {
            // TODO: Show the details for that todo
            Toast.makeText(context, it.todo, Toast.LENGTH_SHORT).show()
        }

        binding.recycler.adapter = adapter

        viewModel.todoList.observe(viewLifecycleOwner, Observer { todos ->
            todos?.let {
                adapter.submitList(it.todoList)
            }
            binding.listTitle.text = todos.title
        })

        return binding.root
    }

    override fun getTheme(): Int = R.style.AppBottomSheetDialogTheme

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        dialog.setOnShowListener {
            val bottomSheetDialog = it as BottomSheetDialog
            bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
                ?.let { bottomSheet ->
                    bottomSheet.layoutParams?.height =
                        (resources.displayMetrics.heightPixels.toDouble() * 0.9).toInt()
                    BottomSheetBehavior.from(bottomSheet).peekHeight =
                        bottomSheet.layoutParams?.height ?: 0
                    bottomSheet.requestLayout()
                }
        }
        return dialog
    }

}
