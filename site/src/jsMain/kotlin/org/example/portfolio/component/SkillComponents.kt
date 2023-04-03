package org.example.portfolio.component

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.ScrollBehavior
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.*
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import org.example.portfolio.*
import org.example.portfolio.Constants.skills
import org.example.portfolio.utils.atBreakpointMd
import org.example.portfolio.utils.atBreakpointSM
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.H4
import org.jetbrains.compose.web.dom.P

@Composable
fun SkillsCard(modifier: Modifier) {
    Box(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            H2(
                attrs = Modifier.fillMaxWidth()
                    .fontSize(45.px)
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
            SkillsContainer(
                modifier = Modifier
                    .fillMaxWidth()
                    .maxWidth(
                        690.px atBreakpointMd (330.px atBreakpointSM 175.px)
                    )
                    .overflowX(Overflow.Scroll)
                    .scrollBehavior(ScrollBehavior.Smooth)
            ) {
                skills.forEach {
                    SkillItem(it)
                }
            }
        }
    }
}

@Composable
private fun SkillsContainer(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    Row(modifier = modifier) {
        content()
    }
}


@Composable
private fun SkillItem(
    skill: Skill
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            src = skill.imageSrc,
            desc = skill.title,
            modifier = Modifier
                .width(150.px)
                .margin(
                    10.px
                )
                .objectFit(ObjectFit.Cover),
        )
        H4 {
            SpanText(skill.title)
        }
    }
}
