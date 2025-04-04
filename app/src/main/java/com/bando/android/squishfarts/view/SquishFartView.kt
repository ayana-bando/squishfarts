package com.bando.android.squishfarts.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import com.bando.android.squishfarts.R

@Composable
fun SquishFartView() {
    val columns = 3
    val caticorn = painterResource(id = R.drawable.caticorn)
    val cloudMallow = painterResource(id = R.drawable.cloudmallow)
    val clownMallow = painterResource(id = R.drawable.clownmallow)
    val ghostMallow = painterResource(id = R.drawable.ghostmallow)
    val marshMallow = painterResource(id = R.drawable.marshsquish)
    val munchMallow = painterResource(id = R.drawable.munchmallow)
    val rainbowMallow = painterResource(id = R.drawable.rainbowmallow)

    val squishFartImages = listOf(
        caticorn,
        cloudMallow,
        munchMallow,
        clownMallow,
        ghostMallow,
        marshMallow,
        rainbowMallow
    )

    LazyColumn(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize(),
        state = rememberLazyListState()
    ) {
    // Take total count of images and create two columns
        items(squishFartImages.count() / columns) { rowIndex ->
            Row(horizontalArrangement = Arrangement.Start) {
                for (columnIndex in 0 until columns) {
                    // get the index of each image
                    val imageIndex = rowIndex * columns + columnIndex
                    // resize to fit in view
                    if (imageIndex < Constraints.Infinity) {
                        Box(modifier = Modifier
                            .weight(1f, fill = true)
                            .fillParentMaxWidth()
                        )
                        Image(
                            painter = squishFartImages[imageIndex],
                            contentDescription = "Adorable images",
                            modifier = Modifier.padding(end = 16.dp, bottom = 8.dp)
                        )
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun SquishFartViewPreview() {
    SquishFartView()
}