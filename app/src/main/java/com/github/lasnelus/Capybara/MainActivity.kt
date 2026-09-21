package com.github.lasnelus.Capybara

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.github.lasnelus.Capybara.ui.feature.home.HomeScreen
import com.github.lasnelus.Capybara.ui.theme.CapybaraTheme
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class MainActivity : ComponentActivity() {
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        
        setContent {
            val context = LocalContext.current
            val requestPermissionLauncher = rememberLauncherForActivityResult(
                contract = androidx.activity.result.contract.ActivityResultContracts.RequestPermission()
            ) { isGranted ->
                if (isGranted) {
                    getLastKnownLocation()
                } else {
                    Toast.makeText(context, "Permission refusée", Toast.LENGTH_SHORT).show()
                }
            }

            androidx.compose.runtime.LaunchedEffect(Unit) {
                if (ContextCompat.checkSelfPermission(
                        context,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ) == PackageManager.PERMISSION_GRANTED
                ) {
                    getLastKnownLocation()
                } else {
                    requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
                }
            }

            CapybaraTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen(LocalContext.current)
                }
            }
        }
    }

    private fun getLastKnownLocation() {
        // Kotlin way to do @RequiresPermission
        if (ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            fusedLocationClient.lastLocation
                .addOnSuccessListener { loc ->
                    Log.d("Permission", "Permission granted")
                    Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { err ->
                    err.message?.let { Log.d("Permission", it) }
                    Toast.makeText(this, err.message, Toast.LENGTH_SHORT).show()
                }
        } else {
            Log.d("Permission", "Permission denied")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    CapybaraTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            HomeScreen(LocalContext.current)
        }
    }
}