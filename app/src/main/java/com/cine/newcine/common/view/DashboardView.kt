package com.cine.newcine.common.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.toColor
import com.cine.newcine.common.px

/**
 *  @author zhangyao
 *  @date 2021/11/6  22:58
 *  @E-mail android_n@163.com
 */
//曲线半径
val RADIUS = 150f.px

//曲线框宽度
val STORK_WIDTH = 3f.px

//指针长度
val LENGTH = 120f.px

const val OPEN_ANGLE = 120f
val DASH_WIDTH = 2f.px
val DASH_HEIGHT = 10f.px


class DashboardView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var dash = Path()
    var path = Path()
    var pathMeasure = PathMeasure()
    lateinit var pathEffect : PathDashPathEffect

    init {
        dash.addRect(0f, 0f, DASH_WIDTH, DASH_HEIGHT, Path.Direction.CW)
        paint.strokeWidth = STORK_WIDTH
        paint.style = Paint.Style.STROKE

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        path.addArc(
            width / 2f - RADIUS + STORK_WIDTH,
            height / 2f - RADIUS + STORK_WIDTH,
            width / 2f + RADIUS - STORK_WIDTH,
            height / 2f + RADIUS - STORK_WIDTH,
            90 + OPEN_ANGLE / 2f,
            360 - OPEN_ANGLE
        )
        pathMeasure = PathMeasure(path, false)
        val pM = (pathMeasure.length - DASH_WIDTH) /20

        pathEffect =  PathDashPathEffect(dash, pM, 0f, PathDashPathEffect.Style.ROTATE)
    }


    override fun onDraw(canvas: Canvas) {
        paint.apply {
            color = Color.BLUE
        }

        //画弧
        canvas.drawPath(
            path,
            paint
        )
        paint.pathEffect = pathEffect

//        画刻度
        canvas.drawPath(
            path,
            paint
        )
        paint.pathEffect = null

        //画指针
        canvas.drawLine(width/2f, height/ 2f,
            width/2f + LENGTH, height/ 2f, paint)
    }
}