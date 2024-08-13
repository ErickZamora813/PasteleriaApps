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
import coil.compose.rememberImagePainter
import coil.size.Scale
import com.erick.apppasteleria.R
import com.erick.apppasteleria.data.listas.imageList
import com.erick.apppasteleria.domain.listeners.Pasteles
import com.erick.apppasteleria.ui.theme.BordesImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlin.math.min


@OptIn(ExperimentalPagerApi::class)
@Composable
fun IconosPasteles(pastelesList: List<Pasteles>) {



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
        val currentImages = pastelesList.subList(start, end)

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
                    rowImages.forEach { pastel ->
                        Image(
                            painter = rememberImagePainter(
                                data = pastel.imagen,
                                builder = {
                                    scale(Scale.FILL)
                                    placeholder(R.drawable.pastel2)
                                    error(R.drawable.pastel3)
                                }
                            ),
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


}

