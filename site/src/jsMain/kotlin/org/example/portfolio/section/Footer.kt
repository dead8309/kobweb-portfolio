package org.example.portfolio.section

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.silk.components.style.toModifier
import org.example.portfolio.Assets
import org.example.portfolio.component.NavLink
import org.example.portfolio.component.NewsLetterBox
import org.example.portfolio.styles.footer
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.P

@Composable
fun FooterSection() {
    Box(
        footer.toModifier().fillMaxSize(),
        Alignment.Center
    ) {
        Column {
            NewsLetterBox()
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Img(Assets.Logo)
                P {
                    NavLink("https://github.com/varabyte/kobweb", "Made with Kobweb♥️")
                }
            }
        }
    }
}