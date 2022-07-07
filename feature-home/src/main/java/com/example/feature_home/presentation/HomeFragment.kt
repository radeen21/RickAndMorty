package com.example.feature_home.presentation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.base.presentation.BaseFragment
import com.example.base.viewmodel.BaseViewModel
import com.example.domain.entites.ResultEntities
import com.example.domain.entites.RickyAndMortyEntities
import com.example.domain.subcriber.ResultState
import com.example.feature_home.databinding.FragmentHomeBinding
import com.example.feature_home.presentation.adapter.HomeAdapter
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.FragmentScoped

@FragmentScoped
@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, BaseViewModel>(),
    HomeAdapter.OnClickedListener{

    private lateinit var scrollListener: RecyclerView.OnScrollListener
    private var lastVisibleItemPosition: Int = 0
    private var page: Int = 1

    private var loading = true
    var pastVisiblesItems = 0
    var visibleItemCount:kotlin.Int = 0
    var totalItemCount:kotlin.Int = 0

    private lateinit var homeAdapter: HomeAdapter
    private var layoutManager: RecyclerView.LayoutManager? = null

    @FragmentScoped
    override val viewModel: RickyAndMortyViewModel by viewModels()
    override val binding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
    }

    override fun onInitObservers() {
        super.onInitObservers()
        viewModel.getDataLiveData.observe(viewLifecycleOwner, Observer {
            onResultWeatherLoaded(it)
        })
    }

    private fun onResultWeatherLoaded(resultState: ResultState<RickyAndMortyEntities>) {
        when (resultState) {
            is ResultState.Success -> {
//                setRecyclerViewScrollListener()
                initAdapter(resultState.data.results)
                Toast.makeText(requireContext(), "Masuk Sukses", Toast.LENGTH_SHORT)
                    .show()
            }
            is ResultState.Error -> {
                Toast.makeText(
                    requireContext(),
                    resultState.throwable.localizedMessage,
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }
    }

    fun getData() {
        viewModel.fetchWeather(page)
//        setRecyclerViewScrollListener()

    }

    private fun initAdapter(resultState: List<ResultEntities>?) {
        homeAdapter = HomeAdapter(resultState)
        homeAdapter.onClickedLister = this
        val linearLayoutManager = LinearLayoutManager(requireContext())
        layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recHome.layoutManager = layoutManager
        binding.recHome.adapter = homeAdapter
    }

    override fun onItemClicked(data: ResultEntities) {
        val intent = Intent(requireContext(), ProfileDetailActivity::class.java)
        intent.putExtra("id", id)
        intent.putExtra("imageDetail", data.image)
        intent.putExtra("characterNameDetail", data.name)
        intent.putExtra("statusDetail", data.status)
        intent.putExtra("speciesDetail", data.species)
        intent.putExtra("genderDetail", data.gender)
        intent.putExtra("locationDetail", data.location.name)
        intent.putExtra("originDetail", data.origin.name)
        intent.putExtra("episodeDetail", data.episode)
        startActivity(intent)
        Toast.makeText(requireContext(), data.name, Toast.LENGTH_SHORT)
            .show()
    }
}