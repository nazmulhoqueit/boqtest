package com.boqtest.boqtest.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.boqtest.boqtest.domain.models.Photo
import com.example.boqtest.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_image.view.*

class PhotoAdapter(private val c: Context, private val images: ArrayList<Photo>) : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(
            LayoutInflater.from(c).inflate(R.layout.item_image, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val image = images[position]

        Picasso.get()
            .load("http://farm5.static.flickr.com/${image.server}/${image.id}_${image.secret}.jpg")
            .placeholder(R.drawable.loading_animation)
            .error(R.drawable.ic_broken_image)
            .resize(300, 300)
            .centerCrop()
            .into(holder.iv)

        holder.text_photo_title.text = image.title
    }

    class PhotoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val iv = view.iv as ImageView
        val text_photo_title = view.text_photo_title as TextView
    }
}
