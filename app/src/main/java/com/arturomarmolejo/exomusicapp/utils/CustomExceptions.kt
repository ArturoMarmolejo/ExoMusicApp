package com.arturomarmolejo.exomusicapp.utils


class NullTrackListResponse(message: String = "TrackList response is null") : Exception(message)
class FailureResponse(message: String?) : Exception(message)