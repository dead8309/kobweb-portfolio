package org.example.portfolio.styles

import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.css.functions.url
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.after
import com.varabyte.kobweb.silk.components.style.before
import org.example.portfolio.Assets
import org.jetbrains.compose.web.css.*


val footer by ComponentStyle {
    base {
        Modifier.padding(0.px,0.px,50.px,0.px)
            .backgroundImage(url(Assets.FooterBg))
            .backgroundPosition(BackgroundPosition.of(CSSPosition.Center))
            .backgroundSize(BackgroundSize.Cover)
            .backgroundRepeat(BackgroundRepeat.NoRepeat)
    }
    cssRule(" img"){
        Modifier.width(26.percent)
    }
    cssRule(" p"){
        Modifier.fontWeight(400)
            .fontSize(14.px)
            .color(Color("#B8B8B8"))
            .letterSpacing(0.5.px)
            .margin(top = 20.px)
    }
}
val newsLetterBox by ComponentStyle {
    base {
        Modifier.backgroundColor(Color.white)
            .borderRadius(55.px)
            .color(Color("#121212"))
            .padding(85.px,125.px)
            .margin(bottom = 80.px, top = -(122).px)
    }
    cssRule(" h3"){
        Modifier.fontWeight(700)
            .letterSpacing(0.5.px)
            .lineHeight(1.2.cssRem)
    }
}

val newEmailBox by ComponentStyle {
    base {
        Modifier.backgroundColor(Color.white)
            .padding(5.px)
            .borderRadius(20.px)
            .position(Position.Relative)
            .zIndex(1)
            .display(DisplayStyle.Flex)
            .alignItems(AlignItems.Center)
    }
    before {
        Modifier.content("")
            .backgroundImage(
                linearGradient(90.21.deg){
                    add(Color("#AA367C"),-(5.91).percent)
                    add(Color("#4A2FBD"),111.58.percent)
                }
            )
            .borderRadius(20.px)
            .position(Position.Absolute)
            .zIndex(2)
            .top((-1).px)
            .left((-1).px)
            .bottom((-1).px)
            .right((-1).px)
    }
    after {
        Modifier.content("")
            .backgroundColor(Color.white)
            .borderRadius(20.px)
            .position(Position.Absolute)
            .zIndex(2)
            .top(0.px)
            .left(0.px)
            .bottom(0.px)
            .right(0.px)
    }
    cssRule(" input"){
        Modifier.fillMaxWidth()
            .color(Color("#121212"))
            .fontWeight(500)
            .backgroundColor(Color.transparent)
            .border(0.px)
            .padding(0.px,15.px)
            .zIndex(3)
    }
    cssRule(" button"){
        Modifier
            .styleModifier { background("linear-gradient(90.21deg, #AA367C -5.91%, #4A2FBD 111.58%)") }
            .padding(20.px,65.px)
            .color(Color.white)
            .fontWeight(500)
            .letterSpacing(0.5.px)
            .borderRadius(18.px)
            .zIndex(3)
    }
}