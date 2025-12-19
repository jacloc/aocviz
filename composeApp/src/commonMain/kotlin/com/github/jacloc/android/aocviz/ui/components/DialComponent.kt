package com.github.jacloc.android.aocviz.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

data class TickConfig(
    val tickCount: Int = 100,
    val tickLength: Float = 16f,
    val tickWidth: Float = 6f
)

@Composable
fun DialComponent(
    modifier: Modifier = Modifier,
    dialPosition: Int,
    dialColor: Color = MaterialTheme.colorScheme.surfaceContainer,
    tickColor: Color = MaterialTheme.colorScheme.secondary,
    tickConfig: TickConfig = TickConfig()
) {
    val textMeasurer = rememberTextMeasurer()
//    val rotation by animateFloatAsState(
//        targetValue = dialPosition.toFloat() * (360f / tickConfig.tickCount.toFloat())
//    )
    Canvas(modifier = modifier) {
        val radius = size.minDimension / 2.0f
        rotate(dialPosition.toFloat() * (360f / tickConfig.tickCount.toFloat())) {
            drawCircle(color = dialColor)
            drawTicks(
                textMeasurer = textMeasurer,
                tickColor = tickColor,
                radius = radius,
                tickConfig = tickConfig)
        }
    }
}

private fun DrawScope.drawTicks(
    textMeasurer: TextMeasurer,
    tickColor: Color,
    radius: Float,
    tickConfig: TickConfig = TickConfig()
) {


    repeat(tickConfig.tickCount) {
        val i = it * (PI / (tickConfig.tickCount / 2)).toFloat()


        val tickStart = Offset(center.x + cos(i) * radius, center.y + sin(i) * radius)
        val tickEnd = Offset(
            center.x + cos(i) * (radius - tickConfig.tickLength),
            center.y + sin(i) * (radius - tickConfig.tickLength)
        )

        if (i == (3 * PI.toFloat() / 2)) {
            drawText(
                textLayoutResult = textMeasurer.measure(
                    text = "0",
                    style = TextStyle(fontSize = 30.sp, color = Color.Black)
                ),
                topLeft = tickEnd - Offset(20f, 0f)
            )
        }

        drawLine(
            color = tickColor,
            start = tickStart,
            end = tickEnd,
            strokeWidth = tickConfig.tickWidth,
            cap = StrokeCap.Round
        )
    }
}

@Composable
@Preview
fun PreviewDialComponent() {
    MaterialTheme {
        Surface {
            DialComponent(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                dialPosition = 0
            )
        }
    }
}