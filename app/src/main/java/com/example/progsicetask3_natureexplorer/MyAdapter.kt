package com.example.progsicetask3_natureexplorer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

class MyAdapter(
    private val list: List<Item>,
    private val onClick: (Item) -> Unit
) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.cardTitle)
        val desc: TextView = view.findViewById(R.id.cardDesc)
        val image: ImageView = view.findViewById(R.id.cardImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        holder.title.text = item.title
        holder.desc.text = item.description
        holder.image.setImageResource(item.image)

        holder.itemView.setOnClickListener {
            onClick(item)
        }
    }
}