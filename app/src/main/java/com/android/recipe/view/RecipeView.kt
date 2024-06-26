package com.android.recipe.view

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.recipe.R
import com.android.recipe.model.ExpandableItem
import com.android.recipe.view.adapter.ExpandableAdapter


class RecipeView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_view)
        setStatusBarColor()

        val dummy = listOf(
            ExpandableItem(
                "nutrients",
                "Lorem ipsum dolor sit amet consectetur. Sagittis facilisis aliquet aenean lorem ullamcorper et. Risus lectus id sed fermentum in. At porta sed ut lorem volutpat elementum mi sollicitudin. Laoreet tempor nullam velit dui amet mauris sed ac sem."
            ),
            ExpandableItem(
                "nutrients",
                "Lorem ipsum dolor sit amet consectetur. Sagittis facilisis aliquet aenean lorem ullamcorper et. Risus lectus id sed fermentum in. At porta sed ut lorem volutpat elementum mi sollicitudin. Laoreet tempor nullam velit dui amet mauris sed ac sem."
            ),
            ExpandableItem(
                "nutrients",
                "Lorem ipsum dolor sit amet consectetur. Sagittis facilisis aliquet aenean lorem ullamcorper et. Risus lectus id sed fermentum in. At porta sed ut lorem volutpat elementum mi sollicitudin. Laoreet tempor nullam velit dui amet mauris sed ac sem."
            ),
            ExpandableItem(
                "nutrients",
                "Lorem ipsum dolor sit amet consectetur. Sagittis facilisis aliquet aenean lorem ullamcorper et. Risus lectus id sed fermentum in. At porta sed ut lorem volutpat elementum mi sollicitudin. Laoreet tempor nullam velit dui amet mauris sed ac sem."
            ),
            ExpandableItem(
                "nutrients",
                "Lorem ipsum dolor sit amet consectetur. Sagittis facilisis aliquet aenean lorem ullamcorper et. Risus lectus id sed fermentum in. At porta sed ut lorem volutpat elementum mi sollicitudin. Laoreet tempor nullam velit dui amet mauris sed ac sem."
            ),

        )

        val expandableAdapter = ExpandableAdapter(dummy)
        val expandable_rv = findViewById<RecyclerView>(R.id.expandable_recyclerview)
        expandable_rv.layoutManager = LinearLayoutManager(this)
        expandable_rv.adapter = expandableAdapter
    }

    private fun setStatusBarColor() {
        window?.apply {
            var statusBarColor = ContextCompat.getColor(this@RecipeView, R.color.white)
            this.statusBarColor = statusBarColor
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
        }
    }

}
