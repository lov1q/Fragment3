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

class SecondFragment : Fragment() {
    private lateinit var receiveData : TextView
    private lateinit var dataToSend : EditText
    private lateinit var sendData : Button

    private var secondReceiver: SecondFragmentReceiver? = null
    interface SecondFragmentReceiver{
        fun secondReceive(data: String)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        receiveData = view.findViewById(R.id.second_data)
        dataToSend = view.findViewById(R.id.second_text)
        sendData = view.findViewById(R.id.second_post)

        sendData.setOnClickListener {
            if(secondReceiver != null){
                var data = dataToSend.text.toString()
                secondReceiver!!.secondReceive(data)
            }
        }
        return view
    }
    fun dataReceived(data: String){
        receiveData.text = data
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is SecondFragmentReceiver){
            secondReceiver = context
        }
    }

    override fun onDetach() {
        super.onDetach()
    }

}