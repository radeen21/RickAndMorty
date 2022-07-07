package com.example.feature_home.presentation

import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.base.presentation.BaseActivity
import com.example.base.viewmodel.BaseViewModel
import com.example.feature_home.databinding.ActivityDetailBinding

class ProfileDetailActivity :
    BaseActivity<ActivityDetailBinding, BaseViewModel>() {

    override val binding: ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(
            layoutInflater
        )
    }

    override val viewModel: BaseViewModel by viewModels()

    override fun onInitViews() {
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setHomeButtonEnabled(true)
        supportActionBar?.hide()
        val bundle : Bundle?=intent.extras
        var message = bundle!!.getString("id")
        val image = bundle!!.getString("imageDetail")
        val characterName = bundle!!.getString("characterNameDetail")
        val status = bundle!!.getString("statusDetail")
        val species = bundle!!.getString("speciesDetail")
        val gender = bundle!!.getString("genderDetail")
        val location = bundle!!.getString("locationDetail")
        val origin = bundle!!.getString("originDetail")
        val episode = bundle!!.getString("episodeDetail")

        Glide.with(this)
            .load(image)
            .into(binding.ivCharacterDetail)

        binding.tvDetailCharacter.text = characterName
        binding.tvDetailStatus.text = status
        binding.tvDetailSpecies.text = species
        binding.tvDetailGender.text = gender
        binding.tvLocation.text = location
        binding.tvOrigin.text = origin
        binding.tvAccountEpisode.text = episode
    }

    override fun onInitObservers() = Unit
}