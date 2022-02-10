package com.michaelm1102.common.ui.base.adapter

import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.RecyclerView


abstract class BaseLoadMoreInsideNestedScrollAdapter<DATA, VH : RecyclerView.ViewHolder>(
    items: MutableList<DATA?> = mutableListOf(),
    onLoadMoreListener: () -> Unit
) : BaseLoadMoreAdapter<DATA, VH>(items, onLoadMoreListener) {

    fun attachToNestedScrollView(nestedScrollView: NestedScrollView) {
        nestedScrollView.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, _, scrollY, _, _ ->
            if (isLoading || !isAllowLoadMore) return@OnScrollChangeListener
            if (scrollY == v.getChildAt(0).measuredHeight - v.measuredHeight) {
                invokeLoadMore()
            }
        })
    }

    override fun initLoadMore(recyclerView: RecyclerView) {
        // ignore recyclerview load
    }
}