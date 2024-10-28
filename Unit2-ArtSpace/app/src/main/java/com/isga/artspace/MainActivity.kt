package com.isga.artspace


//import android.inputmethodservice.Keyboard
import android.media.Image
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.content.contentReceiver
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {

    lateinit var measurables: List<Measurable>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Layout()
        }
    }

    @Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
    @Composable
    fun Layout() {
        val imageList = listOf(R.drawable.img1, R.drawable.img2, R.drawable.img3)
        val titleList = listOf("Ranni The Witch", "Read People Like Books", "Exceptionally Unexceptional")
        val artistsList = listOf("RedFive", "Genshin Impact", "Genshin Impact")

        var currentIndex by remember { mutableStateOf(0) }
        Column(verticalArrangement = Arrangement.SpaceEvenly) {

            val imageMod = Modifier
                .size(300.dp)
                .align(Alignment.CenterHorizontally)
                .padding(20.dp)
                .layoutId("image")
            val contentMod = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(15.dp)

            Surface(
                Modifier
                    .padding(10.dp)
                    .align(Alignment.CenterHorizontally),
                shadowElevation = 8.dp
            ) {
                Image(
                    painter = painterResource(imageList[currentIndex]),
                    contentDescription = "Image",
                    contentScale = ContentScale.Fit,
                    modifier = imageMod,
                )
            }
            Box(
                Modifier
                    .padding(10.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(Color(0xAAd5e1f5))
                    .sizeIn(250.dp)
            ) {
                Column(Modifier.align(Alignment.Center)) {
                    Text(titleList[currentIndex], modifier = contentMod)
                    Text(artistsList[currentIndex], modifier = contentMod)
                }
            }
            Row(modifier = contentMod) {

                Button({
                    if (currentIndex > 0) {
                        currentIndex--
                    }
                },
                    Modifier
                        .padding(10.dp)
                        .height(35.dp)) { Text("Previous") }
                Button({
                    if (currentIndex < imageList.size - 1) {
                        currentIndex++
                    }
                },
                    Modifier
                        .padding(10.dp)
                        .height(35.dp)) { Text("Next") }
            }
        }

    }

    fun onClickButton(): Unit {

    }
}