package org.example.portfolio.section

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.example.portfolio.Assets
import org.example.portfolio.component.NavLink
import org.example.portfolio.styles.NavBarButtonStyle
import org.example.portfolio.styles.NavBarStyle
import org.jetbrains.compose.web.css.percent

@Composable
fun NavBar() {
    val breakpoint by rememberBreakpoint()
    Box(
        modifier = NavBarStyle
            .toModifier()
            .id("home")
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                src = Assets.Logo,
                modifier = Modifier.width(9.percent)
            )
            if (breakpoint > Breakpoint.MD) {
                NavLinks(Modifier.fillMaxWidth())
            } else {
                // figure out hamburger menu
            }
        }
    }
}

@Composable
fun NavLinks(modifier: Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        NavLink("#", "Home")
        NavLink("#skills", "Skills")
        NavLink("#projects", "Projects")
        Button(onClick = {}, NavBarButtonStyle.toModifier()) {
            SpanText("Let's Connect", Modifier.zIndex(1))
        }
    }
}