package com.exoplayercompose

import android.content.Context
import com.google.android.exoplayer2.DefaultLoadControl
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer

object SimpleExoPlayerHolder {
    private var exoplayer: SimpleExoPlayer? = null

    fun get(context: Context): SimpleExoPlayer {
        if (exoplayer == null) {
            exoplayer = createExoPlayer(context)
        }
        return exoplayer!!
    }

    private fun createExoPlayer(context: Context): SimpleExoPlayer {
        return SimpleExoPlayer.Builder(context)
            .setLoadControl(
                DefaultLoadControl.Builder().setBufferDurationsMs(
                    DefaultLoadControl.DEFAULT_MIN_BUFFER_MS,
                    DefaultLoadControl.DEFAULT_MAX_BUFFER_MS,
                    DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS / 10,
                    DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS / 10
                ).build()
            )
            .build()
            .apply {
                repeatMode = Player.REPEAT_MODE_ONE
            }
    }
}