package com.app.machinetest.ui.map

import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.app.machinetest.R
import com.app.machinetest.baseresult.BaseResult
import com.app.machinetest.databinding.FragmentMapsBinding
import com.app.machinetest.utils.showToast
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MapsFragment : Fragment(R.layout.fragment_maps), View.OnClickListener {

    private val binding: FragmentMapsBinding by viewBinding()
    private val viewModel: MapsViewModel by viewModels()

    private lateinit var map: GoogleMap

    private val callback = OnMapReadyCallback { googleMap ->
        map = googleMap
        /*  val sydney = LatLng(-34.0, 151.0)
          map.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
          map.moveCamera(CameraUpdateFactory.newLatLng(sydney))*/

        viewModel.fetchUserResponse()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.listener = this
        observeUserResponse()
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    private fun observeUserResponse() {
        viewModel.userResponseLiveData.observe(viewLifecycleOwner, {

            when (it.status) {
                BaseResult.Status.SUCCESS -> {
                    if (it.data?.location?.size != 0) {
                        it.data?.location?.forEach { mapItem ->
                            Timber.e("${mapItem.lat?.toDouble()}")
                            if ((mapItem.lat?.isNotEmpty() == true) && (mapItem.long?.isNotEmpty() == true)) {
                                map.addMarker(
                                    MarkerOptions().position(
                                        LatLng(mapItem.lat.toDouble(), mapItem.long.toDouble())
                                    ).title("Marker")
                                )
                            }
                        }


                        map.animateCamera(
                            CameraUpdateFactory.newLatLngZoom(
                                LatLng(
                                    it.data?.location?.first()?.lat?.toDouble()!!,
                                    it.data.location.first().long?.toDouble()!!
                                ), 6f
                            ), 2000, null
                        )


                    }
                }

                BaseResult.Status.ERROR -> {
                    Timber.e("error ${it.message}")
                    showToast(it.message ?: "")
                }

                BaseResult.Status.LOADING -> {

                }
            }
        })
    }

    override fun onClick(view: View?) {
        when (view) {
            binding.imageBack -> {
                findNavController().navigateUp()
            }
        }
    }
}