package org.example.portfolio.component

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import kotlinx.coroutines.delay
import org.jetbrains.compose.web.css.*
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

@Composable
fun CircularProgressBar(
    modifier: Modifier = Modifier,
    start: Int = 0,
    stop: Int = 100,
    delay: Duration = 10.milliseconds,
    colors: DefaultCircularProgressBarColor = DefaultCircularProgressBarColor()
) {
    var current by remember { mutableStateOf(start) }
    LaunchedEffect(Unit) {
        while (current < stop) {
            current++
            delay(delay)
        }
    }
    Box(
        Modifier
            .display(DisplayStyle.Flex)
            .justifyContent(JustifyContent.Center)
            .alignItems(AlignItems.Center)
            .size(100.px)
            .borderRadius(50.percent)
            .styleModifier {
                property(
                    propertyName = "background",
                    value = "radial-gradient(closest-side, ${colors.innerCircle} 79%, transparent 80% 100%),conic-gradient(${colors.progressColor} $current%, ${colors.progressBackground} 0)"
                )
            }.then(modifier)
    ) {
        SpanText(
            text = "$current%",
            modifier = Modifier
                .fontSize(18.px)
                .fontWeight(600)
                .color(Color.white)
        )
    }
}

data class DefaultCircularProgressBarColor(
    val innerCircle: CSSColorValue = Color.black,
    val progressBackground: CSSColorValue = Color.lightblue,
    val progressColor: CSSColorValue = Color.blue
)