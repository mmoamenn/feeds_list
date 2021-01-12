package com.bluehomestudio.adaptredelegatesdemo.models

import com.bluehomestudio.adaptredelegatesdemo.serializer.AdSerializer
import com.bluehomestudio.adaptredelegatesdemo.serializer.UserFeedSerializer
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


object Responses {

    private val gsonBuilder: Gson = GsonBuilder().registerTypeAdapter(
        UserFeedTypes::class.java ,
        UserFeedSerializer.UserFeedDeserializer.INSTANCE
    ).registerTypeAdapter(
        AdTypes::class.java,
        AdSerializer.AddDeserializer.INSTANCE
    ).create()

    private fun getFeeds(): List<Feed> = run {
        val feedListType: Type = object : TypeToken<List<Feed>>() {}.type
        return gsonBuilder.fromJson(feedResponse, feedListType)
    }

    private fun getAds(): List<Ad> {
        val feedListType: Type = object : TypeToken<List<Ad>>() {}.type
        return gsonBuilder.fromJson(adResponse, feedListType)
    }

    fun mixItems(): List<Any> {
        val ads = getAds()
        val list: MutableList<Any> = getFeeds().toMutableList()
        list.add(3, ads[0])
        list.add(6, ads[1])
        return list
    }

    private val feedResponse =
        """[
{ "type" : "text" , "id" : "1" , "userName" : "Mohamed Ibrahem" , "userAvatar" :  "" , "text" : "s simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s" 
} , 
{ "type" : "video" , "id" : "2" , "userName" : "Ahmed Ehab" , "userAvatar" :  "" , "text" : "s simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s" 
} ,
{ "type" : "text" , "id" : "3" , "userName" : "Mohamed Moamen" , "userAvatar" :  "" , "text" : "s simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s" 
} ,
{ "type" : "image" , "id" : "4" , "userName" : "Ahmed Nasser" , "userAvatar" :  "" , "text" : "s simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s" 
} ,
{ "type" : "text" , "id" : "5" , "userName" : "Samy Ahmed" , "userAvatar" :  "" , "text" : "s simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s" 
} ,
{ "type" : "image" , "id" : "6" , "userName" : "Ahmed Ragab" , "userAvatar" :  "" , "text" : "s simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s" 
} ,
{ "type" : "text" , "id" : "7" , "userName" : "Mohamed Ibrahem" , "userAvatar" :  "" , "text" : "s simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s" 
} ,
{ "type" : "video" , "id" : "8" , "userName" : "Michal Jakson" , "userAvatar" :  "" , "text" : "s simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s" 
} 
]""".trimIndent()

    private val adResponse = """[
{
"type" : "banner", "id" : "1"
},{
"type" : "video", "id" : "2"
}
]""".trimIndent()

}