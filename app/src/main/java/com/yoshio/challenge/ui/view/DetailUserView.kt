package com.yoshio.challenge.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.yoshio.challenge.R
import com.yoshio.challenge.databinding.ActivityDetailUserViewBinding
import com.yoshio.challenge.domain.model.UserItem
import com.yoshio.challenge.ui.viewmodel.RandomUserViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class DetailUserView : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var binding: ActivityDetailUserViewBinding
    private lateinit var map: GoogleMap

    private val randomUserViewModel: RandomUserViewModel by viewModels()
    var coordinates = LatLng(0.0,0.0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val idDB:String = intent.getStringExtra("idDB").toString()

        randomUserViewModel.userDetailModel.observe(this, Observer { userDetail->
            render(userDetail)
        })
        randomUserViewModel.getDataFromIdDatabse(idDB)

        binding.btnReturn.setOnClickListener {
            finish()
        }
    }

    private fun render(item: UserItem) {
        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(16))

        Glide.with(binding.ivUser.context)
            .load(item.picture.large)
            .apply(requestOptions)
            .into(binding.ivUser)

        binding.tvTitle.text = "${item.name.title} ${item.name.first} ${item.name.last}"
        binding.tvBirthday.text = "Birthday ${getFormatedDateAny(item.dob.date,"yyyy-MM-dd HH:mm:ss","yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")}\nAge: ${item.dob.age}"
        binding.tvContact.text = "Cell: ${item.cell}\nPhone: ${item.phone}\nEmail: ${item.email}"
        binding.tvLocation.text = "Street: ${item.location.street.name}\nCity: ${item.location.city}\nState: ${item.location.state}\nCountry: ${item.location.country}"

        coordinates = LatLng(item.location.coordinates.latitude.toDouble(),item.location.coordinates.longitude.toDouble())
        createGoogleMap()
    }

    private fun createGoogleMap() {
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    fun getFormatedDateAny(dateString: String?, format: String?, currentFormat: String?): String {
        val sdf = SimpleDateFormat(currentFormat, Locale.US)
        return try {
            val date = sdf.parse(dateString)
            SimpleDateFormat(format).format(date)
        } catch (e: Exception) {
            e.printStackTrace()
            ""
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        createMarker()
    }

    private fun createMarker() {
        val marker = MarkerOptions().position(coordinates).title("lat: ${coordinates.latitude}, long: ${coordinates.longitude}")
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,5f),
            4000,
            null
        )
    }
}