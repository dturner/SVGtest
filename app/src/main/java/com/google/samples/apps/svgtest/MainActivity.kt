package com.google.samples.apps.svgtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.Coil
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import coil.decode.SvgDecoder
import coil.imageLoader
import com.google.samples.apps.svgtest.ui.theme.SVGTestTheme

val toolsIconUrl = "https://firebasestorage.googleapis.com/v0/b/now-in-android.appspot.com/o/img%2Fic_topic_Tools.svg?alt=media&token=4df6167c-06ef-4fdd-9f7b-94a5d7f3376b"
val uiIconUrl = "https://firebasestorage.googleapis.com/v0/b/now-in-android.appspot.com/o/img%2Fic_topic_UI.svg?alt=media&token=5d1d25a8-db1b-4cf1-9706-82ba0d133bf9"
val securityIconUrl = "https://firebasestorage.googleapis.com/v0/b/now-in-android.appspot.com/o/img%2Fic_topic_Privacy%20%26%20Security.svg?alt=media&token=48cb3487-32f9-40fc-bf62-c488973150fc"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val imageLoader = ImageLoader.Builder(this)
            .components {
                add(SvgDecoder.Factory())
            }
            .build()

        Coil.setImageLoader(imageLoader = imageLoader)

        setContent {
            SVGTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        IconImage(toolsIconUrl)
                        IconImage(uiIconUrl)
                        IconImage(securityIconUrl)
                    }
                }
            }
        }
    }
}

@Composable
fun IconImage(modelUrl : String){
    AsyncImage(
        modifier = Modifier.width(64.dp),
        model = modelUrl,
        contentDescription = null
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SVGTestTheme {
        IconImage(toolsIconUrl)
    }
}