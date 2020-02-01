package dev.randallgreene.tvremote

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton


class RemoteFragment : Fragment() {

    private lateinit var viewModel: RemoteViewModel

    private lateinit var buttonZero: Button
    private lateinit var buttonOne: Button
    private lateinit var buttonTwo: Button
    private lateinit var buttonThree: Button
    private lateinit var buttonFour: Button
    private lateinit var buttonFive: Button
    private lateinit var buttonSix: Button
    private lateinit var buttonSeven: Button
    private lateinit var buttonEight: Button
    private lateinit var buttonNine: Button

    private lateinit var buttonPower: ImageButton
    private lateinit var buttonVolUp: Button
    private lateinit var buttonVolDown: Button
    private lateinit var buttonChUp: Button
    private lateinit var buttonChDown: Button
    private lateinit var buttonMute: ImageButton
    private lateinit var buttonInput: Button

    private lateinit var buttonEnter: Button
    private lateinit var buttonUp: ImageButton
    private lateinit var buttonDown: ImageButton
    private lateinit var buttonRight: ImageButton
    private lateinit var buttonLeft: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.remote_fragment, container, false)

        findViews(view)
        attachListeners()
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RemoteViewModel::class.java)
    }

    private fun findViews(view: View) {
        buttonLeft = view.findViewById(R.id.buttonLeft)
        buttonLeft.rotation = 270f

        buttonRight = view.findViewById(R.id.buttonRight)
        buttonRight.rotation = 90f

        buttonZero = view.findViewById(R.id.button0)
        buttonOne = view.findViewById(R.id.button1)
        buttonTwo = view.findViewById(R.id.button2)
        buttonThree = view.findViewById(R.id.button3)
        buttonFour = view.findViewById(R.id.button4)
        buttonFive = view.findViewById(R.id.button5)
        buttonSix = view.findViewById(R.id.button6)
        buttonSeven = view.findViewById(R.id.button7)
        buttonEight = view.findViewById(R.id.button8)
        buttonNine = view.findViewById(R.id.button9)

        buttonPower = view.findViewById(R.id.buttonPower)
        buttonVolUp = view.findViewById(R.id.buttonVolUp)
        buttonVolDown = view.findViewById(R.id.buttonVolDown)
        buttonChUp = view.findViewById(R.id.buttonChUp)
        buttonChDown = view.findViewById(R.id.buttonChDown)
        buttonMute = view.findViewById(R.id.buttonMute)
        buttonInput = view.findViewById(R.id.buttonInput)

        buttonEnter = view.findViewById(R.id.buttonEnter)
        buttonUp = view.findViewById(R.id.buttonUp)
        buttonDown = view.findViewById(R.id.buttonDown)
    }

    private fun attachListeners() {
        buttonPower.setOnClickListener {
            viewModel.sendPower()
        }

        buttonVolUp.setOnClickListener {
            viewModel.sendVolumeUp()
        }

        buttonVolDown.setOnClickListener {
            viewModel.sendVolumeDown()
        }

        buttonChUp.setOnClickListener {
            viewModel.sendChannelUp()
        }

        buttonChDown.setOnClickListener {
            viewModel.sendChannelDown()
        }

        buttonMute.setOnClickListener {
            viewModel.sendMute()
        }

        buttonInput.setOnClickListener {
            viewModel.sendInput()
        }

        buttonUp.setOnClickListener {
            viewModel.sendUp()
        }

        buttonDown.setOnClickListener {
            viewModel.sendDown()
        }

        buttonRight.setOnClickListener {
            viewModel.sendRight()
        }

        buttonLeft.setOnClickListener {
            viewModel.sendLeft()
        }

        buttonEnter.setOnClickListener {
            viewModel.sendSelect()
        }

        buttonZero.setOnClickListener {
            viewModel.sendZero()
        }

        buttonOne.setOnClickListener {
            viewModel.sendOne()
        }

        buttonTwo.setOnClickListener {
            viewModel.sendTwo()
        }

        buttonThree.setOnClickListener {
            viewModel.sendThree()
        }

        buttonFour.setOnClickListener {
            viewModel.sendFour()
        }

        buttonFive.setOnClickListener {
            viewModel.sendFive()
        }

        buttonSix.setOnClickListener {
            viewModel.sendSix()
        }

        buttonSeven.setOnClickListener {
            viewModel.sendSeven()
        }

        buttonEight.setOnClickListener {
            viewModel.sendEight()
        }

        buttonNine.setOnClickListener {
            viewModel.sendNine()
        }
    }

}
