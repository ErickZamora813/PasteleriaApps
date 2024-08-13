package com.erick.apppasteleria.data.mapsroutes

data class Directions (
    val routes: List<Route>
)

data class Route(
    val overviewPolyline: OverviewPolyline
)

data class OverviewPolyline(
    val points: String
)