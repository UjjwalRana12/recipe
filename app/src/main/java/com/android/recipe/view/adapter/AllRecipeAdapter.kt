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

class AllRecipeAdapter(private val list: List<RecipeItem>) : RecyclerView.Adapter<AllRecipeAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recipeImage:ImageView=itemView.findViewById(R.id.recipeImage)
        val recipeName: TextView = itemView.findViewById(R.id.recipetvname)
        val recipeTime: TextView = itemView.findViewById(R.id.recipetimetv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.all_recipe_layout, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = list[position]
        holder.recipeName.text = currentItem.recipe
        holder.recipeTime.text = currentItem.time

//        Glide.with(holder.itemView.context)
//            .load(currentItem.imageUrl)
//
//            .into(holder.recipeImage)

        holder.recipeImage.setImageResource(currentItem.imageUrl)
    }

    override fun getItemCount() = list.size
}

