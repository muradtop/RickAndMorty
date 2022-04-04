package com.example.kotlin1hm2ram.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<B : ViewBinding, V : BaseViewModel>(
    @LayoutRes layoutId: Int,
) : Fragment(layoutId) {

    protected abstract val binding: B
    protected abstract val viewModel: V

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupViews()
        setupListeners()
        setupRequests()
        setupObserves()
    }


    open fun initialize() {
    }

    open fun setupViews() {
    }

    open fun setupListeners() {
    }

    open suspend fun setupRequests() {
    }

    open fun setupObserves() {
    }
}