package com.ubisoft.dihaniedlyaozabochennih.breathsession.viewModel

import android.os.CountDownTimer
import com.ubisoft.dihaniedlyaozabochennih.breathsession.SessionParameters
import com.ubisoft.dihaniedlyaozabochennih.breathsession.view.BreathFragment

class BreathNewModel1
{
    val parameters = SessionParameters(
        30,
        8,
        7,
        3,
        3
    )

    val currentParameters = parameters.copy()

    var listener: BreathFragment? = null

    var timer: CountDownTimer? = null

    fun startSession()
    {
        timer = object: CountDownTimer(
            parameters.fulltime *1000L,
            1000)
        {
            override fun onTick(p0: Long)
            {
                update()
                listener?.checker(currentParameters)
            }

            override fun onFinish()
            {

            }
        }
        timer?.start()
        listener?.startOrNotToStart(false)
    }

    fun update()
    {
        currentParameters.fulltime -= 1
        currentParameters.vdoh -= 1

        if (currentParameters.vdoh > 0)
        {
            currentParameters.vdoh -= 1
        } else if (currentParameters.zadergka1 > 0)
            {
                currentParameters.zadergka1 -= 1
            } else if (currentParameters.vidoh > 0)
                {
                    currentParameters.vidoh -= 1
                } else if (currentParameters.zadergka2 > 0)
                    {
                        currentParameters.zadergka2 -= 1
                    }
        if (currentParameters.zadergka2 == 0)
        {
            currentParameters.vdoh = parameters.vdoh
            currentParameters.vidoh = parameters.vidoh
            currentParameters.zadergka1 = parameters.zadergka1
            currentParameters.zadergka2 = parameters.zadergka2
        }
    }
}