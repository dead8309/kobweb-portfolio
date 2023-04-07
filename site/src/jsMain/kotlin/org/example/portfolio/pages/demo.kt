package org.example.portfolio.pages

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.JustifyItems
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import org.example.portfolio.component.CircularProgressBar
import org.jetbrains.compose.web.css.*
import kotlin.time.Duration.Companion.milliseconds

@Page
@Composable
fun Demo() {
    SimpleGrid(
        numColumns = numColumns(3, lg = 4),
        modifier = Modifier
            .fillMaxSize()
            .alignItems(AlignItems.Center)
            .justifyItems(JustifyItems.Center)
            .backgroundColor(Color.black)
    ) {
        CircularProgressBar()
        CircularProgressBar(start = 15)
        CircularProgressBar(stop = 80)
        CircularProgressBar(delay = 20.milliseconds)
        CircularProgressBar(
            start = 1,
            stop = 75,
            delay = 100.milliseconds
        )
        // wont work
        CircularProgressBar(start = 100)
    }
}

