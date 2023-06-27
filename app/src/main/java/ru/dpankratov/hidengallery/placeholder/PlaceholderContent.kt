package ru.dpankratov.hidengallery.placeholder

import ru.dpankratov.hidengallery.R
import java.util.ArrayList
import java.util.HashMap
import kotlin.reflect.typeOf

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
val levels = arrayOf(
    PlaceholderContent.PlaceholderItem(1, "описание", R.drawable.photo_level_1, true), PlaceholderContent.PlaceholderItem(2, "описание", R.drawable.photo_level_2, false),
    PlaceholderContent.PlaceholderItem(3, "описание", R.drawable.photo_level_3, false), PlaceholderContent.PlaceholderItem(4, "описание", R.drawable.photo_level_4, false),
    PlaceholderContent.PlaceholderItem(5, "описание", R.drawable.photo_level_5, false), PlaceholderContent.PlaceholderItem(6, "описание", R.drawable.photo_level_6, false),
    PlaceholderContent.PlaceholderItem(7, "описание", R.drawable.photo_level_7, false), PlaceholderContent.PlaceholderItem(8, "описание", R.drawable.photo_level_8, false),
    PlaceholderContent.PlaceholderItem(9, "описание", R.drawable.photo_level_9, false), PlaceholderContent.PlaceholderItem(10, "описание", R.drawable.photo_level_10, false),
    PlaceholderContent.PlaceholderItem(11, "описание", R.drawable.photo_level_11, false), PlaceholderContent.PlaceholderItem(12, "описание", R.drawable.photo_level_12, false),
    PlaceholderContent.PlaceholderItem(13, "описание", R.drawable.photo_level_13, false), PlaceholderContent.PlaceholderItem(14, "описание", R.drawable.photo_level_14, false),
    PlaceholderContent.PlaceholderItem(15, "описание", R.drawable.photo_level_15, false), PlaceholderContent.PlaceholderItem(16, "описание", R.drawable.photo_level_16, false),
    PlaceholderContent.PlaceholderItem(17, "описание", R.drawable.photo_level_17, false), PlaceholderContent.PlaceholderItem(18, "описание", R.drawable.photo_level_18, false),
    PlaceholderContent.PlaceholderItem(19, "описание", R.drawable.photo_level_19, false), PlaceholderContent.PlaceholderItem(20, "описание", R.drawable.photo_level_20, false)
)

object PlaceholderContent {

    /**
     * An array of sample (placeholder) items.
     */
    val ITEMS: MutableList<PlaceholderItem> = ArrayList()

    /**
     * A map of sample (placeholder) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, PlaceholderItem> = HashMap()

    //private val COUNT = 20

    init {
        // Add some sample items.
        for (i in 0..levels.size-1) {
            addItem(levels[i])
        }
    }

    private fun addItem(item: PlaceholderItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id.toString(), item)
    }

    //private fun createPlaceholderItem(position: Int): PlaceholderItem {
        //return PlaceholderItem(position.toString(), "Item " + position, makeDetails(position))
    //}

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0..position - 1) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }

    /**
     * A placeholder item representing a piece of content.
     */
    data class PlaceholderItem(val id: Int, val content: String, val photo: Int, val pass: Boolean) {
        override fun toString(): String = content
    }
}