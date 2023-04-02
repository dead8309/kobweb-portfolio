package org.example.portfolio.component

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UndecoratedLinkVariant
import com.varabyte.kobweb.silk.components.style.toModifier
import org.example.portfolio.styles.NavBarLinkStyle

@Composable
fun NavLink(
    path: String,
    text: String,
    modifier: Modifier = Modifier
) {
    Link(path, text, NavBarLinkStyle.toModifier().then(modifier), UndecoratedLinkVariant)
}
