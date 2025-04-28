package com.bando.android.squishfarts.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bando.android.squishfarts.R
import com.bando.android.squishfarts.data.SquishFartImages
import com.bando.android.squishfarts.viewmodel.SquishFartViewModel

//TODO add docs
@Composable
fun SquishFartView(innerPadding: PaddingValues, viewModel: SquishFartViewModel = viewModel()) {

    val squishFartImages = remember {
        listOf(
            SquishFartImages(
                id = 1,
                image = R.drawable.caticorn,
                description = "Adorable Cat-icorn"
            ),
            SquishFartImages(
                id = 2,
                image = R.drawable.cloudmallow,
                description = "Adorable CloudMallow"
            ),
            SquishFartImages(
                id = 3,
                image = R.drawable.clownmallow,
                description = "Adorable ClownMallow"
            ),
            SquishFartImages(
                id = 4,
                image = R.drawable.ghostmallow,
                description = "Adorable GhostMallow"
            ),
            SquishFartImages(
                id = 5,
                image = R.drawable.marshsquish,
                description = "Adorable MarshMallow"
            ),
            SquishFartImages(
                id = 6,
                image = R.drawable.munchmallow,
                description = "Adorable MunchMallow"
            ),
            SquishFartImages(
                id = 7,
                image = R.drawable.rainbowmallow,
                description = "Adorable RainbowMallow"
            )
        )
    }

    val isSelected = remember { mutableStateOf(false) }

    var selectedImageId = 0
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive(minSize = 128.dp),
        modifier = Modifier.padding(innerPadding)
    ) {
        items(squishFartImages, key = { it.id }) { squishFart ->
            // TODO add sound to image click from list
            Image(
                painter = painterResource(squishFart.image),
                contentDescription = "Adorable images",
                modifier = Modifier
                    .padding(end = 16.dp, bottom = 8.dp)
                    .clickable {
                        isSelected.value = !isSelected.value
                        selectedImageId = squishFart.id
                        viewModel.soundEffects.value.first().name
                    }
            )

            if (isSelected.value && (squishFart.id == selectedImageId)) {
                SelectedSquishFart(
                    squishFartImage = squishFart.image,
                    onDismiss = isSelected,
                    description = squishFart.description
                )
            }
        }
    }
}

@Composable
fun SelectedSquishFart(
    squishFartImage: Int,
    onDismiss: MutableState<Boolean>,
    description: String?
) {
    Dialog(onDismissRequest = { onDismiss.value = false }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(375.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(start = 16.dp, top = 8.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Button(
                    onClick = { onDismiss.value = false },
                    modifier = Modifier
                        .height(25.dp)
                        .width(40.dp),
                    elevation = ButtonDefaults.elevation(0.dp),
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
                    painter = painterResource(squishFartImage),
                    contentDescription = description,
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
    SquishFartView(PaddingValues())
}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun SelectedSquishFartDialogPreview() {
    SelectedSquishFart(squishFartImage.image, mutableStateOf(false), squishFartImage.description)
}

private val squishFartImage =  SquishFartImages(
    id = 7,
    image = R.drawable.rainbowmallow,
    description = "Adorable RainbowMallow"
)