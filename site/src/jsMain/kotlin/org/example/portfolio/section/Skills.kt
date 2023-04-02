package org.example.portfolio.section

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.*
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.H4
import org.jetbrains.compose.web.dom.P

@Composable
fun Skills() {
    Box(
        Modifier
            .id("skills")
            .fillMaxWidth()
            .padding(0.px, 0.px, 50.px,0.px)
            .position(Position.Relative)
    ) {
        SkillsCard()
        Image("/assets/color-sharp.png","",
            Modifier.top(28.percent)
            .position(Position.Absolute)
            .bottom(0.px)
            .width(40.percent)
        )
    }
}

@Composable
fun BoxScope.SkillsCard(){
    Box(Modifier.background("#151515")
        .borderRadius(64.px)
        .textAlign(TextAlign.Center)
        .align(Alignment.TopCenter)
        .padding(60.px,50.px)
        .margin(top = (-60).px)
        .zIndex(1)) {
        Column(Modifier.fillMaxWidth()) {
            H2(
                Modifier.fillMaxWidth().fontSize(45.px)
                    .fontWeight(700)
                    .toAttrs()
            ) {
                SpanText("Skills",Modifier.textAlign(TextAlign.Center))
            }
            P(
                Modifier.color(Color("#B8B8B8"))
                    .fontSize(18.px)
                    .letterSpacing(0.8.px)
                    .lineHeight(1.5.em)
                    .margin(14.px, 0.px, 75.px, 0.px)
                    .toAttrs()
            ) {
                Column{
                    SpanText("Lorem Ipsum is simply dummy text of the printing and typesetting industry.")
                    SpanText("Lorem Ipsum has been the industry's standard dummy text.")
                }
            }
            SkillSlider()
        }
    }
}

@Composable
fun SkillSlider(){
    Row(Modifier.fillMaxWidth()){
        Skill("Web Development","/assets/meter1.svg")
        Skill("Brand Identity","/assets/meter2.svg")
        Skill("Logo Design","/assets/meter3.svg")
        Skill("Web Development","/assets/meter1.svg")
    }
}

@Composable
fun Skill(
    text: String,
    image: String){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ){
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
