package com.example.rahul.todo


import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rahul.todo.service.dto.TodoListDto
import com.example.rahul.todo.databinding.FragmentTodoDetailsBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * A simple [BottomSheetDialogFragment] subclass.
 *
 */
class TodoDetailsBottomSheet(val todoListDto: TodoListDto?) : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentTodoDetailsBottomSheetBinding.inflate(inflater)
        return binding.root
    }

    override fun onDismiss(dialog: DialogInterface?) {
        super.onDismiss(dialog)
    }

}
