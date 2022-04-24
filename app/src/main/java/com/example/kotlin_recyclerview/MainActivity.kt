package com.example.kotlin_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.rv.layoutManager=LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        binding.rv.adapter=RvAdapter(DataSource.createData(),this)
        val topSpace=TimeSpacingItemDecoration(30)
        binding.rv.addItemDecoration(topSpace)



    }
}