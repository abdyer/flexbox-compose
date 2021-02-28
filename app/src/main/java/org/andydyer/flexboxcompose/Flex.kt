package org.andydyer.flexboxcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun FlexScreen(title: String, navController: NavHostController) {
    ChildScreenWithToolbar(title = title, navController = navController) {
        ScrollableColumn {
            Header(text = "Flex Grow", modifier = Modifier.padding(top = 16.dp))
            FlexGrow()
            Header(text = "Flex Wrap")
            FlexWrap()
            Header(text = "Flex Shrink")
            FlexShrink()
        }
    }
}

@Composable
private fun FlexGrow() {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(bottom = 16.dp)
            .background(color = MaterialTheme.colors.primaryVariant),
    ) {
        FlexChild(modifier = Modifier.weight(1F))
        FlexChild(modifier = Modifier.weight(2F))
        FlexChild(modifier = Modifier.weight(1F))
    }
}

@Composable
private fun FlexShrink() {
    FlexRow(
        modifier = Modifier
            .padding(bottom = 16.dp)
            .background(color = MaterialTheme.colors.primaryVariant),
    ) {
        FlexChild(modifier = Modifier.width(100.dp).flexGrow(1F).flexShrink(0F))
        FlexChild(modifier = Modifier.width(100.dp).flexGrow(2F).flexShrink(0F))
        // TODO: Finish flex shrink implementation in FlexRow
        FlexChild(modifier = Modifier.width(100.dp).flexGrow(1F).flexShrink(1F))
    }
}

@Composable
private fun FlexWrap() {
    Box(
        modifier = Modifier.fillMaxWidth()
            .padding(bottom = 16.dp)
            .background(color = MaterialTheme.colors.primaryVariant)
    ) {
        FlowRow(
            mainAxisSpacing = 8.dp,
            crossAxisSpacing = 8.dp
        ) {
            repeat(20) {
                Child(width = 48.dp, height = 24.dp)
            }
        }
    }
}

@Composable
private fun FlexChild(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.background(color = MaterialTheme.colors.secondary)
            // No width specified here because weight controls it
            .height(100.dp)
            .border(width = 2.dp, color = MaterialTheme.colors.secondaryVariant)
    )
}

