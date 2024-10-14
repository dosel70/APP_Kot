//package com.example.movies.data.remote
//
//
//import kotlinx.serialization.Serializable
//
//@kotlinx.serialization.Serializable
//internal data class MoviesResponse(
//    val results: List<MovieRemote>
//)

package com.dipumba.movies.data.remote

@kotlinx.serialization.Serializable
internal data class MoviesResponse(
    val results: List<MovieRemote>
)
