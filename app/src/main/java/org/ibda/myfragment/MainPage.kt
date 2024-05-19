package org.ibda.myfragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

class AFragment : Fragment() {

    private val taskViewModel: TaskViewModel by activityViewModels()

    private lateinit var newTasksTextView: TextView
    private lateinit var inProgressTasksTextView: TextView
    private lateinit var doneTasksTextView: TextView
    private lateinit var addDataButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.main_page_frag, container, false)

        newTasksTextView = view.findViewById(R.id.new_tasks_total)
        inProgressTasksTextView = view.findViewById(R.id.in_progress_tasks_total)
        doneTasksTextView = view.findViewById(R.id.done_tasks_total)
        addDataButton = view.findViewById(R.id.button_add_data)

        newTasksTextView.setOnClickListener {
            logClickedTextView("New Tasks")
            navigateToCFragmentWithStage("new")
        }
        inProgressTasksTextView.setOnClickListener {
            logClickedTextView("In Progress Tasks")
            navigateToCFragmentWithStage("in progress")
        }
        doneTasksTextView.setOnClickListener {
            logClickedTextView("Done Tasks")
            navigateToCFragmentWithStage("done")
        }
        addDataButton.setOnClickListener {
            navigateToAddTaskFragment()
        }

        observeTaskCounts()

        return view
    }

    private fun logClickedTextView(textViewName: String) {
        Log.d("AFragment", "Clicked TextView: $textViewName")
    }

    private fun navigateToCFragmentWithStage(stage: String) {
        Log.d("AFragment", "Navigating to CFragment with stage: $stage")
        val action = AFragmentDirections.actionAFragmentToCFragment(stage)
        findNavController().navigate(action)
    }

    private fun navigateToAddTaskFragment() {
        Log.d("AFragment", "Navigating to AddTaskFragment")
        val action = AFragmentDirections.actionAFragmentToBFragment()
        findNavController().navigate(action)
    }

    private fun observeTaskCounts() {
        taskViewModel.tasks.observe(viewLifecycleOwner, Observer { tasks ->
            val newTasksCount = tasks.count { it.stage == "new" }
            val inProgressTasksCount = tasks.count { it.stage == "in progress" }
            val doneTasksCount = tasks.count { it.stage == "done" }

            updateTaskCount(newTasksTextView, "New Tasks", newTasksCount)
            updateTaskCount(inProgressTasksTextView, "In Progress Tasks", inProgressTasksCount)
            updateTaskCount(doneTasksTextView, "Done Tasks", doneTasksCount)
        })
    }

    private fun updateTaskCount(textView: TextView, category: String, count: Int) {
        textView.text = "$category: $count"
        Log.d("AFragment", "Updated $category count: $count")
    }
}
