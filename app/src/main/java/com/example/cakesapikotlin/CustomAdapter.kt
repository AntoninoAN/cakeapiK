package com.example.cakesapikotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.squareup.picasso.Picasso

class CustomAdapter : RecyclerView.Adapter<CustomViewHolder>() {

    private var dataSet : List<CakePoko>? = null
    lateinit var dataSet2: ArrayList<CakePoko>

    fun setDataset(dataSet : List<CakePoko>){
        this.dataSet = dataSet
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {
        return CustomViewHolder(
            LayoutInflater.from(p0.context)
            .inflate(R.layout.item_layout, p0, false))
    }

    override fun getItemCount(): Int {
        return dataSet?.size ?: 0
    }

    override fun onBindViewHolder(p0: CustomViewHolder, p1: Int) {
        p0.setCake(dataSet?.get(p1))

        p0.tv_Desc.text = dataSet!![p1].desc
        p0.tv_Title.text = dataSet!![p1].title
        Picasso.get().load(dataSet!![p1].image).into(p0.iv_CakeImage)
    }
}