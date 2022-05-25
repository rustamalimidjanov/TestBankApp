package com.example.testbankapp.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.testbankapp.R

class MainFragment: Fragment() {
    private var callback: Callback? = null
    private lateinit var bReg: Button


    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = context as Callback?
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragmant_main, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bReg = view.findViewById<Button>(R.id.bReg)

        bReg.setOnClickListener {
            Log.d("tag", "push")
            callback?.onClickReg()
        }

    }




    override fun onDetach() {
        super.onDetach()
        callback = null
    }

    companion object {
        fun newInstance(): MainFragment = MainFragment()
    }


}