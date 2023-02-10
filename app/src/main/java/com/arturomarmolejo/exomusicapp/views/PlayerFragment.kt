package com.arturomarmolejo.exomusicapp.views

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.arturomarmolejo.exomusicapp.databinding.FragmentExoplayerBinding
import com.arturomarmolejo.exomusicapp.utils.BaseFragment

class PlayerFragment(): BaseFragment() {

    private val binding by lazy {
        FragmentExoplayerBinding.inflate(layoutInflater)
    }

    private var trackUri = ""
    private var player : ExoPlayer? = null
    private var playWhenReady = true
    private var currentItem = 0
    private var playBackPosition = 0L

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return binding.root

    }

    override fun onStart() {
        super.onStart()
        getTrackUri()
        initializePlayer()
    }

    private fun getTrackUri() {
        trackUri = exoMusicViewModel.trackUri
    }

    override fun onStop() {
        super.onStop()
        releasePlayer()
    }

    private fun initializePlayer() {
        player = ExoPlayer.Builder(this.requireContext())
            .build()
            .also {
                binding.videoView.player = it
                if (trackUri.isNotEmpty()) {
                    val mediaItem = MediaItem.fromUri(trackUri.toUri())
                    it.setMediaItem(mediaItem)

                    it.playWhenReady = playWhenReady
                    it.seekTo(currentItem, playBackPosition)
                    it.prepare()
                } else {
                    Log.d(TAG, "initializePlayer: songUri value is an empty String")
                }
            }
    }

    private fun releasePlayer() {
        player?.let {
            playWhenReady = it.playWhenReady
            currentItem = it.currentMediaItemIndex
            playBackPosition = it.currentPosition
            it.release()
        }
        player = null
    }

}