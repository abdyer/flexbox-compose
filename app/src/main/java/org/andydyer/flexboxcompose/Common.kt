package org.andydyer.flexboxcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ChildScreenWithToolbar(
    title: String,
    navController: NavHostController,
    content: @Composable () -> Unit
) {
    ScreenWithToolbar(
        title = title,
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(imageVector = Icons.Filled.ArrowBack)
            }
        },
        content = content
    )
}

@Composable
fun ScreenWithToolbar(
    title: String,
    navigationIcon: @Composable (() -> Unit)? = null,
    content: @Composable () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(title) }, navigationIcon = navigationIcon)
        },
        bodyContent = {
            content()
        }
    )
}

@Composable
fun Child(
    modifier: Modifier = Modifier,
    width: Dp = 100.dp,
    height: Dp = 100.dp
) {
    Box(
        modifier = modifier.background(color = MaterialTheme.colors.secondary)
            .width(width)
            .height(height)
            .border(width = 2.dp, color = MaterialTheme.colors.secondaryVariant)
    )
}

@Composable
fun Header(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier.padding(bottom = 8.dp, start = 16.dp),
        style = MaterialTheme.typography.h6
    )
}
