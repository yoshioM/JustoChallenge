package com.yoshio.challenge.ui.view.adapters

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.yoshio.challenge.databinding.ItemUserBinding
import com.yoshio.challenge.domain.model.UserItem
import java.util.*

class UserViewHolder (view: View): RecyclerView.ViewHolder(view) {
    val binding =  ItemUserBinding.bind(view)

    fun render(item: UserItem){
        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(16))

        Glide.with(binding.ivUser.context)
            .load(item.picture.large)
            .apply(requestOptions)
            .into(binding.ivUser)

        binding.tvName.text = "${item.name.title} ${item.name.first} ${item.name.last} "
        binding.tvEmail.text = item.email
        binding.tvLocation.text = "${item.location.city}, ${item.location.country} "
    }
}