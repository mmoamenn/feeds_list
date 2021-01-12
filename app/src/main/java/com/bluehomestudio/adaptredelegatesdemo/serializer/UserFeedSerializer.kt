package com.bluehomestudio.adaptredelegatesdemo.serializer

import com.bluehomestudio.adaptredelegatesdemo.models.UserFeedTypes
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type
import java.util.*

object UserFeedSerializer {
    enum class UserFeedDeserializer : JsonDeserializer<UserFeedTypes> {
        INSTANCE {
            override fun deserialize(
                json: JsonElement?,
                typeOfT: Type?,
                context: JsonDeserializationContext?
            ): UserFeedTypes {
                return when (json?.asString?.toUpperCase(Locale.ENGLISH)) {
                    UserFeedTypes.TEXT.name -> UserFeedTypes.TEXT
                    UserFeedTypes.VIDEO.name -> UserFeedTypes.VIDEO
                    UserFeedTypes.IMAGE.name -> UserFeedTypes.IMAGE
                    else -> UserFeedTypes.UNKNOWN
                }
            }
        }

    }
}