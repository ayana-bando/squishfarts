package com.bando.android.squishfarts.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import com.bando.android.squishfarts.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SquishFartView() {
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

    LazyVerticalGrid(cells = GridCells.Adaptive(minSize = 130.dp)) {
        items(squishFartImages.size) { scope ->
            Image(
                painter = squishFartImages[scope],
                contentDescription = "Adorable images",
                modifier = Modifier.padding(end = 16.dp, bottom = 8.dp)
            )

        }
    }
}


@Preview
@Composable
fun SquishFartViewPreview() {
    SquishFartView()
}