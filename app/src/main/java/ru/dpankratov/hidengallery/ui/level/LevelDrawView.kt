package ru.dpankratov.hidengallery.ui.level

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.Placeholder
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import ru.dpankratov.hidengallery.R
import ru.dpankratov.hidengallery.databinding.FragmentLevelBinding
import ru.dpankratov.hidengallery.placeholder.DatabaseHandler
import ru.dpankratov.hidengallery.placeholder.PlaceholderContent


class LevelDrawingView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private var drawPath: Path = Path()
    private var drawPaint: Paint = Paint()
    private var canvasPaint: Paint = Paint()
    private val paintColor = Color.TRANSPARENT
    private var drawCanvas: Canvas? = null
    private var canvasBitmap: Bitmap? = null
    private var pass: Boolean = false

    init {
        setupDrawing()
    }

    private fun setupDrawing() {
        drawPaint.color = paintColor
        drawPaint.isAntiAlias = true
        drawPaint.strokeWidth = 60F
        drawPaint.style = Paint.Style.STROKE
        drawPaint.strokeJoin = Paint.Join.ROUND
        drawPaint.strokeCap = Paint.Cap.ROUND
        canvasPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        drawPaint.setXfermode(PorterDuffXfermode(PorterDuff.Mode.SRC_OUT))
    }

    @SuppressLint("ResourceAsColor")
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        drawCanvas = Canvas(canvasBitmap!!)
        val test = Paint()
        test.apply {
            style = Paint.Style.FILL
            color = Color.RED
        }
        drawCanvas?.drawPaint(test)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawBitmap(canvasBitmap!!, 0F, 0F, canvasPaint)
        canvas?.drawPath(drawPath, drawPaint)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val touchX = event!!.x
        val touchY = event.y
        when (event.action) {
            MotionEvent.ACTION_DOWN -> drawPath.moveTo(touchX, touchY)
            MotionEvent.ACTION_MOVE -> drawPath.lineTo(touchX, touchY)
            MotionEvent.ACTION_UP -> {
                drawCanvas!!.drawPath(drawPath, drawPaint)
                drawPath.reset()
                canvasBitmap?.let { checkRed(it) }
            }
            else -> return false
        }
        invalidate()
        return true
    }

    fun checkRed(bitmap: Bitmap) {
        var redCount = 0
        val allPixels = bitmap.width * bitmap.height

        for (x in 0 until bitmap.width) {
            for (y in 0 until bitmap.height) {
                val pixel = bitmap.getPixel(x, y)
                if (Color.RED == pixel) {
                    redCount++
                }
            }
        }
        val Percentage = (redCount.toFloat() / allPixels.toFloat()) * 100
        val item = PlaceholderContent.currentLevel
        if (Percentage < 20 && !item?.pass!!) {
            item?.pass = true
            val _level = rootView.findViewById<Button>(R.id.textDone)
            _level.isVisible = true
            DatabaseHandler.getInstance().updateData(item.id, item.content, item.photo, item.pass)
        }
    }
}
//Log.i("eve", item?.pass.toString())