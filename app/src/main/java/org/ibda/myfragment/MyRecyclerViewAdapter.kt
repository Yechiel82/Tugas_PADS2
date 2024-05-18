

package org.ibda.myfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(private var myDatas: List<Task>) : RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {

    private var filteredDatas: List<Task> = myDatas

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = filteredDatas[position].name
    }

    override fun getItemCount(): Int {
        return filteredDatas.size
    }

    fun addData(newData: Task) {
        myDatas = myDatas + newData
        notifyDataSetChanged()
    }

    fun filterData(priority: String) {
        filteredDatas = myDatas.filter { it.priority == priority }
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textView)
    }
}

data class Task(val name: String, val priority: String)

//package org.ibda.myfragment
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//
//class MyRecyclerViewAdapter(
//    private var myDatas: List<Task>,
//    private val itemClickListener: OnItemClickListener
//) : RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {
//
//    private var filteredDatas: List<Task> = myDatas
//
//    interface OnItemClickListener {
//        fun onItemClick(task: Task)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
//        return MyViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        val task = filteredDatas[position]
//        holder.textView.text = task.name
//        holder.bind(task, itemClickListener)
//    }
//
//    override fun getItemCount(): Int {
//        return filteredDatas.size
//    }
//
//    fun addData(newData: Task) {
//        myDatas = myDatas + newData
//        notifyDataSetChanged()
//    }
//
//    fun filterData(priority: String) {
//        filteredDatas = myDatas.filter { it.priority == priority }
//        notifyDataSetChanged()
//    }
//
//    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val textView: TextView = itemView.findViewById(R.id.textView)
//
//        fun bind(task: Task, clickListener: OnItemClickListener) {
//            itemView.setOnClickListener {
//                clickListener.onItemClick(task)
//            }
//        }
//    }
//}
//
//data class Task(val name: String, val priority: String)