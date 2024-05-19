package org.ibda.myfragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import org.ibda.myfragment.repository.TaskRepository

class TaskViewModel(application: Application) : AndroidViewModel(application) {
    private val _tasks = MutableLiveData<List<Task>>()
    val tasks: LiveData<List<Task>> = _tasks

    private val taskRepository = TaskRepository(application)

    init {
        loadTasks()
    }

    private fun loadTasks() {
        _tasks.value = taskRepository.getAllTasks()
    }

    fun addTask(task: Task) {
        if (taskRepository.saveTask(task)) {
            _tasks.value = _tasks.value?.plus(task)
        } else {
            // Handle the error
        }
    }

    fun updateTaskStage(task: Task, newStage: String) {
        if (taskRepository.updateTaskStage(task, newStage)) {
            _tasks.value = _tasks.value?.map {
                if (it.id == task.id) it.copy(stage = newStage) else it
            }
        } else {
            // Handle the error
        }
    }
}

//package org.ibda.myfragment
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import org.ibda.myfragment.Task
//import org.ibda.myfragment.repository.TaskRepository
//
//class TaskViewModel : ViewModel() {
//    private val _tasks = MutableLiveData<List<Task>>().apply {
//        value = listOf(
//            Task(0,"WOI", "important", "new", "Description of WOI", "2024-05-17 10:00", "2024-05-17 12:00", "2 hours"),
//            Task(1,"Cipto", "urgent", "in progress", "Description of Cipto", "2024-05-17 09:00", "2024-05-17 11:00", "2 hours"),
//            Task(2,"Kurniawan", "normal", "done", "Description of Kurniawan", "2024-05-16 08:00", "2024-05-16 10:00", "2 hours"),
//            Task(3,"Hadiwardoyo", "important", "new", "Description of Hadiwardoyo", "2024-05-17 08:00", "2024-05-17 09:00", "1 hour")
//        )
//    }
//
//    val tasks: LiveData<List<Task>> = _tasks
//
//    private val taskRepository = TaskRepository()
//
//    fun addTask(task: Task) {
//        taskRepository.saveTask(task) { success ->
//            if (success) {
//                _tasks.postValue(_tasks.value?.plus(task))
//            } else {
//                // Handle the error
//            }
//        }
//    }
//
//    fun updateTaskStage(task: Task, newStage: String) {
//        val updatedTask = task.copy(stage = newStage)
//        taskRepository.saveTask(updatedTask) { success ->
//            if (success) {
//                _tasks.value = _tasks.value?.map {
//                    if (it == task) updatedTask else it
//                }
//            } else {
//                // Handle the error
//            }
//        }
//    }
//}
////
////val tasks: LiveData<List<Task>> = _tasks
////
////    fun addTask(task: Task) {
////        _tasks.value = _tasks.value?.plus(task)
////    }
////
////    fun updateTaskStage(task: Task, newStage: String) {
////        _tasks.value = _tasks.value?.map {
////            if (it == task) it.copy(stage = newStage) else it
////        }
////    }
////}
