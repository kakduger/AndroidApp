package com.ubisoft.dihaniedlyaozabochennih.breathsession.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.ubisoft.dihaniedlyaozabochennih.R
import com.ubisoft.dihaniedlyaozabochennih.breathsession.SessionParameters
import com.ubisoft.dihaniedlyaozabochennih.breathsession.viewModel.BreathNewModel1

class BreathFragment: Fragment()
{
    private val viewModel: BreathNewModel1 = BreathNewModel1()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        return inflater.inflate(R.layout.fragment_breathsession,
            container,
            false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        viewModel.listener = this

        val breathIn = view.findViewById<TextView>(R.id.breathIn)
        val breathOut = view.findViewById<TextView>(R.id.breathOut)
        val hold = view.findViewById<TextView>(R.id.hold1)
        val hold2 = view.findViewById<TextView>(R.id.hold2)

        breathIn.text = viewModel.parameters.vdoh.toString()
        breathOut.text = viewModel.parameters.vidoh.toString()
        hold.text = viewModel.parameters.zadergka1.toString()
        hold2.text = viewModel.parameters.zadergka2.toString()

        view.findViewById<Button>(R.id.start).setOnClickListener { viewModel.startSession() }

    }
    fun checker(newValues: SessionParameters)
    {
        val breathIn = view?.findViewById<TextView>(R.id.breathIn)
        val breathOut = view?.findViewById<TextView>(R.id.breathOut)
        val hold = view?.findViewById<TextView>(R.id.hold1)
        val hold2 = view?.findViewById<TextView>(R.id.hold2)

        breathIn?.text = newValues.vdoh.toString()
        breathOut?.text = newValues.vidoh.toString()
        hold?.text = newValues.zadergka1.toString()
        hold2?.text = newValues.zadergka2.toString()
    }

    fun startOrNotToStart(value: Boolean)
    {
        view?.findViewById<Button>(R.id.start)?.isEnabled = value
    }

}