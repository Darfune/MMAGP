package com.example.gamepower

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gamepower.screens.details.DetailsScreen
import com.example.gamepower.screens.home.HomeScreen
import com.example.gamepower.ui.theme.GamePowerTheme
import com.example.network.model.domain.giveaway.Giveaway

class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()

            GamePowerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navController, startDestination = "home"){
                        composable("home"){ HomeScreen(){
                            navController.navigate("details/$it")
                        } }
                        composable("details/{description}"){ backStackEntry ->
                            val description: String = backStackEntry.arguments?.getString("description") ?: ""
                            DetailsScreen(description)
//                            val giveaway = navController.previousBackStackEntry?.savedStateHandle?.get<Giveaway>("giveaway")
//                            if (giveaway != null) {
//                                DetailsScreen(giveaway)
//                            }
                        }
                    }
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
    GamePowerTheme {
        Greeting("Android")
    }
}