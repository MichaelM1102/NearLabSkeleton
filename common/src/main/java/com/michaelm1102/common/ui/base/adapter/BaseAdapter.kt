package com.michaelm1102.common.ui.base.adapter

import android.annotation.SuppressLint
import android.view.ScrollCaptureCallback
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import java.util.*


abstract class BaseAdapter<DATA, VH : RecyclerView.ViewHolder>(
    private val items: MutableList<DATA> = mutableListOf(),
) : RecyclerView.Adapter<VH>() {
    abstract val diffUtilsCallback: DiffUtil.ItemCallback<DATA>
    private val listDiffer = AsyncListDiffer(this, diffUtilsCallback)

    fun submitList(list:List<DATA>){
        listDiffer.submitList(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return createViewHolderInternal(parent, viewType)
    }


    override fun getItemCount(): Int = items.size

    abstract fun createViewHolderInternal(parent: ViewGroup, viewType: Int): VH

    fun getItemAtPosition(position: Int): DATA? = items.getOrNull(position)

    fun removeItemAtPosition(position: Int): DATA? = items.removeAt(position)


}
