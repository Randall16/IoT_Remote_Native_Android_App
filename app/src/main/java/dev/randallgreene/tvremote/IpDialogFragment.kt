package dev.randallgreene.tvremote

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.text.method.DigitsKeyListener
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider


class IpDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val viewModel = ViewModelProvider(requireActivity()).get(RemoteViewModel::class.java)

        val builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Set IP Address")

        val editText = EditText(requireContext())
        // restrict input to 0-9 and . because that is what an IP consists of
        editText.keyListener = DigitsKeyListener.getInstance("0123456789.")

        builder.setView(editText)

        builder.setPositiveButton("Confirm") { dialog, whichButton ->
            val ip = editText.text.toString()
            viewModel.updateIpAddress(ip)
        }

        builder.setNegativeButton("Cancel") { dialog, whichButton ->
            // do nothing
        }

        return builder.show()
    }
}