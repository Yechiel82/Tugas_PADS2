package org.ibda.myfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TaskViewModel : ViewModel() {
    private val _tasks = MutableLiveData<List<Task>>().apply {
        value = listOf(
            Task("WOI", "important", "new", "Description of WOI", "2024-05-17 10:00", "2024-05-17 12:00", "2 hours"),
            Task("Cipto", "urgent", "in progress", "Description of Cipto", "2024-05-17 09:00", "2024-05-17 11:00", "2 hours"),
            Task("Kurniawan", "normal", "done", "Description of Kurniawan", "2024-05-16 08:00", "2024-05-16 10:00", "2 hours"),
            Task("Hadiwardoyo", "important", "new", "Description of Hadiwardoyo", "2024-05-17 08:00", "2024-05-17 09:00", "1 hour")
        )
    }
    val tasks: LiveData<List<Task>> = _tasks

    fun addTask(task: Task) {
        _tasks.value = _tasks.value?.plus(task)
    }
}
