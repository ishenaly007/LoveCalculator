package com.abit8.lovecalculator.Board


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.abit8.lovecalculator.R
import com.abit8.lovecalculator.databinding.BoardItemBinding

class OnBoardAdapter (private val onClick:() -> Unit): RecyclerView.Adapter<OnBoardAdapter.OnBoardingViewHolder>() {
    private val data = arrayListOf(
          Model("HAVE A GOOD TIME","you should take the time to help those who need you", R.raw.animation1),
          Model("CHERISHING LOVE","It is now no longer possible for ypu tp cherish love ", R.raw.animation2),
          Model("HAVE A BREAK UP?","We have made to correction for you dont worry, Maybe someone is waiting for you!", R.raw.animation3),
          Model("","Its Funs And Many More", R.raw.animation4),


    )
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(BoardItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }


    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class OnBoardingViewHolder(private val binding:BoardItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(model: Model) {
            model.image.let { it?.let { it1 -> binding.imageBoard.setAnimation(it1) } }
            binding.titleBoard.text = model.title
            binding.descBoard.text = model.decs
            binding.btnStart.isVisible = adapterPosition == data.lastIndex
            binding.btnStart.setOnClickListener{
                onClick()
            }
        }

    }


}