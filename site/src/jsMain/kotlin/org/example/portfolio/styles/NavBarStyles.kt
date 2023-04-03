package org.example.portfolio.styles

import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.*
import org.jetbrains.compose.web.css.*


val NavBarStyle by ComponentStyle {
    base {
        Modifier
            .fillMaxWidth()
            .padding(18.px)
            .position(Position.Fixed)
            .top(0.percent)
            .transition(CSSTransition("ease-in-out", 0.32.s))
    }
}

val NavBarButtonStyle by ComponentStyle {
    base {
        Modifier
            .fontWeight(700)
            .color(Color.white)
            .border(1.px, LineStyle.Solid, Color.white)
            .padding(18.px, 34.px)
            .fontSize(18.px)
            .margin(left = 18.px)
            .position(Position.Relative)
            .backgroundColor(Color.transparent)
            .transition(CSSTransition("ease-in-out", 0.3.s))
    }
    before {
        Modifier.content("")
            .width(0.percent)
            .height(100.percent)
            .position(Position.Absolute)
            .backgroundColor(Color.white)
            .top(0.percent)
            .left(0.percent)
            .transition(CSSTransition("ease-in-out",0.3.s))
    }
    hover {
        Modifier.color(Color("#121212"))
    }
}

val NavBarLinkStyle by ComponentStyle {
    base {
        Modifier.fontWeight(400)
            .letterSpacing(0.8.px)
            .fontSize(18.px)
            .opacity(0.75)
    }
    link { Modifier.color(Color.white) }
    visited { Modifier.color(Color.white) }
    hover { Modifier.opacity(1) }
    active { Modifier.opacity(1) }
}
