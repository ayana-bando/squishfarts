package com.bando.android.squishfarts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bando.android.squishfarts.ui.theme.SquishFartsTheme
import com.bando.android.squishfarts.view.SquishFartView

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
                ) {
                    SquishFartView()
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
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = ""
                            )
                        }
                    }
                )
            }
        ) {
            SquishFartView()
        }
    }
}