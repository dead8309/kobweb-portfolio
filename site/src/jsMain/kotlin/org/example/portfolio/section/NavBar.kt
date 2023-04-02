package org.example.portfolio.section

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.CSSFloat
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.UserSelect
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaBars
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UncoloredLinkVariant
import com.varabyte.kobweb.silk.components.navigation.UndecoratedLinkVariant
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.base
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.hover
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.example.portfolio.Assets
import org.example.portfolio.component.NavLink
import org.example.portfolio.styles.NavBarButtonStyle
import org.example.portfolio.styles.NavBarStyle
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.FlexDirection.Companion.Column
import org.jetbrains.compose.web.dom.Div

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
            if (breakpoint > Breakpoint.SM) {
                NavLinks(Modifier.fillMaxWidth())
            } else {
                NavMenuButton()
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
@Composable
fun NavMenuButton() {
    var isMenuShown by remember { mutableStateOf(false) }
    Column {
        Button(onClick = { isMenuShown = true }, NavMenuButtonStyle.toModifier()) {
            FaBars()
        }

        if (isMenuShown) {
            Div(Modifier
                .position(Position.Absolute)
                .fillMaxSize()
                .onClick { isMenuShown = false }
                .toAttrs()
            ) {
                NavMenuItems(Modifier.fillMaxWidth().position(Position.Relative).top(35.px).left(10.px))
            }
        }
    }
}

val NavMenuButtonStyle by ComponentStyle.base {
    Modifier
        .margin(5.px)
        .padding(5.px)
}
val NavMenuStyle by ComponentStyle {
    base {
        Modifier
            .userSelect(UserSelect.None)
            .backgroundColor(Color.transparent)
    }
}
@Composable
private fun NavMenuItems(modifier: Modifier = Modifier) {
    Column(NavMenuStyle.toModifier().then(modifier)) {
        NavLink("#home", "Home")
        NavLink("#skills", "Skills",)
        NavLink("#projects", "Projects")
    }
}