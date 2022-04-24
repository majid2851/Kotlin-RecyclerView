package com.example.kotlin_recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.pattern_rv.view.*

class RvAdapter () : RecyclerView.Adapter<RvAdapter.MyViewHolder>()
{
    lateinit var context: Context;
    private var items:List<MyModel> = ArrayList()

    constructor(items:List<MyModel>,context: Context) : this()
    {
        this.context=context;
        this.items=items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view=LayoutInflater.from(context).inflate(R.layout.pattern_rv,parent,false)
        return MyViewHolder(view);

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        when(holder){
            is MyViewHolder ->{
                var model=items.get(position);
                holder.blogTitle.setText(model.title)
                holder.blogAuthor.setText(model.userName)
                Picasso.get().load(model.img).into(holder.blogImage)
            }
        }


    }

    override fun getItemCount(): Int {
        return items.size
    }


    class MyViewHolder constructor(v:View) : RecyclerView.ViewHolder(v){
        val blogImage =v.blog_image
        val blogTitle=v.blog_title
        val blogAuthor=v.blog_author

    }
}