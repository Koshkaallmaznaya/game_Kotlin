package ru.dpankratov.hidengallery.ui.level
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
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
}