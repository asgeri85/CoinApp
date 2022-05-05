package com.example.coinapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coinapp.databinding.CardCoinBinding
import com.example.coinapp.model.Data

class CoinCardAdapter:RecyclerView.Adapter<CoinCardAdapter.CoinCardViewHolder>() {

    private val coinList= arrayListOf<Data>()
    var onClick:(Data)->Unit={}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinCardViewHolder {
        val cardLayout=CardCoinBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CoinCardViewHolder(cardLayout)
    }

    override fun onBindViewHolder(holder: CoinCardViewHolder, position: Int) {
        val coinItem=coinList[position]
        holder.findItem(coinItem,onClick)
    }

    override fun getItemCount(): Int = coinList.size

    class CoinCardViewHolder(private val cardCoinBinding: CardCoinBinding):RecyclerView.ViewHolder(cardCoinBinding.root){

        fun findItem(data:Data,onClick:(Data)->Unit={} ){
            cardCoinBinding.coin=data
            cardCoinBinding.executePendingBindings()

            cardCoinBinding.card.setOnClickListener {
                onClick(data)
            }
        }

    }

    fun setDataList(list:List<Data>){
        coinList.clear()
        coinList.addAll(list)
        notifyDataSetChanged()
    }


}