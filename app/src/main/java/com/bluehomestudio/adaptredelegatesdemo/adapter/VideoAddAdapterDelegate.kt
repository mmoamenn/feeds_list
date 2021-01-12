package com.bluehomestudio.adaptredelegatesdemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bluehomestudio.adaptredelegatesdemo.databinding.ViewItemVideoAddBinding
import com.bluehomestudio.adaptredelegatesdemo.models.Ad
import com.bluehomestudio.adaptredelegatesdemo.models.AdTypes
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun videoAddAdapterDelegate(listener: FeedsAdapter.OnItemClicked) =
    adapterDelegateViewBinding<Ad, Any, ViewItemVideoAddBinding>(
        on = { item: Any, _: List<Any>, _: Int -> item is Ad && item.type == AdTypes.VIDEO },
        viewBinding = { layoutInflater: LayoutInflater, root: ViewGroup ->
            ViewItemVideoAddBinding.inflate(layoutInflater, root, false)
        }
    ) {
        bind {
            binding.root.setOnClickListener { listener.onAdClicked(id = item.id) }
        }
    }