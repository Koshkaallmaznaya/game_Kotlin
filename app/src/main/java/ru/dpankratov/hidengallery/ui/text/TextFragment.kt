package ru.dpankratov.hidengallery.ui.text

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import ru.dpankratov.hidengallery.R
import ru.dpankratov.hidengallery.placeholder.PlaceholderContent

class TextFragment : Fragment() {

    companion object {
        fun newInstance() = TextFragment()
    }

    private lateinit var viewModel: TextViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_text, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TextViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button : Button = view.findViewById(R.id.textDone)
        val bundle = Bundle()
        val t :TextView = view.findViewById(R.id.textContent)
        val text = arguments?.getString("arg")
        t.text = text

        button.setOnClickListener {
            findNavController().navigate(R.id.listLevelFragment, bundle)
        }
    }
}