package com.jccsisc.mylist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.jccsisc.mylist.databinding.ActivityMainBinding
import com.jccsisc.mylist.utils.LambdasObjet.changeTitle
import com.jccsisc.mylist.utils.showView

class MainActivity : AppCompatActivity() {

    lateinit var mBinding: ActivityMainBinding
    private var isHomeView = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.apply {

            changeTitle = { title, back ->

                tvTitle.text = title

                if (back) {
                    isHomeView = false
                    imgGraficas.setImageResource(R.drawable.ic_back)
                    imgAgregar.showView(false)
                } else {
                    isHomeView = true
                    imgAgregar.showView()
                    imgGraficas.setImageResource(R.drawable.ic_graficas)
                }
            }

            imgGraficas.setOnClickListener {
                if (isHomeView) {
                    findNavController(R.id.fragmentContainerView).navigate(R.id.action_homeFragment_to_graphicsFragment)
                } else {
                    findNavController(R.id.fragmentContainerView).popBackStack()
                }
            }

            imgAgregar.setOnClickListener {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_homeFragment_to_addFragment)
            }

        }

    }
}