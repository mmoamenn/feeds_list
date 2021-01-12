package com.bluehomestudio.adaptredelegatesdemo.serializer

import com.bluehomestudio.adaptredelegatesdemo.models.AdTypes
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type
import java.util.*

object AdSerializer {
    enum class AddDeserializer : JsonDeserializer<AdTypes> {
        INSTANCE {
            override fun deserialize(
                json: JsonElement?,
                typeOfT: Type?,
                context: JsonDeserializationContext?
            ): AdTypes {
                return when (json?.asString?.toUpperCase(Locale.ENGLISH)) {
                    AdTypes.VIDEO.name -> AdTypes.VIDEO
                    AdTypes.BANNER.name -> AdTypes.BANNER
                    else -> AdTypes.UNKNOWN
                }
            }
        }

    }
}