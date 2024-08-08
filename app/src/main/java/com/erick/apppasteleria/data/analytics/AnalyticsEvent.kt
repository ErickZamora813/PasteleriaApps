package com.erick.apppasteleria.data.analytics

import android.content.Context
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

sealed class AnalyticsEvent (val name: String, val params: Bundle = Bundle()){
    object ScreenViewFavorites : AnalyticsEvent("favorites_open")
    object ScrennViewProfile : AnalyticsEvent("profile_open")

}


fun LogAnalyticsEvent(context: Context, event: AnalyticsEvent) {
    val analytics = FirebaseAnalytics.getInstance(context)
    analytics.logEvent(event.name, event.params)
}