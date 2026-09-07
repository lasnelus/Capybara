package com.github.lasnelus.Capybara

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.github.lasnelus.Capybara.ui.theme.CapybaraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CapybaraTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = stringResource(id= R.string.home_today),
                        color = MaterialTheme.colorScheme.secondary,
                        style = MaterialTheme.typography.titleSmall,
                        textAlign = TextAlign.Center
                    )
                    Image(
                        painter = painterResource(id = R.drawable.il_sun_cloud),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth(fraction = 0.85f)
                    )
                    Text(text = stringResource(id= R.string.degree_value),
                        color = MaterialTheme.colorScheme.secondary,
                        style = MaterialTheme.typography.titleSmall,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CapybaraTheme {
        Greeting("Android")
    }
}