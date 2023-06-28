package ru.dpankratov.hidengallery.placeholder
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1){

    companion object {
        const val DATABASE_NAME = "hiddenGallery.db"
        const val TABLE_NAME = "pictures"
        const val ID = "ID"
        const val CONTENT = "CONTENT"
        const val PHOTOID = "PHOTOID"
        const val PASS = "PASS"
        private lateinit var instance: DatabaseHandler
        fun init(context: Context) {
            instance = DatabaseHandler(context)
        }
        
        fun getInstance(): DatabaseHandler {
            return instance
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("create table $TABLE_NAME (ID INTEGER PRIMARY KEY AUTOINCREMENT, CONTENT TEXT, PHOTOID INTEGER, PASS BOOLEAN)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun insertData(content: String, photoid: Int, pass: Boolean) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(CONTENT, content)
        contentValues.put(PHOTOID, photoid)
        contentValues.put(PASS, pass)
        db.insert(TABLE_NAME, null, contentValues)
    }

    fun updateData(id: Int, content: String, photoid: Int, pass: Boolean): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(CONTENT, content)
        contentValues.put(PHOTOID, photoid)
        contentValues.put(PASS, pass)
        db.update(TABLE_NAME, contentValues, "ID = ?", arrayOf(id.toString()))
        return true
    }

    fun listOfPictures(): ArrayList<PlaceholderContent.PlaceholderItem>  {
        val db = this.writableDatabase
        val res = db.rawQuery("select ID, CONTENT, PHOTOID, PASS from " + TABLE_NAME, null)
        val list = ArrayList<PlaceholderContent.PlaceholderItem>()
        while (res.moveToNext()) {
            var picture = PlaceholderContent.PlaceholderItem(
                res.getInt(0),
                res.getString(1),
                res.getInt(2),
                res.getInt(3) > 0,
            )
            list.add(picture)
        }
        return list
    }

    fun get(id: Int): PlaceholderContent.PlaceholderItem? {
        val db = this.writableDatabase
        val res = db.rawQuery("select ID, CONTENT, PHOTOID, PASS from " + TABLE_NAME + " WHERE ID = ? limit 1", arrayOf(id.toString()))
        if (res.count == 1 ) {
            res.moveToFirst()
            return PlaceholderContent.PlaceholderItem(
                res.getInt(0),
                res.getString(1),
                res.getInt(2),
                res.getInt(3) > 0,
            )
        }
        return null
    }

    fun getCount(): Int {
        val db = this.writableDatabase
        val res = db.rawQuery("select ID from " + TABLE_NAME, null)
        return res.count
    }

    fun getPass(): Int {
        val db = this.writableDatabase
        val res = db.rawQuery("select ID from " + TABLE_NAME + " where PASS = true", null)
        return res.count
    }
}