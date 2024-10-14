package com.dipumba.movies.data.remote

import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

/*
MovieService 클래스: 영화 관련 데이터를 제공하는 서비스 클래스입니다.
KtorApi 상속: KtorApi를 상속받아 HTTP 클라이언트를 재사용하고, API 호출을 편리하게 처리합니다.
internal 접근 제한자: 이 클래스는 같은 모듈 내에서만 접근이 가능합니다.
*/
internal class MovieService : KtorApi() {
    /*
    getMovies 함수: 인기 영화 목록을 가져오는 함수입니다.
    suspend: 이 함수는 비동기 함수로, 코루틴(coroutine) 내에서 호출되어 비동기 작업을 처리합니다. 즉, 함수가 중단될 수 있으며, 다른 비동기 작업을 기다릴 수 있습니다.
    page 매개변수: 기본값이 1인 정수형 매개변수로, 영화 목록의 특정 페이지를 요청할 때 사용됩니다.
    MoviesResponse: TMDb API에서 영화 목록을 받아오는 응답 데이터 타입입니다.
    client.get: Ktor의 HTTP GET 요청을 수행하는 메서드입니다.
    pathUrl("movie/popular"): 영화 목록 경로(movie/popular)를 설정합니다.
    parameter("page", page): 페이지 번호를 쿼리 매개변수로 추가합니다.
    .body(): API로부터 받은 HTTP 응답을 MoviesResponse 타입으로 변환해 반환합니다.
     */
    suspend fun getMovies(page: Int = 1): MoviesResponse = client.get {
        pathUrl("movie/popular")
        parameter("page", page)
    }.body()

    /*
    getMovie 함수: 특정 영화의 상세 정보를 가져오는 함수입니다.
    movieId 매개변수: 가져올 영화의 ID를 나타내는 정수형 매개변수입니다.
    MovieRemote: TMDb API에서 단일 영화에 대한 정보를 받아오는 응답 데이터 타입입니다.
    client.get: Ktor의 HTTP GET 요청을 수행하는 메서드입니다.
    pathUrl("movie/${movieId}"): 영화 상세 정보 경로(movie/{movieId})를 설정합니다. 여기서 movieId는 실제 영화 ID 값으로 치환됩니다.
    .body(): API로부터 받은 HTTP 응답을 MovieRemote 타입으로 변환해 반환합니다.
    */

    suspend fun getMovie(movieId:Int): MovieRemote = client.get {
        pathUrl("movie/${movieId}")
    }.body()
}

/*
전체 요약
MovieService 클래스는 TMDb API와 통신하는 역할을 합니다.
getMovies: 인기 영화 목록을 요청하고, 그 결과를 MoviesResponse로 반환합니다.
getMovie: 특정 영화 ID를 사용해 영화 상세 정보를 요청하고, 그 결과를 MovieRemote로 반환합니다.
두 함수 모두 Ktor의 비동기 HTTP 요청과 응답을 사용하며, JSON 데이터를 객체로 변환합니다.
*/

