//package org.ibda.myfragment
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import android.widget.Toast
//import androidx.appcompat.app.AlertDialog
//import androidx.recyclerview.widget.RecyclerView
//
//class MyRecyclerViewAdapter(private var myDataset: List<Task>) :
//    RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {
//
//    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
//        val textView: TextView = view.findViewById(R.id.taskName)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val textView = LayoutInflater.from(parent.context)
//            .inflate(R.layout.task_item, parent, false) as View
//        return MyViewHolder(textView)
//    }
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        holder.textView.text = myDataset[position].name
//        holder.itemView.setOnClickListener {
//            showTaskDetails(holder.itemView.context, myDataset[position])
//        }
//    }
//
//    override fun getItemCount() = myDataset.size
//
//    fun addData(task: Task) {
//        myDataset = myDataset + task
//        notifyDataSetChanged()
//    }
//
//    fun filterData(priority: String) {
//        myDataset = myDataset.filter { it.priority == priority }
//        notifyDataSetChanged()
//    }
//
//    private fun showTaskDetails(context: Context, task: Task) {
//        val builder = AlertDialog.Builder(context)
//        builder.setTitle("Task Details")
//        builder.setMessage("Name: ${task.name}\nPriority: ${task.priority}")
//        builder.setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
//        builder.show()
//    }
//}
