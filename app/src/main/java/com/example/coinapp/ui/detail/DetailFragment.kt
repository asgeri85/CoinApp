package com.example.coinapp.ui.detail

import androidx.navigation.fragment.navArgs
import com.example.coinapp.base.BaseFragment
import com.example.coinapp.databinding.FragmentDetailBinding

class DetailFragment : BaseFragment<FragmentDetailBinding,DetailViewModel>(
    FragmentDetailBinding::inflate
) {
    override val viewModel: DetailViewModel by lazy { DetailViewModel() }
    private val argument:DetailFragmentArgs by navArgs()

    override fun createFinished() {
        binding.textView.text=argument.coin.symbol
    }

    override fun observeEvents() {
    }

}