package org.example.portfolio.section

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UndecoratedLinkVariant
import com.varabyte.kobweb.silk.components.style.toModifier
import org.example.portfolio.component.NewsLetterBox
import org.example.portfolio.styles.FooterStyle
import org.example.portfolio.styles.NavBarLinkStyle
import org.example.portfolio.utils.Assets
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun FooterSection() {
    Column(
        modifier = FooterStyle.toModifier(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        NewsLetterBox()
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Img(Assets.Logo)
            P {
                Text("Made with ")
                Link(
                    path = "https://github.com/varabyte/kobweb",
                    text = "Kobweb♥️",
                    modifier = NavBarLinkStyle.toModifier(),
                    variant = UndecoratedLinkVariant,
                )
            }
        }
    }
}