//package org.ibda.myfragment
//
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import android.widget.EditText
//import androidx.navigation.findNavController
//
//
///**
// * A simple [Fragment] subclass.
// * Use the [BFragment.newInstance] factory method to
// * create an instance of this fragment.
// */
//
//
//class BFragment : Fragment() {
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        val view = inflater.inflate(R.layout.add_task, container, false)
//        val goToCBtn = view.findViewById<Button>(R.id.goToC)
//        goToCBtn.setOnClickListener {
//            // ask for a nav controller
//            val navController = view.findNavController()
//
//            val inputEditText = view.findViewById<EditText>(R.id.input_huruf_besar)
//            val inputText = "NGEG" // Convert to uppercase
//
//            val action = BFragmentDirections.actionBFragmentToCFragment(inputText)
//
////            val action = BFragmentDirections.actionBFragmentToCFragment("")
//
//            // navigate into certain destination
//            navController.navigate(action)
//
//        }
//
//        return view
//    }
//
//}