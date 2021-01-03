package org.andydyer.flexboxcompose

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun LayoutScreen(title: String, navController: NavHostController) {
    ChildScreenWithToolbar(title = title, navController = navController) {
        ScrollableColumn {
            Header(text = "Aspect Ratio (16:9)", modifier = Modifier.padding(top = 16.dp))
            AspectRatio()
            Header(text = "Padding & Margins")
            PaddingMargins()
            Header(text = "Absolute Position")
            AbsolutePosition()
        }
    }
}

@Composable
private fun AspectRatio() {
    Box(
        modifier = Modifier.padding(bottom = 16.dp)
            .background(color = MaterialTheme.colors.secondary)
            .fillMaxWidth()
            .aspectRatio(16F / 9F)
            .border(width = 2.dp, color = MaterialTheme.colors.secondaryVariant)
    )
}

@Composable
private fun PaddingMargins() {
    Row(
        modifier = Modifier.padding(bottom = 16.dp)
            .background(color = MaterialTheme.colors.primaryVariant)
            .fillMaxWidth()
    ) {
        Child(modifier = Modifier.padding(16.dp))
        Child(modifier = Modifier.padding(8.dp).padding(8.dp))
        Child(modifier = Modifier.padding(4.dp).padding(4.dp).padding(4.dp).padding(4.dp))
    }
}

@Composable
private fun AbsolutePosition() {
    Box {
        Box(
            modifier = Modifier.fillMaxWidth()
                .height(240.dp)
                .background(color = MaterialTheme.colors.primaryVariant)
        )
        Child(modifier = Modifier.align(Alignment.TopStart))
        Child(modifier = Modifier.align(Alignment.TopEnd))
        Child(modifier = Modifier.align(Alignment.BottomStart))
        Child(modifier = Modifier.align(Alignment.BottomEnd))
        Child(modifier = Modifier.align(Alignment.Center))
    }
}
