package com.bluehomestudio.adaptredelegatesdemo.adapter

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class FeedsAdapter(listener: OnItemClicked) : ListDelegationAdapter<List<Any>>(
    textFeedAdapterDelegate(listener = listener),
    imageFeedAdapterDelegate(listener = listener),
    videoFeedAdapterDelegate(listener = listener),
    bannerAdAdapterDelegate(listener = listener),
    videoAddAdapterDelegate(listener = listener)
) {

    interface OnItemClicked {
        fun onFeedClicked(id: String)
        fun onAdClicked(id: String)
    }
}