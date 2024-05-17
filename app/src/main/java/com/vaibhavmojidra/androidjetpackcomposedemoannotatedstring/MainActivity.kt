package com.vaibhavmojidra.androidjetpackcomposedemoannotatedstring

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vaibhavmojidra.androidjetpackcomposedemoannotatedstring.ui.theme.AndroidJetpackComposeDemoAnnotatedStringTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidJetpackComposeDemoAnnotatedStringTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyScreenDemo()
                }
            }
        }
    }
}


@Composable
fun MyScreenDemo() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AnnotatedStringDemo()
    }
}

@Composable
fun AnnotatedStringDemo() {
    val context = LocalContext.current
    val linkTag = "LinkTag"
    val annotatedString = buildAnnotatedString {
        append("We will never share or sell your number; we will only use it to make sure it's you. See ")
        pushStringAnnotation(tag = linkTag, "VMOS's Privacy Policy")
        pushStyle(
            style = SpanStyle(
                textDecoration = TextDecoration.Underline,
                fontWeight = FontWeight.W700,
                color = Color(0xFF2172BF)
            )
        )
        append("VMOS's Privacy Policy")
        pop()
        append(" to learn more.")
    }

    ClickableText(
        modifier = Modifier.fillMaxWidth(),
        style = TextStyle(fontSize = 17.sp),
        text = annotatedString,
        onClick = {
            Toast.makeText(context, "VMOS's Privacy Policy Click", Toast.LENGTH_LONG).show()
        }
    )
}