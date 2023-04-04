package org.example.portfolio.section

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaBars
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UndecoratedLinkVariant
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.example.portfolio.component.NavLink
import org.example.portfolio.styles.NavBarButtonStyle
import org.example.portfolio.styles.NavBarLinkStyle
import org.example.portfolio.styles.NavBarStyle
import org.example.portfolio.utils.Assets
import org.jetbrains.compose.web.css.*

@Composable
fun NavBar() {
    val breakpoint by rememberBreakpoint()
    Box(
        modifier = NavBarStyle.toModifier()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                src = Assets.Logo, modifier = Modifier.width(9.percent)
            )

            if (breakpoint >= Breakpoint.MD) {
                NavLinks(Modifier.fillMaxWidth())
            } else {
                NavHamBurgerMenu()
            }
        }
    }
}

@Composable
fun NavLinks(modifier: Modifier) {
    Row(
        modifier = modifier, verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End
    ) {
        NavLink("#home", "Home")
        NavLink("#skills", "Skills")
        NavLink("#projects", "Projects")
        NavLink("#contact","Contact Us")
        Button(onClick = {
            console.log("Protocol Let's Connect initiated📶")
        }, NavBarButtonStyle.toModifier()) {
            SpanText("Let's Connect", Modifier.zIndex(1))
        }
    }
}

// Nav Button
@Composable
fun NavHamBurgerMenu() {
    var isMenuShown by remember { mutableStateOf(false) }
    Column {
        Button(
            onClick = { isMenuShown = !isMenuShown },
            modifier = Modifier
                .padding(2.px)
                .margin(2.px)
                .backgroundColor(Color("#121212"))
                .color(Color.white)
                .styleModifier {
                    property("-webkit-tap-highlight-color",Color.transparent)
                },
        ) {
            FaBars(size = IconSize.XL)
        }

        if (isMenuShown) {
            DropDownMenu(Modifier
                .position(Position.Absolute)
                .right(0.75.cssRem)
                .onClick { isMenuShown = false }
                .top(55.px)
                .width(50.percent)
                .backgroundColor(Color.black)
                .borderRadius(10.px)
                .overflow(Overflow.Hidden)
                .padding(10.px)
            )
        }
    }
}

@Composable
private fun DropDownMenu(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val commonMod = Modifier.fillMaxWidth().textAlign(TextAlign.Center)
        Link(
            path = "#home",
            text = "Home",
            modifier = NavBarLinkStyle.toModifier().then(commonMod),
            variant = UndecoratedLinkVariant,
        )
        Link(
            path = "#skills",
            text = "Skills",
            modifier = NavBarLinkStyle.toModifier().then(commonMod),
            variant = UndecoratedLinkVariant
        )
        Link(
            path = "#projects",
            text = "Projects",
            modifier = NavBarLinkStyle.toModifier().then(commonMod).fillMaxWidth(),
            variant = UndecoratedLinkVariant
        )
        Link(
            path = "#contact",
            text = "Contact Us",
            modifier = NavBarLinkStyle.toModifier().then(commonMod).fillMaxWidth(),
            variant = UndecoratedLinkVariant
        )
    }
}