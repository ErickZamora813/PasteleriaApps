package com.erick.apppasteleria.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.erick.apppasteleria.data.di.DirectionsService
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Polyline
import com.google.maps.android.PolyUtil
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MapsScreen() {
    val context = LocalContext.current
    val locationPermissionState = rememberMultiplePermissionsState(
        listOf(
            android.Manifest.permission.ACCESS_FINE_LOCATION,
            android.Manifest.permission.ACCESS_COARSE_LOCATION
        )
    )

    if (locationPermissionState.allPermissionsGranted) {
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(LatLng(-34.0, 151.0), 10f)
        }

        val directionsService = DirectionsService.create()
        val routePolyline = remember { mutableStateOf<List<LatLng>>(emptyList()) }
        val coroutineScope = rememberCoroutineScope()

        LaunchedEffect(Unit) {
            val response = directionsService.getDirections(
                origin = "place_id:ChIJd8BlQ2BZwokRAFUEcm_qrcA",  // Replace with your origin place_id or coordinates
                destination = "place_id:ChIJP3Sa8ziYEmsRUKgyFmh9AQM",  // Replace with your destination place_id or coordinates
                apiKey = "YOUR_GOOGLE_MAPS_API_KEY"
            )
            response.routes.firstOrNull()?.overviewPolyline?.points?.let { encodedPath ->
                val path = PolyUtil.decode(encodedPath)
                routePolyline.value = path
            }
        }

        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {
            if (routePolyline.value.isNotEmpty()) {

            }
            Marker(
                state = rememberMarkerState(position = LatLng(-34.0, 151.0)),
                title = "Marker Title",
                snippet = "Marker Snippet"
            )
        }
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Location permission is required to display the map.")
            Button(onClick = { locationPermissionState.launchMultiplePermissionRequest() }) {
                Text("Request Permission")
            }
        }
    }
}