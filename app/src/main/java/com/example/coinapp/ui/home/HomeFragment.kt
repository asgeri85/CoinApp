package com.example.coinapp.ui.home

import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coinapp.adapters.CoinCardAdapter
import com.example.coinapp.base.BaseFragment
import com.example.coinapp.databinding.FragmentHomeBinding
import com.example.coinapp.model.Data
import com.example.coinapp.utils.Constants.API_KEY
import com.example.coinapp.utils.Constants.LIMIT
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    FragmentHomeBinding::inflate
) {

    private val  coinCardAdapter:CoinCardAdapter=CoinCardAdapter()

    override val viewModel: HomeViewModel by viewModels<HomeViewModel>()

    override fun createFinished() {
        viewModel.getCoinData(API_KEY, LIMIT)
    }

    override fun observeEvents() {
        with(viewModel){
            coinData.observe(viewLifecycleOwner) {
                it?.let {
                    it.data?.let { dataList -> setRecycler(dataList) }
                }
            }

            loading.observe(viewLifecycleOwner){
                with(binding){
                    if (it){
                        progressBarHome.visibility=View.VISIBLE
                        rvHOme.visibility=View.GONE
                    }else{
                        progressBarHome.visibility=View.GONE
                        rvHOme.visibility=View.VISIBLE
                    }
                }
            }

            onError.observe(viewLifecycleOwner){
                it?.let {
                    Toast.makeText(context,it,Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun setRecycler(list:List<Data>){
        coinCardAdapter.setDataList(list)
        binding.rvHOme.apply {
            layoutManager=LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter=coinCardAdapter
        }
        coinCardAdapter.onClick={
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(it))
        }
    }
}