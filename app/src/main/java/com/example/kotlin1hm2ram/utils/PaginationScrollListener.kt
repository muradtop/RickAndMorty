package com.example.kotlin1hm2ram.utils

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class PaginationScrollListener(
    var layoutManager: LinearLayoutManager,
    private val doRequest: () -> Unit
) : RecyclerView.OnScrollListener() {
    abstract fun isLoading(): Boolean

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        val visibleItemCount = layoutManager.childCount
        val totalItemCount = layoutManager.itemCount
        val firstVisibleItemItemPosition = layoutManager.findFirstCompletelyVisibleItemPosition()

        if (!isLoading()) {
            if ((visibleItemCount + firstVisibleItemItemPosition) >= totalItemCount && firstVisibleItemItemPosition >= 0) {
                doRequest()
            }
        }
    }
}