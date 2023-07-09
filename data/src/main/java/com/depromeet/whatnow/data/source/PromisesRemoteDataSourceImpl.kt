package com.depromeet.whatnow.data.source

import android.util.Log
import com.depromeet.whatnow.data.api.ApiService
import com.depromeet.whatnow.data.entity.LocationEntity
import com.depromeet.whatnow.data.entity.NcpMapInfoEntity
import com.depromeet.whatnow.data.model.request.LocationRequest
import com.depromeet.whatnow.data.model.request.PromiseRequest
import com.depromeet.whatnow.data.model.request.toData
import com.depromeet.whatnow.data.model.response.*
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

internal class PromisesRemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
) : PromisesRemoteDataSource {
    override suspend fun getLocation(location: String): Result<LocationResponse> =
        runCatching {
            apiService.getLocation(location).data
        }

    override suspend fun getPromisesActive(promise_id: Int): Result<Boolean> =
        runCatching {
            apiService.getPromisesActive(promise_id = promise_id).data
        }

    override suspend fun getPromisesMonthlyUsers(year_month: String): Result<PromisesMonthlyUsersListResponse> =
        runCatching {
            apiService.getPromisesMonthlyUsers(year_month = year_month).data
        }

    override suspend fun getPromisesUsersStatus(status: String): Result<GetPromisesUsersStatusListResponse> =
        runCatching {
            apiService.getPromisesUsersStatus(status = status).data
        }

    override suspend fun getPromisesUsersSeparated(): Result<PromisesUsersSeparatedListResponse> =
        runCatching {
            apiService.getPromisesUsersSeparated().data
        }

    override suspend fun getPromisesUsers(promise_id: String): Result<PromisesUsersStatusListResponse> =
        runCatching {
            apiService.getPromisesUsers(promise_id = promise_id).data
        }

    override suspend fun patchPromisesProgress(
        progressCode: String, promiseId: Int
    ): Result<PromisesProgressResponse> = runCatching {
        apiService.patchPromisesProgress(
            progressCode = progressCode, promiseId = promiseId
        ).data
    }

    override suspend fun getPromisesUsersProgress(
        promiseId: Int, userId: Int
    ): Result<PromisesProgressResponse> = runCatching {
        apiService.getPromisesUsersProgress(
            promiseId = promiseId, userId = userId
        ).data
    }

    override suspend fun getPromisesProgress(): Result<GetPromisesProgressListResponse> =
        runCatching {
            apiService.getPromisesProgress().data
        }


    override suspend fun postPromisesImagesSuccess(
        promiseId: Int, imageKey: String, imageCommentType: String
    ) {
        runCatching {
            apiService.postPromisesImagesSuccess(
                promiseId = promiseId, imageKey = imageKey, imageCommentType = imageCommentType
            )
        }
    }

    override suspend fun getPromisesImages(
        promiseId: Int, fileExtension: String
    ): Result<PromisesImagesResponse> = runCatching {
        apiService.getPromisesImages(
            promiseId = promiseId,
            fileExtension = fileExtension,
        ).data
    }

    override suspend fun postPromisesInteractionsTarget(
        promiseId: Int, interactionType: String, targetUserId: Int
    ) {
        runCatching {
            apiService.postPromisesInteractionsTarget(
                promiseId = promiseId,
                interactionType = interactionType,
                targetUserId = targetUserId
            )
        }
    }

    override suspend fun getPromisesInteractions(promiseId: Int): Result<GetPromisesInteractionsResponse> =
        runCatching {
            apiService.getPromisesInteractions(
                promiseId = promiseId,
            ).data
        }

    override suspend fun getPromisesInteractionsDetail(
        promiseId: Int, interactionType: String
    ): Result<PromisesInteractionsDetailResponse> = runCatching {
        apiService.getPromisesInteractionsDetail(
            promiseId = promiseId, interactionType = interactionType
        ).data
    }

    override suspend fun postPromises(request: PromiseRequest):Reulst<PromisesResponse> = runBlocking {
        apiService.postPromises(request).data
    }
}