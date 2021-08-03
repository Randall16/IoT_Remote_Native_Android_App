package dev.randallgreene.tvremote

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subscribeToViewModel()
    }

    private fun subscribeToViewModel() {

        viewModel = ViewModelProvider(requireActivity()).get(RemoteViewModel::class.java)

        // Adding logic to vibrate upon successful API request
        val vibrator = requireActivity().getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        val vibrationTime: Long = 25

        val toast = Toast.makeText(
            requireContext(),
            "Request failed. Make sure Wifi is on and the proper IP address is set.",
            Toast.LENGTH_LONG
        )

        viewModel.requestSuccess.observe(viewLifecycleOwner, {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(
                    vibrationTime,
                    VibrationEffect.DEFAULT_AMPLITUDE)
                )
            } else {
                //deprecated in API 26
                vibrator.vibrate(vibrationTime)
            }
        })

        viewModel.requestFailure.observe(viewLifecycleOwner, {
            toast.show()
        })
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
            viewModel.sendButton(RemoteButton.POWER)
        }

        buttonVolUp.setOnClickListener {
            viewModel.sendButton(RemoteButton.VOLUME_UP)
        }

        buttonVolDown.setOnClickListener {
            viewModel.sendButton(RemoteButton.VOLUME_DOWN)
        }

        buttonChUp.setOnClickListener {
            viewModel.sendButton(RemoteButton.CHANNEL_UP)
        }

        buttonChDown.setOnClickListener {
            viewModel.sendButton(RemoteButton.CHANNEL_DOWN)
        }

        buttonMute.setOnClickListener {
            viewModel.sendButton(RemoteButton.MUTE)
        }

        buttonInput.setOnClickListener {
            viewModel.sendButton(RemoteButton.INPUT)
        }

        buttonUp.setOnClickListener {
            viewModel.sendButton(RemoteButton.UP)
        }

        buttonDown.setOnClickListener {
            viewModel.sendButton(RemoteButton.DOWN)
        }

        buttonRight.setOnClickListener {
            viewModel.sendButton(RemoteButton.RIGHT)
        }

        buttonLeft.setOnClickListener {
            viewModel.sendButton(RemoteButton.LEFT)
        }

        buttonEnter.setOnClickListener {
            viewModel.sendButton(RemoteButton.SELECT)
        }

        buttonZero.setOnClickListener {
            viewModel.sendButton(RemoteButton.ZERO)
        }

        buttonOne.setOnClickListener {
            viewModel.sendButton(RemoteButton.ONE)
        }

        buttonTwo.setOnClickListener {
            viewModel.sendButton(RemoteButton.TWO)
        }

        buttonThree.setOnClickListener {
            viewModel.sendButton(RemoteButton.THREE)
        }

        buttonFour.setOnClickListener {
            viewModel.sendButton(RemoteButton.FOUR)
        }

        buttonFive.setOnClickListener {
            viewModel.sendButton(RemoteButton.FIVE)
        }

        buttonSix.setOnClickListener {
            viewModel.sendButton(RemoteButton.SIX)
        }

        buttonSeven.setOnClickListener {
            viewModel.sendButton(RemoteButton.SEVEN)
        }

        buttonEight.setOnClickListener {
            viewModel.sendButton(RemoteButton.EIGHT)
        }

        buttonNine.setOnClickListener {
            viewModel.sendButton(RemoteButton.NINE)
        }
    }

}
