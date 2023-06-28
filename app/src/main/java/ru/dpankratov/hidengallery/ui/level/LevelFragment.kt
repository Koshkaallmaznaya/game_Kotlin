package ru.dpankratov.hidengallery.ui.level
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import ru.dpankratov.hidengallery.R
import ru.dpankratov.hidengallery.databinding.FragmentLevelBinding
import ru.dpankratov.hidengallery.placeholder.PlaceholderContent

class LevelFragment : Fragment() {

    companion object {
        private const val LEVEL_ID = "levelId"
        @JvmStatic
        fun newInstance(levelId: Int) = LevelFragment().apply {
            arguments = Bundle().apply {
                putInt(LEVEL_ID, levelId)
            }
        }
    }

    private var levelId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            levelId = it.getInt(LEVEL_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val item = PlaceholderContent.getItem(levelId)
        PlaceholderContent.currentLevel = item
        return FragmentLevelBinding.inflate(
            inflater,
            container,
            false
        ).apply {
            imageView2.setImageResource(item?.photo!!)
            textDone.isVisible = item?.pass == true
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button : Button = view.findViewById(R.id.textDone)
        val item = PlaceholderContent.getItem(levelId)
        val text = item?.content
        val bundle = Bundle()

        button.setOnClickListener {
            bundle.putString("arg", text)
            findNavController().navigate(R.id.textFragment, bundle)
        }
    }
}