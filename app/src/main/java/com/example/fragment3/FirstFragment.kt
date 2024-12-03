package com.example.fragment3

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class FirstFragment : Fragment() {
    private lateinit var receiveData : TextView
    private lateinit var dataToSend : EditText
    private lateinit var sendData : Button

    private var firstReceiver: FirstFragmentReceiver? = null

    interface FirstFragmentReceiver{
        fun firstReceive(data: String)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        receiveData = view.findViewById(R.id.first_data)
        dataToSend = view.findViewById(R.id.first_text)
        sendData = view.findViewById(R.id.first_post)

        sendData.setOnClickListener {
            if(firstReceiver != null){
                var data = dataToSend.text.toString()
                firstReceiver!!.firstReceive(data)
            }
        }
        return view
    }

    fun dataReceived(data: String){
        receiveData.text = data
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is FirstFragmentReceiver){
            firstReceiver = context
        }
    }

    override fun onDetach() {
        super.onDetach()
    }

}