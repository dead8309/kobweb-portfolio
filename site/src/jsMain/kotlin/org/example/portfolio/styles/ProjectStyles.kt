package org.example.portfolio.styles

import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.before
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.css.*


val ParagraphStyle by ComponentStyle {
    base {
        Modifier.color(Color("#B8B8B8"))
            .fontSize(18.px)
            .letterSpacing(0.8.px)
            .lineHeight(1.5.em)
            .margin(14.px)
            .textAlign(TextAlign.Center)
            .width(90.percent)
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
                }
            )
            .opacity(0.85)
            .position(Position.Absolute)
            .fillMaxWidth()
            .height(0.px)
            .transition(CSSTransition("ease-in-out", 0.4.s))
    }
    (hover + before){
        Modifier.fillMaxHeight()
    }
    cssRule(":hover .project-card-text-overlay") {
        Modifier.top(50.percent)
            .opacity(1)
    }
}

val ProjectCardTextOverlay by ComponentStyle {
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