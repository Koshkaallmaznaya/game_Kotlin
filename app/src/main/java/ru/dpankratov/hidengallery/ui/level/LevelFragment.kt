package ru.dpankratov.hidengallery.ui.level

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.dpankratov.hidengallery.R

class LevelFragment : Fragment() {

    companion object {
        fun newInstance() = LevelFragment()
    }

    private lateinit var viewModel: LevelViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_level, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LevelViewModel::class.java)
        // TODO: Use the ViewModel
    }

}