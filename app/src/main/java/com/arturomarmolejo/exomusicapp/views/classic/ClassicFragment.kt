package com.arturomarmolejo.exomusicapp.views.classic

import ExoMusicAdapter
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.arturomarmolejo.exomusicapp.databinding.FragmentTrackListBinding
import com.arturomarmolejo.exomusicapp.model.items.TrackListResponse
import com.arturomarmolejo.exomusicapp.utils.BaseFragment
import com.arturomarmolejo.exomusicapp.utils.UIState

class ClassicFragment: BaseFragment() {
    private val binding by lazy {
        FragmentTrackListBinding.inflate(layoutInflater)
    }

    private val genresAdapter by lazy {
        ExoMusicAdapter {
            exoMusicViewModel.trackUri = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.trackListRv.apply {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
            setHasFixedSize(true)
            adapter = genresAdapter
        }
        exoMusicViewModel.classicTrackList.observe(viewLifecycleOwner) { state ->
            when (state) {
                is UIState.LOADING -> {}
                is UIState.SUCCESS<TrackListResponse> -> {
                    genresAdapter.updateItems(state.response.results ?: emptyList())
                }
                is UIState.ERROR -> {
                    showError(state.error.localizedMessage) {
                        Log.d(TAG, "onCreateView:  UIState Error")
                    }
                }
            }

        }
        return binding.root
    }
}