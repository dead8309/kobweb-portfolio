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
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import org.example.portfolio.Constants
import org.example.portfolio.component.rememberAnimatedText
import org.example.portfolio.styles.*
import org.example.portfolio.utils.Assets
import org.example.portfolio.utils.atBreakpointMd
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.P

@Composable
fun Banner() {
    val animatedText = rememberAnimatedText(
        toRotate = listOf("Web Developer", "Web Designer", "UI/UX Designer","Android Developer"),
        period = 2000
    )
    SimpleGrid(
        numColumns(base = 1, md = 2),
        modifier = bannerStyle.toModifier().id("home")
    ) {
        BannerText(animatedText.value)
        Image(
            src = Assets.HeaderImg,
            modifier = Modifier
                .width(100.percent)
                .padding(0.px atBreakpointMd 50.px)
                .height(auto)
                .animation(
                    zoomIn.toAnimation(
                        duration = 1.s,
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
fun BannerText(text: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.px, 50.px)
    ) {
        SpanText(
            text = "Welcome to my Portfolio",
            modifier = GradientTagLineStyle.toModifier()
        )
        H1(
            attrs = Modifier.fontSize(65.px atBreakpointMd 45.px)
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
                .width(100.percent)
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
