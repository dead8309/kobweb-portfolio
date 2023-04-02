package org.example.portfolio.styles

import com.varabyte.kobweb.compose.css.CSSBackground
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import org.jetbrains.compose.web.css.*


val ContactStyle by ComponentStyle {
    base {
        Modifier
            .fillMaxSize()
            .backgroundImage(
                linearGradient(90.21.deg) {
                    add(Color("#AA367C"), (-5.91).percent)
                    add(Color("#4A2FBD"), 111.58.percent)
                }
            )
            .padding(60.px, 0.px, 200.px, 0.px)
    }
    cssRule("> img") {
        Modifier.width(92.percent)
    }
    cssRule("> h2"){
        Modifier.fontSize(45.px)
            .fontWeight(700)
            .margin(bottom = 30.px)
    }
}

val commonFormInputFormTextAreaModifier = Modifier.fillMaxWidth()
    .background(CSSBackground(color = rgba(255,255,255,0.1)))
    .border(1.px, LineStyle.Solid, rgba(255, 255, 255, 0.5))
    .borderRadius(20.px)
    .color(Color("fff"))
    .margin(0.px,0.px,8.px,0.px)
    .padding(18.px,26.px)
    .fontWeight(500)
    .fontSize(18.px)
    .letterSpacing(0.8.px)
    .transition(CSSTransition("ease-in-out",0.3.s))

val formStyle by ComponentStyle {
    /* base {
         commonFormInputFormTextAreaModifier
     }*/
    cssRule(" input"){
        commonFormInputFormTextAreaModifier
    }
    cssRule(" textarea"){
        commonFormInputFormTextAreaModifier
    }
    cssRule(" input:focus"){
        Modifier.backgroundColor(Color.white)
            .color(Color("#121212"))
    }
    cssRule(" textarea:focus"){
        Modifier.backgroundColor(Color.white)
            .color(Color("#121212"))
    }
    cssRule(" input::placeholder"){
        Modifier.fontSize(16.px)
            .fontWeight(400)
            .color(Color("#fff"))
    }
    cssRule(" textarea::placeholder"){
        Modifier.fontSize(16.px)
            .fontWeight(400)
            .color(Color("#fff"))
    }
    cssRule(" input:focus::placeholder"){
        Modifier.color(Color("#121212"))
            .opacity(0.8)
    }
    cssRule(" textarea:focus::placeholder"){
        Modifier.color(Color("#121212"))
            .opacity(0.8)
    }
    cssRule(" button"){
        Modifier.fontWeight(700)
            .color(Color.black)
            . backgroundColor(Color("#fff"))
            .padding(14.px,48.px)
            .fontSize(18.px)
            .margin(top = 25.px)
            .borderRadius(0.px)
            .position(Position.Relative)
            .transition(CSSTransition("ease-in-out",0.3.s))
    }
    cssRule(" button span"){
        Modifier.zIndex(1)
            .position(Position.Relative)
    }
    cssRule(" button:hover"){
        Modifier.color(Color("#fff"))
    }
    cssRule(" button::before"){
        Modifier.content("")
            .backgroundColor(Color("#121212"))
            .width(0.px)
            .fillMaxHeight()
            . position (Position.Absolute)
            .top(0.px)
            .left(0.px)
            .zIndex(0)
            .transition(CSSTransition("ease-in-out",0.3.s))
    }
    cssRule(" button:hover::before"){
        Modifier.fillMaxWidth()
    }
}