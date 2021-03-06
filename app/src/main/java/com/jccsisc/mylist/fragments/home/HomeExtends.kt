package com.jccsisc.mylist.fragments.home

import androidx.navigation.fragment.findNavController
import com.jccsisc.mylist.R
import com.jccsisc.mylist.fragments.home.adapter.HomeAdapter
import com.jccsisc.mylist.fragments.home.model.InvitadoModel
import com.jccsisc.mylist.utils.LambdasObjet.changeTitle

fun HomeFragment.initElements() {
    mBinding.apply {

        changeTitle(getString(R.string.lista_de_invitados), false)




        val list = arrayListOf(
            InvitadoModel(1, "Juan Francisco Rodriguez", "4531260729", "Apatzingán", "jf@hotmail.com", 1, 0, 1,"Alcohol", false, 0),
            InvitadoModel(2, "Juan Francisco Rodriguez", "4531260729", "Apatzingán", "jf@hotmail.com", 0, 0, 0,"Alcohol", false, 0),
            InvitadoModel(3, "Juan Francisco Rodriguez", "4531260729", "Apatzingán", "jf@hotmail.com", 1, 1, 0,"Alcohol", false, 0),
            InvitadoModel(4, "Juan Francisco Rodriguez", "4531260729", "Apatzingán", "jf@hotmail.com", 0, 1, 0,"Alcohol", false, 0),
            InvitadoModel(5, "Juan Francisco Rodriguez", "4531260729", "Apatzingán", "jf@hotmail.com", 1, 1, 1,"Alcohol", false, 0),
            InvitadoModel(6, "Juan Francisco Rodriguez", "4531260729", "Apatzingán", "jf@hotmail.com", 0, 0, 0,"Alcohol", false, 0),
            InvitadoModel(7, "Juan Francisco Rodriguez", "4531260729", "Apatzingán", "jf@hotmail.com", 0, 1, 0,"Alcohol", false, 0),
            InvitadoModel(8, "Juan Francisco Rodriguez", "4531260729", "Apatzingán", "jf@hotmail.com", 0, 0, 0,"Alcohol", false, 0),
            InvitadoModel(9, "Juan Francisco Rodriguez", "4531260729", "Apatzingán", "jf@hotmail.com", 1, 0, 1,"Alcohol", false, 0),
            InvitadoModel(10, "Juan Francisco Rodriguez", "4531260729", "Apatzingán", "jf@hotmail.com", 1, 0, 1,"Alcohol", false, 0),
            InvitadoModel(11, "Juan Francisco Rodriguez", "4531260729", "Apatzingán", "jf@hotmail.com", 1, 0, 1,"Alcohol", false, 0),
            InvitadoModel(12, "Juan Francisco Rodriguez", "4531260729", "Apatzingán", "jf@hotmail.com", 1, 0, 1,"Alcohol", false, 0),
            InvitadoModel(13, "Juan Francisco Rodriguez", "4531260729", "Apatzingán", "jf@hotmail.com", 1, 0, 1,"Alcohol", false, 0),
            InvitadoModel(14, "Juan Francisco Rodriguez", "4531260729", "Apatzingán", "jf@hotmail.com", 1, 0, 1,"Alcohol", false, 0),
            InvitadoModel(15, "Juan Francisco Rodriguez", "4531260729", "Apatzingán", "jf@hotmail.com", 1, 0, 1,"Alcohol", false, 0),
            InvitadoModel(16, "Juan Francisco Rodriguez", "4531260729", "Apatzingán", "jf@hotmail.com", 1, 0, 1,"Alcohol", false, 0),
            InvitadoModel(17, "Juan Francisco Rodriguez", "4531260729", "Apatzingán", "jf@hotmail.com", 1, 0, 1,"Alcohol", false, 0)
        )

        val adapter = HomeAdapter()
        rvTotalInvitados.adapter = adapter
        adapter.submitList(list)


        adapter.onClickItem = {

            findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
        }
    }
}