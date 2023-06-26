package ru.dpankratov.hidengallery.placeholder

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
    arrayOf(1, "описание", "@drawable/photo_level_1", false), arrayOf(2, "описание", "@drawable/photo_level_2", false),
    arrayOf(3, "описание", "@drawable/photo_level_3", false), arrayOf(4, "описание", "@drawable/photo_level_3", false),
    arrayOf(5, "описание", "@drawable/photo_level_5", false), arrayOf(6, "описание", "@drawable/photo_level_6", false),
    arrayOf(7, "описание", "@drawable/photo_level_7", false), arrayOf(8, "описание", "@drawable/photo_level_8", false),
    arrayOf(9, "описание", "@drawable/photo_level_9", false), arrayOf(10, "описание", "@drawable/photo_level_10", false),
    arrayOf(11, "описание", "@drawable/photo_level_11", false), arrayOf(12, "описание", "@drawable/photo_level_12", false),
    arrayOf(13, "описание", "@drawable/photo_level_13", false), arrayOf(14, "описание", "@drawable/photo_level_14", false),
    arrayOf(15, "описание", "@drawable/photo_level_15", false), arrayOf(16, "описание", "@drawable/photo_level_16", false),
    arrayOf(17, "описание", "@drawable/photo_level_17", false), arrayOf(18, "описание", "@drawable/photo_level_18", false),
    arrayOf(19, "описание", "@drawable/photo_level_19", false), arrayOf(20, "описание", "@drawable/photo_level_20", false)
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

    private val COUNT = 20

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addItem(PlaceholderItem(i.toString(), "levels[i][1].toString()", "levels[i][2].toString()", true))
        }
    }

    private fun addItem(item: PlaceholderItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
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
    data class PlaceholderItem(val id: String, val content: String, val details: String, val pass: Boolean) {
        override fun toString(): String = content
    }
}