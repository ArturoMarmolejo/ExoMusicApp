package com.arturomarmolejo.exomusicapp.views

import ExoMusicAdapter
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.arturomarmolejo.exomusicapp.databinding.FragmentTrackListBinding
import com.arturomarmolejo.exomusicapp.model.items.TrackResponse
import com.arturomarmolejo.exomusicapp.utils.BaseFragment
import com.arturomarmolejo.exomusicapp.utils.UIState

//@Suppress("UNCHECKED_CAST")
//open class TrackListFragment : BaseFragment() {
//
//    private val binding by lazy {
//        FragmentTrackListBinding.inflate(layoutInflater)
//    }
//
//
//    private val exoMusicAdapter by lazy {
//        ExoMusicAdapter {
//
//        }
//    }
//
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        exoMusicViewModel..observe(viewLifecycleOwner) { state ->
//            when(state) {
//                is UIState.LOADING -> {}
//                is UIState.SUCCESS<*> -> {
//                    Log.d(TAG, "onCreateView: ${state.response}")
//                    exoMusicAdapter.updateItems(state.response as List<TrackResponse>)
//                }
//                is UIState.ERROR -> {
//                    showError(state.error.localizedMessage) {
//
//                    }
//                }
//            }
//        }
//
//        binding.trackListRv.apply {
//            layoutManager =
//                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
//            setHasFixedSize(true)
//            adapter = exoMusicAdapter
//        }
//
//        return binding.root
//    }
//
//}