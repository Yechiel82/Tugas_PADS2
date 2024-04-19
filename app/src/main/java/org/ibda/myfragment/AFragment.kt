package org.ibda.myfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController


/**
 * A simple [Fragment] subclass.
 * Use the [AFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_a, container, false)

        val goToBBtn = view.findViewById<Button>(R.id.goToB)
        val goToCBtn = view.findViewById<Button>(R.id.goToC)

        goToBBtn.setOnClickListener {
            // ask for a nav controller
            val navController = view.findNavController()
            // navigate into certain destination
            navController.navigate(R.id.action_AFragment_to_BFragment)

        }

        goToCBtn.setOnClickListener {
            // ask for a nav controller
            val navController = view.findNavController()

            val action = AFragmentDirections.actionAFragmentToCFragment("Hello From Fragment A to Fragment C!")

            // navigate into certain destination
            navController.navigate(action)
        }

        return view
    }
}