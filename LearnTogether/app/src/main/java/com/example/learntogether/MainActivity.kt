package com.example.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnTogetherTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ComposeArticle(
                        title = stringResource(R.string.title),
                        subtitle = stringResource(R.string.sub_title),
                        description = stringResource(R.string.description),
                        imagePainter = painterResource(R.drawable.bg_compose_background)
                    )
                }
            }
        }
    }
}

@Composable
fun HeaderImage(imagePainter: Painter, modifier: Modifier = Modifier) {
    Image(
        painter = imagePainter,
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
    )
}

@Composable
fun TitleText(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        fontSize = 24.sp,
        modifier = modifier
            .padding(16.dp)
    )
}

@Composable
fun SubTitleText(subtitle: String, modifier: Modifier = Modifier) {
    Text(
        text = subtitle,
        textAlign = TextAlign.Justify,
        modifier = modifier
            .padding(horizontal = 16.dp)
    )
}

@Composable
fun DescriptionText(description: String, modifier: Modifier = Modifier) {
    Text(
        text = description,
        textAlign = TextAlign.Justify,
        modifier = modifier
            .padding(16.dp)
    )
}

@Composable
fun ComposeArticle(
    title: String,
    subtitle: String,
    description: String,
    imagePainter: Painter,
    modifier: Modifier = Modifier
    ) {
    Column {
        HeaderImage(imagePainter = imagePainter)
        TitleText(title = title)
        SubTitleText(subtitle = subtitle)
        DescriptionText(description = description)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnTogetherTheme {
        ComposeArticle(
            title = stringResource(R.string.title),
            subtitle = stringResource(R.string.sub_title),
            description = stringResource(R.string.description),
            imagePainter = painterResource(R.drawable.bg_compose_background)
        )
    }
}