package com.android.recipe.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.recipe.R
import com.android.recipe.model.RecipeItem
import com.bumptech.glide.Glide

class RecipeAdapter(private val itemList: List<RecipeItem>) : RecyclerView.Adapter<RecipeAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recipeImage:ImageView=itemView.findViewById(R.id.recipe_iv)
        val recipeName: TextView = itemView.findViewById(R.id.recipe_name)
        val recipeTime: TextView = itemView.findViewById(R.id.recipe_time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recipe_layout, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.recipeName.text = currentItem.recipe
        holder.recipeTime.text = currentItem.time

//        Glide.with(holder.itemView.context)
//            .load(currentItem.imageUrl)
//
//            .into(holder.recipeImage)

        holder.recipeImage.setImageResource(currentItem.imageUrl)
   }

    override fun getItemCount() = itemList.size
}

