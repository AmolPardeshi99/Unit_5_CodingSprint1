package com.example.unit_5_codingsprint1.ui.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.unit_5_codingsprint1.datamodel.remote.responsedto.ResponseDTO
import com.example.unit_5_codingsprint1.datamodel.remote.responsedto.ResponseDTOItem
import com.example.unit_5_codingsprint1.datamodel.remote.RetrofitHelper
import com.example.unit_5_codingsprint1.repository.ActorRepo
import java.lang.Exception
import javax.inject.Inject

class ActorPagingSource :PagingSource<Int,ResponseDTOItem>() {

    private val apiService = RetrofitHelper.getApiService()
    override fun getRefreshKey(state: PagingState<Int, ResponseDTOItem>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResponseDTOItem> {
        val pageNumber:Int = params.key?:1

        return try {
            val responseDTO:ResponseDTO = apiService.getAllActorsInfo(pageNumber)
            val responseDTOItemList:List<ResponseDTOItem> = responseDTO
//            actorRepo.addDataListToRoom()
            LoadResult.Page(
                data = responseDTOItemList,
                prevKey = null,
                nextKey = if (responseDTOItemList.isEmpty()) null else pageNumber+1
            )
        }catch (e:Exception){
            LoadResult.Error(e)
        }
    }
}