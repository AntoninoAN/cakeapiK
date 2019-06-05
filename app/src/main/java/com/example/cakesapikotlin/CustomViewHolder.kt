package com.example.cakesapikotlin

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_layout.view.*

class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var tv_Title = itemView.tv_title
    var tv_Desc = itemView.tv_desc
    var iv_CakeImage = itemView.iv_cake_image


    fun setCake(cakePoko: CakePoko?) {
        Picasso.get().load(cakePoko?.image).into(
            itemView.iv_cake_image
        )
        itemView.tv_title.text = cakePoko?.title
        itemView.tv_desc.text = cakePoko?.desc
    }
}