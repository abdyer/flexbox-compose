package org.andydyer.flexboxcompose

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun AlignmentScreen(title: String, navController: NavHostController) {
    ChildScreenWithToolbar(title = title, navController = navController) {
        ScrollableColumn {
            Header(text = "Start", modifier = Modifier.padding(top = 16.dp))
            Start()
            Header(text = "End")
            End()
            Header(text = "Center")
            Center()
        }
    }
}

@Composable
private fun Start() {
    AlignmentRow(alignment = Alignment.Top)
}

@Composable
private fun End() {
    AlignmentRow(alignment = Alignment.Bottom)
}

@Composable
private fun Center() {
    AlignmentRow(alignment = Alignment.CenterVertically)
}

@Composable
private fun AlignmentRow(alignment: Alignment.Vertical) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .height(150.dp)
            .padding(bottom = 16.dp)
            .background(color = MaterialTheme.colors.primaryVariant),
        verticalAlignment = alignment,
    ) {
        Child()
        Child()
        Child()
    }
}
