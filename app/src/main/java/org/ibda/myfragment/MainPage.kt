package org.ibda.myfragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class AFragment : Fragment() {

    private lateinit var newTasksGrid: GridLayout
    private lateinit var inProgressTasksGrid: GridLayout
    private lateinit var doneTasksGrid: GridLayout
    private lateinit var addTaskButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.main_page_frag, container, false)

        // Initialize views
        newTasksGrid = view.findViewById(R.id.new_tasks_grid)
        inProgressTasksGrid = view.findViewById(R.id.in_progress_tasks_grid)
        doneTasksGrid = view.findViewById(R.id.done_tasks_grid)
        addTaskButton = view.findViewById(R.id.add_task_button)

        // Set OnClickListener for the addTaskButton
        addTaskButton.setOnClickListener {
            // Navigate to BFragment when addTaskButton is clicked
            findNavController().navigate(R.id.action_AFragment_to_CFragment)
        }

        // Example: Add some dummy tasks (replace with your data source)
        addTaskToCategory("New", "Task 1")
        addTaskToCategory("New", "Task 2")
        addTaskToCategory("In Progress", "Task 3")
        addTaskToCategory("Done", "Task 4")

        // Update task counts
        updateTaskCounts()

        return view
    }

    private fun addTaskToCategory(category: String, taskName: String) {
        val taskTextView = TextView(requireContext()).apply {
            text = taskName
            textSize = 18f
        }
        when (category) {
            "New" -> newTasksGrid.addView(taskTextView)
            "In Progress" -> inProgressTasksGrid.addView(taskTextView)
            "Done" -> doneTasksGrid.addView(taskTextView)
        }
    }

    private fun updateTaskCounts() {
        // Here you would fetch task counts for each stage from your data source
        val newTasksCount = newTasksGrid.childCount - 1 // subtracting 1 for the title TextView
        val inProgressTasksCount = inProgressTasksGrid.childCount - 1
        val doneTasksCount = doneTasksGrid.childCount - 1

        // Update total task counts
        view?.findViewById<TextView>(R.id.new_tasks_total)?.text = "New Tasks: $newTasksCount"
        view?.findViewById<TextView>(R.id.in_progress_tasks_total)?.text = "In Progress Tasks: $inProgressTasksCount"
        view?.findViewById<TextView>(R.id.done_tasks_total)?.text = "Done Tasks: $doneTasksCount"
    }
}

