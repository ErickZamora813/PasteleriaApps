package com.erick.apppasteleria.data.mapsroutes

import com.google.android.gms.maps.model.LatLng
import org.json.JSONObject
import java.net.URL

suspend fun getRoute(
    origin: LatLng,
    destination: LatLng,
    apiKey: String
): List<LatLng> {
    val url = "https://maps.googleapis.com/maps/api/directions/json?" +
            "origin=${origin.latitude},${origin.longitude}" +
            "&destination=${destination.latitude},${destination.longitude}" +
            "&key=$apiKey"

    val result = URL(url).readText()
    val jsonObject = JSONObject(result)
    val routes = jsonObject.getJSONArray("routes")
    if (routes.length() > 0) {
        val points = routes.getJSONObject(0)
            .getJSONObject("overview_polyline")
            .getString("points")
        return decodePolyline(points)
    }
    return emptyList()
}

fun decodePolyline(encoded: String): List<LatLng> {
    val poly = ArrayList<LatLng>()
    var index = 0
    val len = encoded.length
    var lat = 0
    var lng = 0

    while (index < len) {
        var b: Int
        var shift = 0
        var result = 0
        do {
            b = encoded[index++].code - 63
            result = result or (b and 0x1f shl shift)
            shift += 5
        } while (b >= 0x20)
        val dlat = if (result and 1 != 0) (result shr 1).inv() else result shr 1
        lat += dlat

        shift = 0
        result = 0
        do {
            b = encoded[index++].code - 63
            result = result or (b and 0x1f shl shift)
            shift += 5
        } while (b >= 0x20)
        val dlng = if (result and 1 != 0) (result shr 1).inv() else result shr 1
        lng += dlng

        val p = LatLng(lat.toDouble() / 1E5, lng.toDouble() / 1E5)
        poly.add(p)
    }

    return poly
}
