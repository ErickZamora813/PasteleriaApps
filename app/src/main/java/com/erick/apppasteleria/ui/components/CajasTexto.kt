package com.erick.apppasteleria.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.erick.apppasteleria.data.listas.itemList
import com.erick.apppasteleria.ui.theme.BoxFavoritos
import com.erick.apppasteleria.ui.theme.PinkPasteleria
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn( ExperimentalPagerApi::class)
@Composable
fun TextoImage(modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState()
    val itemsPerPage = 3

    Column {
        HorizontalPager(
            count = (itemList.size + itemsPerPage - 1) / itemsPerPage,  // Número de páginas necesarias
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                //.weight(1f)
        ) { page ->
            Column {
                val startIndex = page * itemsPerPage
                val endIndex = (startIndex + itemsPerPage).coerceAtMost(itemList.size)
                val itemsOnPage = itemList.subList(startIndex, endIndex)

                itemsOnPage.forEach { item ->
                    Box(
                        modifier
                            .fillMaxWidth()
                    ) {
                        Column(Modifier.background(BoxFavoritos)) {
                            Text(text = item.title, modifier.padding(10.dp), color = Color.White)
                            Row {
                                Image(
                                    painter = painterResource(id = item.imageRes),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(110.dp)
                                        .padding(15.dp)
                                        .clip(CircleShape)
                                )
                                Text(
                                    text = item.description,
                                    modifier.padding(10.dp),
                                    color = Color.White
                                )
                            }
                        }
                    }
                    Spacer(
                        modifier = modifier
                            .height(10.dp)
                            .background(PinkPasteleria)
                    )
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFuncionxd() {
    TextoImage()
}
