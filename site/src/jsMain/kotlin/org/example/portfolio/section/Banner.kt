package org.example.portfolio.section

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.AnimationIterationCount
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.animation.toAnimation
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaCircleArrowRight
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.example.portfolio.Assets
import org.example.portfolio.Constants
import org.example.portfolio.component.rememberAnimatedText
import org.example.portfolio.styles.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.P

@Composable
fun Banner() {
    val breakpoint = rememberBreakpoint()
    val animatedText = rememberAnimatedText(
        toRotate = listOf("Web Developer", "Web Designer", "UI/UX Designer"),
        period = 2000
    )
    SimpleGrid(
        numColumns(base = 1, md = 2),
        modifier = bannerStyle.toModifier()
    ) {
        BannerText(animatedText.value, breakpoint.value)
        Image(
            src = Assets.HeaderImg,
            modifier = Modifier
                .width(
                    if (breakpoint.value >= Breakpoint.MD) 100.percent
                    else 75.percent
                )
                .height(auto)
                .animation(
                    zoomIn.toAnimation(
                        duration = 3.s,
                        timingFunction = AnimationTimingFunction.Ease,
                        iterationCount = AnimationIterationCount.of(1)
                    ),
                    upDownAnim.toAnimation(
                        duration = 3.s,
                        direction = AnimationDirection.Alternate,
                        iterationCount = AnimationIterationCount.Infinite
                    )
                )
        )
    }
}

@Composable
fun BannerText(text: String, breakpoint: Breakpoint) {
    Column(modifier = Modifier
        .fillMaxWidth(90.percent)
        .padding(0.px, 50.px, 0.px, 50.px)
    ) {
        SpanText(
            text = "Welcome to my Portfolio",
            modifier = GradientTagLineStyle.toModifier()
        )
        H1(
            attrs = Modifier.fontSize(
                if (breakpoint > Breakpoint.MD) 65.px
                else 35.px
            )
                .fontWeight(700)
                .letterSpacing(0.80.px)
                .lineHeight(1)
                .margin(bottom = 20.px)
                .display(DisplayStyle.Block)
                .toAttrs()
        ) {
            SpanText(
                text = "Hi! I'm yzziK $text",
                modifier = Modifier.borderRight(
                    width = 0.08.em,
                    style = LineStyle.Solid,
                    color = Color("#666")
                )
            )
        }
        P(
            attrs = Modifier.color(Color.white)
                .fontSize(18.px)
                .letterSpacing(0.8.px)
                .lineHeight(1.5.em)
                .width(
                    if (breakpoint > Breakpoint.MD)
                        96.percent
                    else 80.percent
                )
                .toAttrs()
        ) {
            SpanText(Constants.LOREM)
        }
        Row(modifier = buttonStyle.toModifier()) {
            SpanText("Let's Connect")
            FaCircleArrowRight()
        }
    }
}
