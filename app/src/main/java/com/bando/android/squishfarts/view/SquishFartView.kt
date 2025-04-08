package com.bando.android.squishfarts.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.bando.android.squishfarts.R

@Composable
fun SquishFartView(onBack: () -> Unit, innerPadding: PaddingValues) {
    val caticorn = painterResource(id = R.drawable.caticorn)
    val cloudMallow = painterResource(id = R.drawable.cloudmallow)
    val clownMallow = painterResource(id = R.drawable.clownmallow)
    val ghostMallow = painterResource(id = R.drawable.ghostmallow)
    val marshMallow = painterResource(id = R.drawable.marshsquish)
    val munchMallow = painterResource(id = R.drawable.munchmallow)
    val rainbowMallow = painterResource(id = R.drawable.rainbowmallow)

    val squishFartImages = remember {
        mutableStateListOf(
            caticorn,
            cloudMallow,
            munchMallow,
            clownMallow,
            ghostMallow,
            marshMallow,
            rainbowMallow
        )
    }

    var isSelected by remember { mutableStateOf(false) }

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 130.dp),
        modifier = Modifier.padding(innerPadding)
    ) {
        items(squishFartImages.size) { imageIndex ->
            // TODO add sound to image click from list
            Image(
                painter = squishFartImages[imageIndex],
                contentDescription = "Adorable images",
                modifier = Modifier
                    .padding(end = 16.dp, bottom = 8.dp)
                    .clickable { isSelected = !isSelected }
            )

            //TODO update to display *selected* image
            if (isSelected) {
                SelectedSquishFart(
                    squishFartImage = squishFartImages[imageIndex],
                    onDismiss = { !isSelected }
                )

            }
        }

    }
}

@Composable
fun SelectedSquishFart(
    squishFartImage: Painter,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(375.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column( modifier = Modifier.padding(start = 16.dp, top = 8.dp),
                horizontalAlignment = Alignment.Start
            ) {
                //TODO Add transparency to button
                Button(
                    onClick = onDismiss,
                    modifier = Modifier
                        .height(25.dp)
                        .width(40.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.close_icon),
                        contentDescription = "Close"
                    )
                }
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // TODO add sound to image click
                Image(
                    painter = squishFartImage,
                    contentDescription = "Adorable Image",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .height(260.dp)
                        .width(260.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun SquishFartViewPreview() {
    SquishFartView({ }, PaddingValues())
}

@Preview
@Composable
fun SelectedSquishFartDialogPreview() {
    SelectedSquishFart(squishFartImage = painterResource(R.drawable.clownmallow)) {
    }
}