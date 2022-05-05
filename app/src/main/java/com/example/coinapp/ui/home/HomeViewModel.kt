package com.example.coinapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinapp.model.DataResponse
import com.example.coinapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeRepository: HomRepository):ViewModel() {

    private val _coinData=MutableLiveData<DataResponse?>()
    val coinData:LiveData<DataResponse?>
        get() = _coinData

    private val _loading=MutableLiveData<Boolean>()
    val loading:LiveData<Boolean>
        get() = _loading

    private val _onError=MutableLiveData<String?>()
    val onError:LiveData<String?>
        get() = _onError


    fun getCoinData(apiKey:String,limit:String){
        viewModelScope.launch {
            _loading.value=true
            val request=homeRepository.getData(apiKey, limit)
            when(request){
                is NetworkResult.Success->{
                    _coinData.value=request.data
                    _loading.value=false
                }

                is NetworkResult.Error->{
                    _onError.value=request.message
                    _loading.value=false
                }
            }
        }
    }
}

