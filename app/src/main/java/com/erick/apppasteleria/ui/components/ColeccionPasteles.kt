package com.erick.apppasteleria.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.erick.apppasteleria.data.listas.imageList
import com.erick.apppasteleria.ui.theme.BordesImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlin.math.min

@Composable
fun ColeccionPasteles(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

    }


}

fun getImagesForPage(page: Int, pageSize: Int, images: List<Int>): List<Int> {
    val fromIndex = page * pageSize
    val toIndex = minOf(fromIndex + pageSize, images.size)
    return if (fromIndex < toIndex) images.subList(fromIndex, toIndex) else emptyList()
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun IconosPasteles() {


    val pageSize = 6
    val pages = (imageList.size + pageSize - 1) / pageSize // Número total de páginas
    val pagerState = rememberPagerState()


    HorizontalPager(
        count = pages,
        state = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) { page ->
        val start = page * pageSize
        val end = min(start + pageSize, imageList.size)
        val currentImages = imageList.subList(start, end)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            currentImages.chunked(3).forEach { rowImages ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    rowImages.forEach { imageRes ->
                        Image(
                            painter = painterResource(id = imageRes),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(110.dp)
                                .clip(CircleShape)
                                .border(2.dp, BordesImage, CircleShape)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewimagenes() {
    IconosPasteles()

}

