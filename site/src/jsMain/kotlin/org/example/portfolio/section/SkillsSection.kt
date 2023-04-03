package org.example.portfolio.section

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import org.example.portfolio.component.SkillsCard
import org.example.portfolio.utils.Assets
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun SkillSection() {
    Box(
        Modifier
            .id("skills")
            .fillMaxWidth()
            .padding(0.px, 0.px, 50.px, 0.px)
            .position(Position.Relative)
    ) {
        SkillsCard(
            modifier = Modifier.backgroundColor(Color("#151515"))
                .borderRadius(64.px)
                .textAlign(TextAlign.Center)
                .align(Alignment.TopCenter)
                .padding(20.px)
                .margin(top = (-60).px)
                .width(90.percent)
                .zIndex(1),
        )
        Image(
            src = Assets.ColorSharp,
            modifier = Modifier.top(28.percent)
                .position(Position.Absolute)
                .bottom(0.px)
                .width(40.percent)
        )
    }
}
