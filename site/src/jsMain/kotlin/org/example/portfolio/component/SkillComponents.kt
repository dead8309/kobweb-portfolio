package org.example.portfolio.component

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import org.example.portfolio.Assets
import org.example.portfolio.Constants
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.H4
import org.jetbrains.compose.web.dom.P


@Composable
private fun SkillItem(
    text: String,
    image: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            src = image,
            desc = text,
            modifier = Modifier.width(50.percent).margin(0.px, 15.px),
        )
        H4 {
            SpanText(text)
        }
    }
}


@Composable
fun SkillsCard(modifier: Modifier) {
    Box(
        modifier = modifier
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            H2(
                attrs = Modifier.fillMaxWidth().fontSize(45.px)
                    .fontWeight(700)
                    .toAttrs()
            ) {
                SpanText(
                    text = "Skills",
                    modifier = Modifier.textAlign(TextAlign.Center)
                )
            }
            P(
                attrs = Modifier.color(Color("#B8B8B8"))
                    .fontSize(18.px)
                    .letterSpacing(0.8.px)
                    .lineHeight(1.5.em)
                    .margin(14.px, 0.px, 75.px, 0.px)
                    .toAttrs()
            ) {
                Column {
                    SpanText(Constants.LOREM)
                }
            }
            SkillSlider()
        }
    }
}

@Composable
private fun SkillSlider() {
    Row(Modifier.fillMaxWidth()) {
        SkillItem("Web Development", Assets.Meter1)
        SkillItem("Brand Identity",  Assets.Meter2)
        SkillItem("Logo Design",  Assets.Meter3)
        SkillItem("Web Development", Assets.Meter1)
    }
}