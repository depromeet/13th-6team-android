package com.depromeet.whatnow.data.source


import com.depromeet.whatnow.data.model.request.PromiseRequest
import com.depromeet.whatnow.data.model.response.*

interface PromisesRemoteDataSource {
    suspend fun getPromisesActive(promise_id: Int): Result<Boolean>
    suspend fun getLocation(location: String): Result<LocationResponse>

    suspend fun putPromisesUsersLocation(
        promise_id: Int,
        userLocation: CoordinateVo
    ): Result<List<PromisesUsersLocationResponse>>


    suspend fun getPromisesMonthlyUsers(year_month: String): Result<PromisesMonthlyUsersListResponse>

    suspend fun getPromises(promise_id: Int): Result<GetPromisesResponse>
    suspend fun getPromisesUsersStatus(status: String): Result<List<GetPromisesUsersStatusResponse>>

    suspend fun getPromisesUsersSeparated(): Result<PromisesUsersSeparatedListResponse>

    suspend fun getPromisesUsers(promise_id: String): Result<PromisesUsersStatusListResponse>

    suspend fun patchPromisesProgress(
        progressCode: String,
        promiseId: Int
    ): Result<PromisesProgressResponse>

    suspend fun getPromisesUsersProgress(
        promiseId: Int,
        userId: Int
    ): Result<PromisesProgressResponse>

    suspend fun getPromisesProgress(): Result<GetPromisesProgressListResponse>

    suspend fun postPromisesImagesSuccess(
        promiseId: Int,
        imageKey: String,
        imageCommentType: String
    ): Unit

    suspend fun getPromisesImages(
        promiseId: Int,
        fileExtension: String,
    ): Result<PromisesImagesResponse>

    suspend fun postPromisesInteractionsTarget(
        promiseId: Int,
        interactionType: String,
        targetUserId: Int,
    ): Unit

    suspend fun getPromisesInteractions(promiseId: Int): Result<GetPromisesInteractionsResponse>

    suspend fun getPromisesInteractionsDetail(
        promiseId: Int,
        interactionType: String
    ): Result<PromisesInteractionsDetailResponse>

    suspend fun postPromises(request : PromiseRequest): Result<PromisesResponse>
}