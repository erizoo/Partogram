package com.boiko.app.utils

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View

class DividerItemDecoration : RecyclerView.ItemDecoration {

    private val divider: Drawable?
    private var isNeedShowFirst = false
    private var isVerticallyList = true

    companion object {
        private val ATTRS = intArrayOf(android.R.attr.listDivider)
    }

    /**
     * Default divider will be used
     */
    constructor(context: Context) {
        val styledAttributes = context.obtainStyledAttributes(ATTRS)
        divider = styledAttributes.getDrawable(0)
        styledAttributes.recycle()
    }

    /**
     * Custom divider will be used
     */
    constructor(context: Context, resId: Int, isNeedShowFirst: Boolean = false, isVerticallyList: Boolean = true) {
        divider = ContextCompat.getDrawable(context, resId)
        this.isNeedShowFirst = isNeedShowFirst
        this.isVerticallyList = isVerticallyList
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val childCount = parent.childCount - 1

        for (i in 0 until childCount) {
            if (!isNeedShowFirst && i == 0) continue

            if (isVerticallyList)
                drawVertically(c, parent, i)
            else
                drawHorizontally(c, parent, i)
        }
    }

    private fun drawVertically(
        c: Canvas,
        parent: RecyclerView,
        childIndex: Int
    ) {
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight

        val child = parent.getChildAt(childIndex)

        val params = child.layoutParams as RecyclerView.LayoutParams

        val top = child.bottom + params.bottomMargin
        val bottom = top + divider!!.intrinsicHeight

        divider.setBounds(left, top, right, bottom)
        divider.draw(c)
    }

    private fun drawHorizontally(c: Canvas, parent: RecyclerView, childIndex: Int) {
        val top = parent.paddingTop
        val bottom = parent.height - parent.paddingBottom

        val child = parent.getChildAt(childIndex)

        val params = child.layoutParams as RecyclerView.LayoutParams

        val left = child.right + params.rightMargin
        val right = left + divider!!.intrinsicWidth

        divider.setBounds(left, top, right, bottom)
        divider.draw(c)
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        if (isVerticallyList) {
            outRect.set(0, 0, 0, divider!!.intrinsicHeight)
        } else {
            outRect.set(0, 0, divider!!.intrinsicWidth, 0)
        }

        if (!isNeedShowFirst && parent.getChildAdapterPosition(view) == 0)
            outRect.set(0, 0, 0, 0)

        if (parent.getChildAdapterPosition(view) == parent.adapter?.itemCount?.minus(1) ?: -1)
            outRect.set(0, 0, 0, 0)
    }
}
