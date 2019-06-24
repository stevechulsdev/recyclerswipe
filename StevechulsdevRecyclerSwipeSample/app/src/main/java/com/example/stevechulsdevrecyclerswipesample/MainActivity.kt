package com.example.stevechulsdevrecyclerswipesample

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import co.kimjiminand.recyclerswipe.SwipeHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

   private val fruitsList = arrayListOf("Apple", "Banana", "Orange", "Mango", "Cherry", "Lemon", "Melon", "Lime", "Pineapple", "Strawberry")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = MainAdapter(this, fruitsList)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)

        object : SwipeHelper(this, recycler) {
            override fun instantiateUnderlayButton(
                viewHolder: RecyclerView.ViewHolder,
                underlayButtons: MutableList<UnderlayButton>) {
                // icon resource, icon with, icon height, button width, button background color, clickListener, context
                    underlayButtons.add(
                        UnderlayButton(R.drawable.icon_garbage, 250, 250, 200,
                            Color.parseColor("#e5001b"),
                            UnderlayButtonClickListener { pos ->
                                recycler.adapter?.notifyItemChanged(pos)
                                adapter.removeItemToSwipe(pos)
                            }, this@MainActivity
                        )
                    )
            }
        }
    }
}
