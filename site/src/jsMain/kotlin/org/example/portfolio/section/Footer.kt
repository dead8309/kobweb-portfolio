package org.example.portfolio.section

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.css.BackgroundPosition
import com.varabyte.kobweb.compose.css.BackgroundRepeat
import com.varabyte.kobweb.compose.css.BackgroundSize
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.css.functions.url
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.*
import com.varabyte.kobweb.silk.components.text.SpanText
import org.example.portfolio.component.NavLink
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun FooterSection(){
    Box(footer.toModifier().fillMaxSize(),
        Alignment.Center
    ) {
        Column {
           NewsLetterBox()
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween){
                Img("/assets/logo.svg")
                P {
                    NavLink("https://github.com/varabyte/kobweb", "Made with Kobweb♥️")
                }
            }
        }
    }
}

@Composable
fun NewsLetterBox() {
    Column(newsLetterBox.toModifier()) {
        Row(Modifier.columnGap(30.px)) {
            Column {
                H3 {
                    Column {
                        SpanText("Subscribe to our Newsletter")
                        SpanText("& Never miss latest updates")
                    }
                }
            }
            Column {
                Form {
                    Row(
                        newEmailBox.toModifier(),
                        verticalAlignment = Alignment.CenterVertically) {
                        Input(InputType.Email){
                            placeholder("Email Address")
                        }
                        Button{
                            Text("Submit")
                        }
                    }
                }
            }
        }
    }
}

val footer by ComponentStyle {
    base {
        Modifier.padding(0.px,0.px,50.px,0.px)
            .backgroundImage(url("/assets/footer-bg.png"))
            . backgroundPosition(BackgroundPosition.Center)
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
            .background("linear-gradient(90.21deg, #AA367C -5.91%, #4A2FBD 111.58%)")
            .padding(20.px,65.px)
            .color(Color.white)
            .fontWeight(500)
            .letterSpacing(0.5.px)
            .borderRadius(18.px)
            .zIndex(3)
    }
}