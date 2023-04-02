package org.example.portfolio.section

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.before
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import org.example.portfolio.Constants
import org.example.portfolio.Project
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.H4
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

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
            SimpleGrid(numColumns(1, md = 2, sm = 2, lg = 3)){
                Constants.projects.forEach {
                    ProjectCard(it)
                }
            }
        }
    }
}

@Composable
fun ProjectCard(project: Project) {
    Box(
        projectCardImgBox.toModifier().margin(8.px),
        contentAlignment = Alignment.Center
    ) {
        Image(project.imageUrl, project.description)
        Column(
            projectCardTextOverlay.toModifier(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            H4 { Text(project.title) }
            SpanText(project.description)
        }
    }
}

val P by ComponentStyle {
    base {
        Modifier.color(Color("#B8B8B8"))
            .fontSize(18.px)
            .letterSpacing(0.8.px)
            .lineHeight(1.5.em)
            .margin(14.px, 30.px)
            .textAlign(TextAlign.Center)
            .width(56.percent)
    }
}

val projectCardImgBox by ComponentStyle {
    base {
        Modifier.position(Position.Relative)
            .borderRadius(30.px)
            .overflow(Overflow.Hidden)
            .margin(bottom = 24.px)
    }
    before {
        Modifier.content("")
            .backgroundImage(
                linearGradient(90.21.deg){
                    add(Color("#AA367C"),-(5.91).percent)
                    add(Color("#4A2FBD"), 111.58.percent)
            })
            .opacity(0.85)
            .position(Position.Absolute)
            .fillMaxWidth()
            .height(0.px)
            .transition(CSSTransition("ease-in-out", 0.4.s))
    }
    cssRule(":hover::before") {
        Modifier.fillMaxHeight()
    }
    cssRule(":hover .project-card-text-overlay") {
        Modifier.top(50.percent)
            .opacity(1)
    }
}

val projectCardTextOverlay by ComponentStyle {
    base {
        Modifier
            .position(Position.Absolute)
            .textAlign(TextAlign.Center)
            .top(65.percent)
            .left(50.percent)
            .translate((-50).percent, (-50).percent)
            .transition(CSSTransition("ease-in-out", 0.5.s))
            .opacity(0)
            .fillMaxWidth()
    }
    cssRule("> h4") {
        Modifier.fontSize(30.px)
            .fontWeight(700)
            .letterSpacing(0.8.px)
            .lineHeight(1.1.em)
    }
    cssRule("> span") {
        Modifier.fontStyle(FontStyle.Italic)
            .fontWeight(400)
            .fontSize(15.px)
            .letterSpacing(0.8.px)
    }
}