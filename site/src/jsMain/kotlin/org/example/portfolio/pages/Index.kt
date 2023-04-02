package org.example.portfolio.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import org.example.portfolio.section.*
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.Position

@Page
@Composable
fun HomePage() {
    Box(modifier = homeModifier) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {
            NavBar()
            Banner()
            Skills()
            Projects()
            Contact()
            FooterSection()
        }
    }
}

val homeModifier = Modifier.fillMaxSize()
    .backgroundColor(Color("#121212"))
    .fontWeight(400)
    .overflowX(Overflow.Hidden)
    .position(Position.Relative)
    .color(Color.white)
    .fontFamily("Centra", "sans-serif")