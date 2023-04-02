package org.example.portfolio.section

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import org.example.portfolio.Constants
import org.example.portfolio.component.ProjectCard
import org.example.portfolio.styles.P
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P

@Composable
fun Projects() {
    Box(
        Modifier.id("projects")
            .fillMaxSize()
            .padding(80.px, 0.px)
            .backgroundColor(Color.black)
            .zIndex(1),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SpanText(
                "Projects", Modifier.fontSize(42.px)
                    .fontWeight(700)
                    .textAlign(TextAlign.Center)
            )
            P(P.toModifier().toAttrs()) {
                SpanText(Constants.LOREM)
            }
            SimpleGrid(numColumns(1, sm = 2, lg = 3)) {
                Constants.projects.forEach {
                    ProjectCard(it)
                }
            }
        }
    }
}