package com.android.recipe.view.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.recipe.R
import com.android.recipe.model.RecipeItem
import com.android.recipe.view.RecipeView
import com.android.recipe.view.adapter.AllRecipeAdapter
import com.android.recipe.view.adapter.RecipeAdapter

class Home : Fragment() {

    val list = listOf(
        RecipeItem(R.drawable.paneer," sahi paneer", "take within 20min"),
        RecipeItem(R.drawable.paneer," sahi paneer", "take within 20min"),
        RecipeItem(R.drawable.paneer," sahi paneer", "take within 20min"),
    )

    val dummylist = listOf(
        RecipeItem(R.drawable.paneer," sahi paneer", "take within 34min"),
        RecipeItem(R.drawable.paneer," sahi paneer", "take within 34min"),
        RecipeItem(R.drawable.paneer," sahi paneer", "take within 34min"),
        )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recipeCardAdapter = RecipeAdapter(list)
      val recyclerview = view.findViewById<RecyclerView>(R.id.popular_recipes)
        recyclerview.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        recyclerview.adapter=recipeCardAdapter


        val allRecipeAdapter=AllRecipeAdapter(dummylist)
        val allRecyclerView = view.findViewById<RecyclerView>(R.id.all_recycler_view)
        allRecyclerView.layoutManager=LinearLayoutManager(context)
        allRecyclerView.adapter=allRecipeAdapter

        allRecipeAdapter.onItemClick={
            val intent=Intent(requireContext(),RecipeView::class.java)
            startActivity(intent)
        }

    }
}