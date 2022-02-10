package com.michaelm1102.common.ui.base.adapter

import androidx.recyclerview.widget.RecyclerView


abstract class BaseSelectionAdapter<DATA, VH : RecyclerView.ViewHolder>(
    items: MutableList<DATA> = mutableListOf(),
) : BaseAdapter<DATA, VH>(items) {
    @SelectionMode
    var selectionMode = SINGLE
    val selectedPosition = hashSetOf<Int>()

    fun setMode(@SelectionMode mode: String): BaseSelectionAdapter<DATA, VH> {
        this.selectionMode = mode
        return this
    }

    fun isSelected(position: Int): Boolean {
        return selectedPosition.contains(position)
    }


    fun setData(newItems: List<DATA>?) {
        this.selectedPosition.clear()
        super.submitList(newItems ?: listOf())
    }

    fun toggleSelection(position: Int) {
        when (selectionMode) {
            SINGLE -> {
                if (selectedPosition.contains(position)) {
                    selectedPosition.clear()
                    notifyItemChanged(position)
                } else {
                    val prevPosition = selectedPosition.firstOrNull()
                    selectedPosition.clear()
                    selectedPosition.add(position)
                    notifyItemChanged(position)
                    if (prevPosition != null && prevPosition != -1) {
                        notifyItemChanged(prevPosition)
                    }
                }
            }

            MULTI -> {
                if (selectedPosition.contains(position)) {
                    selectedPosition.remove(position)
                    notifyItemChanged(position)
                } else {
                    selectedPosition.add(position)
                    notifyItemChanged(position)
                }
            }
        }
    }

    fun clearAll() {
        val temp = selectedPosition.toList()
        selectedPosition.clear()
        temp.forEach {
            if (it != 0 && it < itemCount) notifyItemChanged(it)
        }
    }

    companion object {
        const val SINGLE = "Single"
        const val MULTI = "Multi"
    }
}

