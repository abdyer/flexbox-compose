package org.andydyer.flexboxcompose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate

@Composable
fun HomeScreen(title: String, navController: NavHostController) {
    val items = Destination.childScreens

    ScreenWithToolbar(title = title) {
        LazyColumn(content = {
            itemsIndexed(items) { index, it ->
                Column {
                    ListItem(it, navController)
                    if (index < items.size - 1) {
                        Divider()
                    }
                }
            }
        })
    }
}

@Composable
private fun ListItem(destination: Destination, navController: NavHostController) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .height(56.dp)
            .clickable(onClick = { navController.navigate(destination.route) }),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            destination.title,
            modifier = Modifier.padding(start = 16.dp),
            style = MaterialTheme.typography.body1
        )
    }
}
