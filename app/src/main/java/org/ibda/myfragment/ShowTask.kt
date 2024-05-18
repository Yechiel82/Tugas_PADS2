
package org.ibda.myfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CFragment : Fragment() {
    private var myDatas = listOf(
        Task("WOI", "important"),
        Task("Cipto", "urgent"),
        Task("Kurniawan", "normal"),
        Task("Hadiwardoyo", "important")
    )
    private lateinit var myRV: RecyclerView
    private lateinit var addBtn: Button
    private lateinit var importantBtn: Button
    private lateinit var urgentBtn: Button
    private lateinit var normalBtn: Button
    private lateinit var _adapter: MyRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.show_task, container, false)
        myRV = view.findViewById(R.id.myRecyclerView)
        addBtn = view.findViewById(R.id.addBtn)
        importantBtn = view.findViewById(R.id.Filter_Important)
        urgentBtn = view.findViewById(R.id.Filter_Urgent)
        normalBtn = view.findViewById(R.id.Filter_Normal)

        myRV.layoutManager = LinearLayoutManager(requireContext())
        _adapter = MyRecyclerViewAdapter(myDatas)

        myRV.adapter = _adapter

        addBtn.setOnClickListener {
            _adapter.addData(Task("This is a new Data Item!", "normal"))
        }

        importantBtn.setOnClickListener {
            _adapter.filterData("important")
        }

        urgentBtn.setOnClickListener {
            _adapter.filterData("urgent")
        }

        normalBtn.setOnClickListener {
            _adapter.filterData("normal")
        }

        return view
    }
}
