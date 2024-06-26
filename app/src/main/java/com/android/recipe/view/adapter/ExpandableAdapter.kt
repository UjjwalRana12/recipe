package com.android.recipe.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.android.recipe.R
import com.android.recipe.model.ExpandableItem
import com.android.recipe.model.RecipeItem
import com.bumptech.glide.Glide

class ExpandableAdapter(private val itemList: List<ExpandableItem>) : RecyclerView.Adapter<ExpandableAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val heading: TextView = itemView.findViewById(R.id.heading)
        val desc: TextView = itemView.findViewById(R.id.expandabletv)
        val constraint:ConstraintLayout=itemView.findViewById(R.id.newConstraint)

        fun collapseExpandedView(){
            desc.visibility=View.GONE
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.expandable_view, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.heading.text = currentItem.heading
        holder.desc.text=currentItem.about

        val isExpandable:Boolean=currentItem.isExpandable
        holder.desc.visibility=if(isExpandable) View.VISIBLE else View.GONE

        holder.constraint.setOnClickListener {
            isAnyItemExpanded(position)
            currentItem.isExpandable=!currentItem.isExpandable
            notifyItemChanged(position)
        }




//        Glide.with(holder.itemView.context)
//            .load(currentItem.imageUrl)
//
//            .into(holder.recipeImage)

    }

    private fun isAnyItemExpanded(position: Int) {
        val temp=itemList.indexOfFirst {
            it.isExpandable
        }

        if(temp>=0&&temp!=position){
            itemList[temp].isExpandable=false
            notifyItemChanged(temp,0)
        }

    }

    override fun onBindViewHolder(
        holder: ItemViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if(payloads.isNotEmpty() && payloads[0]==0){
                holder.collapseExpandedView()
        }else{
            super.onBindViewHolder(holder, position, payloads)
        }

    }

    override fun getItemCount() = itemList.size
}

