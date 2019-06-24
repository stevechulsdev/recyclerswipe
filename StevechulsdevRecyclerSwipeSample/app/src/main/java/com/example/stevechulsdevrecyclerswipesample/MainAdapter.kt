package com.example.stevechulsdevrecyclerswipesample

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MainAdapter(val mContext: Context, val fruitsList: ArrayList<String>): RecyclerView.Adapter<MainAdapter.ViewHoler>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoler {
        val view = LayoutInflater.from(mContext).inflate(R.layout.cell_main, parent, false)
        return ViewHoler(view)
    }

    override fun onBindViewHolder(holder: ViewHoler, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return fruitsList.size
    }

    fun removeItemToSwipe(position: Int) {
        fruitsList.removeAt(position)
        notifyItemRemoved(position)
    }

    inner class ViewHoler(view: View): RecyclerView.ViewHolder(view) {
        private val textView = view.findViewById(R.id.tv_text) as TextView

        fun bind(position: Int) {
            textView.text = fruitsList[position]
        }
    }

}