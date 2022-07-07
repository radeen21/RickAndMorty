package com.example.feature_home.presentation

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.base.viewmodel.BaseViewModel
import com.example.domain.entites.RickyAndMortyEntities
import com.example.domain.interactor.RickyAndMortyUseCase
import com.example.domain.subcriber.DefaultSubscriber
import com.example.domain.subcriber.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RickyAndMortyViewModel @Inject constructor(
    private var rickyAndMortyUseCase: RickyAndMortyUseCase,
) : BaseViewModel() {

    private val _getData = MutableLiveData<ResultState<RickyAndMortyEntities>>()
    val getDataLiveData: LiveData<ResultState<RickyAndMortyEntities>> =
        _getData

    fun fetchWeather(pages: Int) {
        rickyAndMortyUseCase.execute(
            object : DefaultSubscriber<RickyAndMortyEntities>() {
                override fun onError(error: ResultState<RickyAndMortyEntities>) {
                    val message: String? = (error as ResultState.Error).throwable.message
                    Log.d(ContentValues.TAG, "Error : $message")
                    _getData.value = error
                }

                override fun onSuccess(data: ResultState<RickyAndMortyEntities>) {
                    val dataResultWeather = (data as ResultState.Success).data
                    Log.d(ContentValues.TAG, "Success Fetched : $dataResultWeather")
                    _getData.value = data
                }

            }, RickyAndMortyUseCase.Params(pages)
        )
    }

}