package com.bluehomestudio.adaptredelegatesdemo.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bluehomestudio.adaptredelegatesdemo.databinding.ViewItemVideoImagePostBinding
import com.bluehomestudio.adaptredelegatesdemo.models.Feed
import com.bluehomestudio.adaptredelegatesdemo.models.UserFeedTypes
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun videoFeedAdapterDelegate(listener: FeedsAdapter.OnItemClicked) =
    adapterDelegateViewBinding<Feed, Any, ViewItemVideoImagePostBinding>(
        on = { item: Any, _: List<Any>, _: Int -> item is Feed && item.type == UserFeedTypes.VIDEO },
        viewBinding = { layoutInflater: LayoutInflater, root: ViewGroup ->
            ViewItemVideoImagePostBinding.inflate(layoutInflater, root, false)
        }
    ) {
        bind {
            binding.root.setOnClickListener { listener.onFeedClicked(id = item.id) }
            binding.username.text = item.userName
            binding.feedVideoImage.setBackgroundColor(Color.MAGENTA)
        }
    }