package com.example.lab2.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.lab2.model.entity.Dog

class DogsDiffUtil( private val oldList: List<Dog>, private val newList: List<Dog>): DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].name == newList[newItemPosition].name
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }


    override fun getOldListSize(): Int { return oldList.size
    }
    override fun getNewListSize(): Int {
        return newList.size
    }
}