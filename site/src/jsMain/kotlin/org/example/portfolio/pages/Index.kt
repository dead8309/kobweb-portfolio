package org.example.portfolio.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import org.example.portfolio.section.*
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.Position

@Page
@Composable
fun HomePage() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fontWeight(400)
                .overflowX(Overflow.Hidden)
                .position(Position.Relative)
                .backgroundColor(Color("#121212"))
                .color(Color("#fff"))
                .fontFamily(
                    "Centra" ,"sans-serif"
                ),
            verticalArrangement = Arrangement.Top
        ) {
            NavBar()
            Banner()
            SkillSection()
            Projects()
            Contact()
            FooterSection()
        }
    }
}