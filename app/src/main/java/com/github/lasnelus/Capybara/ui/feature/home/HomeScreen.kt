package com.github.lasnelus.Capybara.ui.feature.home

import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.github.lasnelus.Capybara.R
import java.time.LocalDate

@Composable
fun MyImage(imageBitmap: ImageBitmap?) {
    val modifier = Modifier
        .width(100.dp)
        .height(100.dp)
    return if (imageBitmap == null) {
        Image(
            modifier = modifier,
            painter = painterResource(R.drawable.user),
            contentDescription = ""
        )
    } else {
        Image(
            modifier = modifier,
            bitmap = imageBitmap,
            contentDescription = ""
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(
    onDetailClick: (String) -> Unit
) {
    var imageBitmap by remember { mutableStateOf<ImageBitmap?>(null) }
    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview()
    ) { bitmap -> imageBitmap = bitmap?.asImageBitmap() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .statusBarsPadding()
            .navigationBarsPadding(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    cameraLauncher.launch()
                },
            contentAlignment = Alignment.TopEnd
        ) {
            MyImage(imageBitmap)
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {

            Text(
                text = stringResource(R.string.home_today),
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center
            )
            Image(
                painter = painterResource(id = R.drawable.il_sun_cloud),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(0.85f)
            )
            Text(
                text = stringResource(R.string.degree_value, 30),
                color = MaterialTheme.colorScheme.secondary,

                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center
            )

            Button(
                onClick = {
                    onDetailClick(LocalDate.now().toString())
                }
            ) {
                Text(
                    text = stringResource(R.string.detailed_view),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}