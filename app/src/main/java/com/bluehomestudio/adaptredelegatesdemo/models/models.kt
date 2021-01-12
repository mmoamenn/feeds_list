package com.bluehomestudio.adaptredelegatesdemo.models

data class Feed(
    val type: UserFeedTypes,
    val id: String,
    val userName: String,
    val userAvatar: String,
    val text: String,
    val imageURL: String?,
    val videoURL: String?
)

data class Ad(
    val type: AdTypes,
    val id: String,
    val imageURL: String?,
    val videoURL: String?
)

data class InfoBox(val infoID: String, val text: String, val iconURL: String)