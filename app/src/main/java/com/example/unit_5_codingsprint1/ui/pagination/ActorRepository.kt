package com.example.unit_5_codingsprint1.ui.pagination

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingConfig.Companion.MAX_SIZE_UNBOUNDED
import androidx.paging.liveData

class ActorRepository {

    fun getPagerList()=
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = PagingConfig.MAX_SIZE_UNBOUNDED
            ),
            pagingSourceFactory = { ActorPagingSource() }
        ).liveData
}