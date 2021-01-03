package org.andydyer.flexboxcompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

internal sealed class Destination {

    companion object {
        val childScreens = listOf(
            Flex,
            Arrangement,
            Alignment,
            AlignSelf,
            Layout
        )
    }

    abstract val route: String

    abstract val title: String

    @Composable
    abstract fun content(navController: NavHostController)

    object Home : Destination() {
        override val route: String = "home"
        override val title: String = "Flexbox Compose"

        @Composable
        override fun content(navController: NavHostController) {
            HomeScreen(title = title, navController = navController)
        }
    }

    object Flex : Destination() {
        override val route: String = "flex"
        override val title: String = "Flex"

        @Composable
        override fun content(navController: NavHostController) {
            FlexScreen(title = title, navController = navController)
        }
    }

    object Arrangement : Destination() {
        override val route: String = "arrangement"
        override val title: String = "Arrangement"

        @Composable
        override fun content(navController: NavHostController) {
            ArrangementScreen(title = title, navController = navController)
        }
    }

    object Alignment : Destination() {
        override val route: String = "alignment"
        override val title: String = "Alignment"

        @Composable
        override fun content(navController: NavHostController) {
            AlignmentScreen(title = title, navController = navController)
        }
    }

    object AlignSelf : Destination() {
        override val route: String = "align-self"
        override val title: String = "Align Self"

        @Composable
        override fun content(navController: NavHostController) {
            AlignSelfScreen(title = title, navController = navController)
        }
    }

    object Layout : Destination() {
        override val route: String = "layout"
        override val title: String = "Layout"

        @Composable
        override fun content(navController: NavHostController) {
            LayoutScreen(title = title, navController = navController)
        }
    }
}
