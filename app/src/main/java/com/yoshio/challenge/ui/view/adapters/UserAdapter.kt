package com.yoshio.challenge.ui.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yoshio.challenge.R
import com.yoshio.challenge.domain.model.UserItem

class UserAdapter (private val datList:List<UserItem>): RecyclerView.Adapter<UserViewHolder>(){
    private lateinit var mListener: onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position: String)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return UserViewHolder(layoutInflater.inflate(R.layout.item_user,parent,false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = datList[position]
        holder.render(item,mListener)
    }

    override fun getItemCount(): Int {
        return datList.size
    }

}