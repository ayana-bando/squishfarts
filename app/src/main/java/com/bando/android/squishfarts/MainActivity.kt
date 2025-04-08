package com.bando.android.squishfarts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.bando.android.squishfarts.ui.theme.SquishFartsTheme
import com.bando.android.squishfarts.view.SquishFartView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
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
                    SquishFartView(onBack = { navController.popBackStack() }, innerPadding = innerPadding)
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
                            Icon(painterResource(R.drawable.arrow_back_icon), "")
                        }
                    }
                )
            }
        ) { innerPadding ->
            SquishFartView(  {}, innerPadding)
        }
    }
}