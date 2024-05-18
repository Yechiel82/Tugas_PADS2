package org.ibda.myfragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView

data class Task(val name: String, val priority: String)

class MyRecyclerViewAdapter(private var myDatas: List<Task>) :
    RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {

    private var filteredDatas: List<Task> = myDatas

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val task = filteredDatas[position]
        holder.textView.text = task.name

        holder.itemView.setOnClickListener {
            showTaskDetails(holder.itemView.context, task)
        }
    }

    override fun getItemCount(): Int {
        return filteredDatas.size
    }

    fun addData(newData: Task) {
        myDatas = myDatas + newData
        filteredDatas = myDatas
        notifyDataSetChanged()
    }

    fun filterData(priority: String) {
        filteredDatas = myDatas.filter { it.priority == priority }
        notifyDataSetChanged()
    }

    private fun showTaskDetails(context: Context, task: Task) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Task Details")
        builder.setMessage("Name: ${task.name}\nPriority: ${task.priority}")
        builder.setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
        builder.show()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textView)
    }
}
