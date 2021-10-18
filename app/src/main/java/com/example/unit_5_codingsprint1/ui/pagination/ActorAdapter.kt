package com.example.unit_5_codingsprint1.ui.pagination

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.unit_5_codingsprint1.R
import com.example.unit_5_codingsprint1.datamodel.remote.responsedto.ResponseDTOItem

class ActorAdapter:PagingDataAdapter<ResponseDTOItem,ActorViewHolder>(diffUtil) {
  companion object{
      val diffUtil = object : DiffUtil.ItemCallback<ResponseDTOItem>(){
          override fun areItemsTheSame(
              oldItem: ResponseDTOItem,
              newItem: ResponseDTOItem
          ): Boolean {
              return oldItem.id == newItem.id
          }

          override fun areContentsTheSame(
              oldItem: ResponseDTOItem,
              newItem: ResponseDTOItem
          ): Boolean {
              return oldItem.equals(newItem)
          }
      }
  }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        getItem(position)?.let {
            holder.setData(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        return ActorViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false))
    }
}