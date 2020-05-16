package dev.randallgreene.tvremote

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.text.InputType
import android.text.method.DigitsKeyListener
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider


class IpDialogFragment : DialogFragment() {

    private lateinit var viewModel: RemoteViewModel

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        viewModel = ViewModelProvider(requireActivity()).get(RemoteViewModel::class.java)

        val builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Set IP Address")

        val editText = EditText(requireContext())
        // restrict input to 0-9 and . because that is what an IP consists of
        editText.keyListener = DigitsKeyListener.getInstance("0123456789.")

        builder.setView(editText)

        builder.setPositiveButton("Confirm") { dialog, whichButton ->
            val ip = editText.text.toString()
            saveToSharedPreferences(ip)
            viewModel.updateIpAddress()
        }

        builder.setNegativeButton("Cancel") { dialog, whichButton ->
            // do nothing
        }

        return builder.show()
    }

    private fun saveToSharedPreferences(ipAddress: String) {
        val prefs = requireActivity().getSharedPreferences(
            USER_PREFS,
            Context.MODE_PRIVATE
        )

        prefs.edit().putString(IP_KEY, ipAddress).apply()
    }
}