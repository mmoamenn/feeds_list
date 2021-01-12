package com.bluehomestudio.adaptredelegatesdemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bluehomestudio.adaptredelegatesdemo.databinding.ViewItemTextPostBinding
import com.bluehomestudio.adaptredelegatesdemo.models.Feed
import com.bluehomestudio.adaptredelegatesdemo.models.UserFeedTypes
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun textFeedAdapterDelegate(listener: FeedsAdapter.OnItemClicked) =
    adapterDelegateViewBinding<Feed, Any, ViewItemTextPostBinding>(
        on = { item: Any, _: List<Any>, _: Int -> item is Feed && item.type == UserFeedTypes.TEXT },
        viewBinding = { layoutInflater: LayoutInflater, root: ViewGroup ->
            ViewItemTextPostBinding.inflate(layoutInflater, root, false)
        }
    ) {
        bind {
            binding.root.setOnClickListener { listener.onFeedClicked(id = item.id) }
            binding.feedText.text = item.text
            binding.username.text = item.userName
        }
    }