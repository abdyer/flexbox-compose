package org.andydyer.flexboxcompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.andydyer.flexboxcompose.ui.FlexboxComposeTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FlexboxComposeTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = Destination.Home.route) {
                    destination(Destination.Home, navController)
                    destination(Destination.Flex, navController)
                    destination(Destination.Arrangement, navController)
                    destination(Destination.Alignment, navController)
                    destination(Destination.AlignSelf, navController)
                    destination(Destination.Layout, navController)
                }
            }
        }
    }

    private fun NavGraphBuilder.destination(
        destination: Destination,
        navController: NavHostController
    ) {
        composable(destination.route) { destination.content(navController) }
    }
}
