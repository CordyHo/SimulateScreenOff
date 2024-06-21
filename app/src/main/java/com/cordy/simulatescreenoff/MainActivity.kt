package com.cordy.simulatescreenoff

import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.cordy.simulatescreenoff.ui.theme.SimulateScreenOffTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val params = window.attributes
        params.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
        window.attributes = params

        //隐藏SystemBar，适配Android 11
        window.setDecorFitsSystemWindows(false)
        window.insetsController?.hide(WindowInsets.Type.systemBars())
        window.insetsController?.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        setContent {
            SimulateScreenOffTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        "", modifier = Modifier
                            .background(Color.Black)
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SimulateScreenOffTheme {
        Greeting("Android")
    }
}