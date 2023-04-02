package org.example.portfolio.component

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import org.example.portfolio.Project
import org.example.portfolio.styles.projectCardImgBox
import org.example.portfolio.styles.projectCardTextOverlay
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H4
import org.jetbrains.compose.web.dom.Text


@Composable
fun ProjectCard(project: Project) {
    Box(
        projectCardImgBox.toModifier().margin(8.px),
        contentAlignment = Alignment.Center
    ) {
        Image(project.imageUrl, project.description)
        Column(
            projectCardTextOverlay.toModifier(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            H4 { Text(project.title) }
            SpanText(project.description)
        }
    }
}
