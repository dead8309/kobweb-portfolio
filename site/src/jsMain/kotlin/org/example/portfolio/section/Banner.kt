package org.example.portfolio.section

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.foundation.layout.Box
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
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.CSSAutoKeyword
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.P

@Composable
fun Banner() {
    val animatedText = rememberAnimatedText(
        toRotate = listOf("Web Developer", "Web Designer", "UI/UX Designer"),
        period = 2000
    )
    Box(bannerStyle.toModifier().fillMaxSize()) {
        SimpleGrid(numColumns(1, md = 2)) {
            BannerText(animatedText.value)
            Image(
                src = "assets/header-img.svg",
                modifier = Modifier
                    .width(100.percent)
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
}

@Composable
fun BannerText(text: String) {
    Column(Modifier.padding(0.px, 50.px)) {
        SpanText("Welcome to my Portfolio", tagLine.toModifier())
        H1(
            attrs = Modifier.fontSize(65.px)
                .fontWeight(700)
                .letterSpacing(0.80.px)
                .lineHeight(1)
                .margin(bottom = 20.px)
                .display(DisplayStyle.Block)
                .toAttrs()
        ) {
            SpanText(
                "Hi! I'm yzziK $text",
                Modifier.borderRight(0.08.em, LineStyle.Solid, Color("#666"))
            )
        }
        P(
            attrs = Modifier.color(Color.white)
                .fontSize(18.px)
                .letterSpacing(0.8.px)
                .lineHeight(1.5.em)
                .width(96.percent)
                .toAttrs()
        ) {
            SpanText(Constants.LOREM)
        }
        Row( modifier = buttonStyle.toModifier()) {
            SpanText("Let's Connect")
            FaCircleArrowRight()
        }
    }
}
