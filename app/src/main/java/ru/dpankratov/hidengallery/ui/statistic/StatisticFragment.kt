package ru.dpankratov.hidengallery.ui.statistic

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.dpankratov.hidengallery.R
import ru.dpankratov.hidengallery.databinding.FragmentLevelBinding
import ru.dpankratov.hidengallery.databinding.FragmentStatisticBinding
import ru.dpankratov.hidengallery.placeholder.PlaceholderContent

class StatisticFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentStatisticBinding.inflate(
            inflater,
            container,
            false
        ).apply {
            statisticText.text = PlaceholderContent.getStatisticsString()
        }.root
    }


}