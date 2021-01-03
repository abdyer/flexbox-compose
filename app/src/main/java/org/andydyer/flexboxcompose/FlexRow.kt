package org.andydyer.flexboxcompose

import android.util.Log
import androidx.compose.foundation.layout.LayoutScopeMarker
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.ParentDataModifier
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp

/**
 * A custom flexbox row implementation in Compose
 */
@Composable
fun FlexRow(
    modifier: Modifier = Modifier,
    content: @Composable FlexRowScope.() -> Unit
) {
    Layout(
        modifier = modifier,
        content = { FlexRowScope.content() }
    ) { measurables, constraints ->
        val rowColumnParentData = Array(measurables.size) {
            measurables[it].parentData as? FlexRowParentData ?: FlexRowParentData()
        }

        val growSum = rowColumnParentData.sumOf { it.flexGrow.toDouble() }
        Log.d("FlexRow", "grow sum: $growSum")

        val placeables = measurables.mapIndexed { index, measurable ->
            val (grow, shrink, width) = rowColumnParentData[index]
            Log.d("FlexRow", "grow: $grow, shrink: $shrink, width: ${width?.toPx()}")

            // TODO: Calculate flex grow & shrink
            // https://www.w3.org/TR/css-flexbox-1/#resolve-flexible-lengths
            // https://github.com/google/flexbox-layout/blob/master/flexbox/src/main/java/com/google/android/flexbox/FlexboxHelper.java

            val maxWidth = (constraints.maxWidth * (grow / growSum)).toInt()
            Log.d("FlexRow", "max width: $maxWidth")

            val childConstraints = if (shrink > 0) {
                val shrinkWidth = (constraints.maxWidth * (shrink / growSum)).toInt()
                Log.d("FlexRow", "shrink width: $shrinkWidth")

                constraints.copy(minWidth = 0, maxWidth = shrinkWidth)
            } else {
                constraints.copy(minWidth = maxWidth, maxWidth = maxWidth)
            }

            measurable.measure(childConstraints)
        }

        val height = placeables.map { it.height }.maxOrNull() ?: constraints.maxHeight

        var xPosition = 0

        layout(constraints.maxWidth, height) {
            placeables.forEach { placeable ->
                placeable.placeRelative(x = xPosition, y = 0)

                xPosition += placeable.width
            }
        }
    }
}

@LayoutScopeMarker
@Immutable
interface FlexRowScope {

    fun Modifier.flexGrow(flexGrow: Float) = this.then(
        FlexGrowModifier(flexGrow)
    )

    fun Modifier.flexShrink(flexShrink: Float) = this.then(
        FlexShrinkModifier(flexShrink)
    )

    fun Modifier.width(width: Dp) = this.then(
        WidthModifier(width)
    )

    companion object : FlexRowScope
}

internal data class FlexRowParentData(
    var flexGrow: Float = 0F,
    var flexShrink: Float = 1F,
    var width: Dp? = null
)

internal class FlexGrowModifier(
    private val flexGrow: Float
) : ParentDataModifier {
    override fun Density.modifyParentData(parentData: Any?): FlexRowParentData {
        return ((parentData as? FlexRowParentData) ?: FlexRowParentData()).also {
            it.flexGrow = flexGrow
        }
    }
}

internal class FlexShrinkModifier(
    private val flexShrink: Float
) : ParentDataModifier {
    override fun Density.modifyParentData(parentData: Any?): FlexRowParentData {
        return ((parentData as? FlexRowParentData) ?: FlexRowParentData()).also {
            it.flexShrink = flexShrink
        }
    }
}

internal class WidthModifier(
    private val width: Dp
) : ParentDataModifier {
    override fun Density.modifyParentData(parentData: Any?): FlexRowParentData {
        return ((parentData as? FlexRowParentData) ?: FlexRowParentData()).also {
            it.width = width
        }
    }
}
