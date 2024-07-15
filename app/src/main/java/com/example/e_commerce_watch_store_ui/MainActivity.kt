package com.example.e_commerce_watch_store_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.e_commerce_watch_store_ui.ui.screen.DetailScreen
import com.example.e_commerce_watch_store_ui.ui.screen.HomeScreen
import com.example.e_commerce_watch_store_ui.ui.theme.E_Commerce_Watch_Store_UITheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			val navHostController = rememberNavController()

			E_Commerce_Watch_Store_UITheme {
				Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
					SetupNavigation(navHostController = navHostController)
				}
			}
		}
	}
}

@Composable
fun SetupNavigation(
	modifier: Modifier = Modifier,
	navHostController: NavHostController
) {
	NavHost(
		startDestination = "home",
		navController = navHostController
	) {
		composable("home") { HomeScreen(navHostController = navHostController) }
		composable("detail") { DetailScreen(onClickBack = { navHostController.popBackStack() }) }
	}

}