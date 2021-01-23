package org.andydyer.flexboxcompose

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ArrangementScreen(title: String, navController: NavHostController) {
    ChildScreenWithToolbar(title = title, navController = navController) {
        ScrollableColumn {
            Header(text = "Start", modifier = Modifier.padding(top = 16.dp))
            Start()
            Header(text = "End")
            End()
            Header(text = "Center")
            Center()
            Header(text = "Space Around")
            SpaceAround()
            Header(text = "Space Between")
            SpaceBetween()
            Header(text = "Space Evenly")
            SpaceEvenly()
        }
    }
}

@Composable
private fun Start() {
    ArrangementRow(arrangement = Arrangement.Start)
}

@Composable
private fun End() {
    ArrangementRow(arrangement = Arrangement.End)
}

@Composable
private fun Center() {
    ArrangementRow(arrangement = Arrangement.Center)
}

@Composable
private fun SpaceAround() {
    ArrangementRow(arrangement = Arrangement.SpaceAround)
}

@Composable
private fun SpaceBetween() {
    ArrangementRow(arrangement = Arrangement.SpaceBetween)
}

@Composable
private fun SpaceEvenly() {
    ArrangementRow(arrangement = Arrangement.SpaceEvenly)
}

@Composable
private fun ArrangementRow(arrangement: Arrangement.Horizontal) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(bottom = 16.dp)
            .background(color = MaterialTheme.colors.primaryVariant),
        horizontalArrangement = arrangement,
    ) {
        Child()
        Child()
        Child()
    }
}
