package com.abit8.lovecalculator.History

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.abit8.lovecalculator.databinding.HistoryItemBinding
import com.abit8.lovecalculator.remote.LoveModel

class HistoryAdapter() : Adapter<HistoryAdapter.HistoryViewHolder>() {
    var models = arrayListOf<LoveModel>()
    fun loveAdd(list: List<LoveModel>) {
        models.clear()
        models.addAll(list)
        notifyDataSetChanged()

    }

    inner class HistoryViewHolder(private val binding: HistoryItemBinding) :
        ViewHolder(binding.root) {
        fun bind(loveModel: LoveModel) {
            with(binding) {
                meText.text = loveModel.firstName
                youText.text = loveModel.secondName
                precentage.text = loveModel.percentage
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            HistoryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(models[position])
    }
}