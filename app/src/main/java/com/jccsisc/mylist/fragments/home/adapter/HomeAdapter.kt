package com.jccsisc.mylist.fragments.home.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jccsisc.mylist.R
import com.jccsisc.mylist.databinding.ItemInvitadosBinding
import com.jccsisc.mylist.fragments.home.model.InvitadoModel

class HomeAdapter : ListAdapter<InvitadoModel, HomeAdapter.HomeViewHolder>(DiffCallbackHome) {

    lateinit var onClickItem: (invitadoModel: InvitadoModel) -> Unit

    companion object DiffCallbackHome: DiffUtil.ItemCallback<InvitadoModel>() {

        override fun areItemsTheSame(oldItem: InvitadoModel, newItem: InvitadoModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: InvitadoModel, newItem: InvitadoModel): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val mBinding = ItemInvitadosBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val invitadoModel = getItem(position)
        holder.bind(invitadoModel)
    }


    inner class  HomeViewHolder(private val mBinding: ItemInvitadosBinding): RecyclerView.ViewHolder(mBinding.root) {
        fun bind(invitadoModel: InvitadoModel) = with(mBinding) {

            invitadoModel.apply {
                tvParentezco.text = if (parentezcp == 0) "Familiar" else "Amigo"
                tvParentezco.setBackgroundResource(if (parentezcp == 0) R.drawable.shape_familiar else R.drawable.shape_amigo)
                imgRole.setImageResource(if (role == 0) R.drawable.ic_p else R.drawable.ic_i)
                cbAsistencia.isChecked = asistencia == 1
                tvNombre.text = nombre
                tvLocalidad.text = localidad
                tvTelefono.text = telefono
            }

            cardInvitados.animation = AnimationUtils.loadAnimation(root.context, R.anim.slide_in_left)

            cardInvitados.setOnClickListener {
                if (::onClickItem.isInitialized) {
                    onClickItem(invitadoModel)
                } else {
                    Log.e("error", "onClickItem no est?? inicializado")
                }
            }

        }
    }
}