package com.bando.android.squishfarts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.bando.android.squishfarts.data.SquishFartImages
import com.bando.android.squishfarts.ui.theme.SquishFartsTheme
import com.bando.android.squishfarts.view.SquishFartView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SquishFartsTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text("SquishFarts")
                            }
                        )
                    }
                ) { innerPadding ->
                    SquishFartView(innerPadding = innerPadding)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SquishFartsTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("SquishFarts")
                    },
                    navigationIcon = {
                        IconButton(onClick = { }) {
                            Icon(
                                painterResource(squishFartImage.image),
                                squishFartImage.description
                            )
                        }
                    }
                )
            }
        ) { innerPadding ->
            SquishFartView(innerPadding)
        }
    }
}

private val squishFartImage = SquishFartImages(
    id = 7,
    image = R.drawable.rainbowmallow,
    description = "Adorable RainbowMallow"
)