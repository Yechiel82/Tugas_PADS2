package org.ibda.myfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


/**
 * A simple [Fragment] subclass.
 * Use the [CFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_c, container, false)

        // Find the TextView
        val messageTV = view.findViewById<TextView>(R.id.messageTV)

        // Retrieve the message from arguments using safe args
        val message = CFragmentArgs.fromBundle(requireArguments()).message

        // Set the message to the TextView
        messageTV.text = message

        return view
    }

}