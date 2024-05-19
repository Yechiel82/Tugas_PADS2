package org.ibda.myfragment.repository

import android.content.ContentValues
import android.content.Context
import org.ibda.myfragment.Task
import org.ibda.myfragment.database.TaskDatabaseHelper

class TaskRepository(context: Context) {

    private val dbHelper = TaskDatabaseHelper(context)

    fun saveTask(task: Task): Boolean {
        val db = dbHelper.writableDatabase

        val values = ContentValues().apply {
            put(TaskDatabaseHelper.COLUMN_NAME, task.name)
            put(TaskDatabaseHelper.COLUMN_PRIORITY, task.priority)
            put(TaskDatabaseHelper.COLUMN_STAGE, task.stage)
            put(TaskDatabaseHelper.COLUMN_DESCRIPTION, task.description)
            put(TaskDatabaseHelper.COLUMN_CREATED_TIME, task.createdTime)
            put(TaskDatabaseHelper.COLUMN_FINISHED_TIME, task.finishedTime)
            put(TaskDatabaseHelper.COLUMN_DURATION, task.duration)
        }

        val newRowId = db.insert(TaskDatabaseHelper.TABLE_TASKS, null, values)
        db.close()
        return newRowId != -1L
    }

    fun updateTaskStage(task: Task, newStage: String): Boolean {
        val db = dbHelper.writableDatabase

        val values = ContentValues().apply {
            put(TaskDatabaseHelper.COLUMN_STAGE, newStage)
        }

        val rowsAffected = db.update(
            TaskDatabaseHelper.TABLE_TASKS,
            values,
            "${TaskDatabaseHelper.COLUMN_ID} = ?",
            arrayOf(task.id.toString())
        )
        db.close()
        return rowsAffected > 0
    }

    fun getAllTasks(): List<Task> {
        val db = dbHelper.readableDatabase

        val cursor = db.query(
            TaskDatabaseHelper.TABLE_TASKS,
            null,
            null,
            null,
            null,
            null,
            null
        )

        val tasks = mutableListOf<Task>()
        with(cursor) {
            while (moveToNext()) {
                val task = Task(
                    id = getLong(getColumnIndexOrThrow(TaskDatabaseHelper.COLUMN_ID)),
                    name = getString(getColumnIndexOrThrow(TaskDatabaseHelper.COLUMN_NAME)),
                    priority = getString(getColumnIndexOrThrow(TaskDatabaseHelper.COLUMN_PRIORITY)),
                    stage = getString(getColumnIndexOrThrow(TaskDatabaseHelper.COLUMN_STAGE)),
                    description = getString(getColumnIndexOrThrow(TaskDatabaseHelper.COLUMN_DESCRIPTION)),
                    createdTime = getString(getColumnIndexOrThrow(TaskDatabaseHelper.COLUMN_CREATED_TIME)),
                    finishedTime = getString(getColumnIndexOrThrow(TaskDatabaseHelper.COLUMN_FINISHED_TIME)),
                    duration = getString(getColumnIndexOrThrow(TaskDatabaseHelper.COLUMN_DURATION))
                )
                tasks.add(task)
            }
        }
        cursor.close()
        db.close()
        return tasks
    }
}
