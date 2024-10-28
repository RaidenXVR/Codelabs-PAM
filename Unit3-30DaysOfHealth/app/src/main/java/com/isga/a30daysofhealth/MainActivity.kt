package com.isga.a30daysofhealth

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
//import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { ScrollLayout() }
    }

    @Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
    @Composable
    fun ScrollLayout() {
        val config = LocalConfiguration.current
        val screenWidth = config.screenWidthDp
        val screenHeight = config.screenHeightDp

        val tips: Array<String> = resources.getStringArray(R.array.tips)
        val images: Array<Int> = arrayOf(
            R.drawable.img0,
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5
        )
        Column(Modifier
            .size(screenWidth.dp, screenHeight.dp)
            .padding(10.dp)
            .verticalScroll(rememberScrollState())) {
            var idx = 0
            for (tip in tips){
                CardLayout(image = images[idx % images.size], tip, idx+1)
                idx++
            }
        }
    }

//    @PreviewParameter()
    @Composable
    fun CardLayout(image: Int, text:String, day:Int){
        val config = LocalConfiguration.current
        val screenWidth = config.screenWidthDp
        var expendedState by remember { mutableStateOf(false) }
        ElevatedCard (
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            onClick = {
                expendedState = !expendedState

                      },
            modifier = Modifier
                .layoutId("day${day}")
                .defaultMinSize(300.dp, 200.dp)
                .background(Color(0xA255A987))
                .padding(10.dp)
                .width(screenWidth.dp),
            ){


            Column{
                Text(text= "Day ${day}", modifier = Modifier.padding(10.dp), fontSize = 20.sp)
                Image(painter = painterResource(image), contentDescription = "Image", modifier =  Modifier.height(100.dp), contentScale = ContentScale.Crop)
                if (expendedState){
                    Text(text, modifier = Modifier.padding(10.dp), fontSize = 25.sp, fontFamily = FontFamily.Monospace)
                }
            }
        }

    }
}