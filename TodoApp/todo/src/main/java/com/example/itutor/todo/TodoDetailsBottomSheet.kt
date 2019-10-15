package com.example.itutor.todo

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.itutor.todo.databinding.FragmentTodoDetailsBottomSheetBinding
import com.example.itutor.todo.service.dto.TodoListDto
import com.example.itutor.todo.tools.TodoItemViewModel
import com.example.itutor.todo.tools.TodoItemViewModelFactory
import com.example.itutor.todo.tools.TodoViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * A simple [BottomSheetDialogFragment] subclass.
 *
 */
class TodoDetailsBottomSheet(val todoListDto: TodoListDto?) : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentTodoDetailsBottomSheetBinding.inflate(inflater)
        binding.lifecycleOwner = this
        val factory = TodoItemViewModelFactory(todoListDto ?: TodoListDto("", listOf()))
        val viewModel = ViewModelProviders.of(this, factory)[TodoItemViewModel::class.java]
        binding.viewModel = viewModel
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
                        (resources.displayMetrics.heightPixels.toDouble() * 0.85).toInt()
                    BottomSheetBehavior.from(bottomSheet).peekHeight = bottomSheet.layoutParams?.height ?: 0
                    bottomSheet.requestLayout()
                }
        }
        return dialog
    }

}
