package com.example.unit_5_codingsprint1.ui.pagination

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.unit_5_codingsprint1.datamodel.remote.responsedto.ResponseDTOItem
import kotlinx.android.synthetic.main.item_layout.view.*

class ActorViewHolder(private val view: View):RecyclerView.ViewHolder(view) {


    fun setData(responseDTOItem:ResponseDTOItem){
        //if (responseDTOItem.birthday!=null && responseDTOItem.country!=null && responseDTOItem.deathday!=null){
            view.apply {
                tvActorName.text= responseDTOItem.name
                tvBirthDate.text = responseDTOItem.birthday
                tvCountryName.text = responseDTOItem.country?.name
                tvDeathDate.text = responseDTOItem.deathday
                Glide.with(ivActorImage).load(responseDTOItem.image?.original).into(ivActorImage)
            }

        //}

    }
}