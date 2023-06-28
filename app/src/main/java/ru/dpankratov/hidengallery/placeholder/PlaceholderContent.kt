package ru.dpankratov.hidengallery.placeholder
import ru.dpankratov.hidengallery.R
import kotlin.collections.ArrayList

object PlaceholderContent {
    private val levels = arrayOf(
        PlaceholderItem(1, "описание", R.drawable.photo_level_1, false), PlaceholderItem(2, "описание", R.drawable.photo_level_2, false),
        PlaceholderItem(3, "описание", R.drawable.photo_level_3, false), PlaceholderItem(4, "описание", R.drawable.photo_level_4, false),
        PlaceholderItem(5, "описание", R.drawable.photo_level_5, false), PlaceholderItem(6, "описание", R.drawable.photo_level_6, false),
        PlaceholderItem(7, "описание", R.drawable.photo_level_7, false), PlaceholderItem(8, "описание", R.drawable.photo_level_8, false),
        PlaceholderItem(9, "описание", R.drawable.photo_level_9, false), PlaceholderItem(10, "описание", R.drawable.photo_level_10, false),
        PlaceholderItem(11, "описание", R.drawable.photo_level_11, false), PlaceholderItem(12, "описание", R.drawable.photo_level_12, false),
        PlaceholderItem(13, "описание", R.drawable.photo_level_13, false), PlaceholderItem(14, "описание", R.drawable.photo_level_14, false),
        PlaceholderItem(15, "описание", R.drawable.photo_level_15, false), PlaceholderItem(16, "описание", R.drawable.photo_level_16, false),
        PlaceholderItem(17, "описание", R.drawable.photo_level_17, false), PlaceholderItem(18, "описание", R.drawable.photo_level_18, false),
        PlaceholderItem(19, "описание", R.drawable.photo_level_19, false), PlaceholderItem(20, "описание", R.drawable.photo_level_20, false)
    )

    public var currentLevel: PlaceholderItem? = null

    fun update() {
        if (getCount() == 0) {
            for (item in levels)
                DatabaseHandler.getInstance().insertData(item.content, item.photo, item.pass)
        }
    }

    fun getItem(id: Int): PlaceholderItem? {
        return DatabaseHandler.getInstance().get(id)
    }

    private fun getCount(): Int? {
        return DatabaseHandler.getInstance().getCount()
    }

    private fun getPass(): Int? {
        return DatabaseHandler.getInstance().getPass()
    }

    fun getStatisticsString(): String {
        return "Открыто " + getPass() + " \n из " + getCount()
    }

    fun getList(): ArrayList<PlaceholderItem>? {
        return DatabaseHandler.getInstance().listOfPictures()
    }

    data class PlaceholderItem(val id: Int, val content: String, val photo: Int, var pass: Boolean) {
        override fun toString(): String = content
    }
}