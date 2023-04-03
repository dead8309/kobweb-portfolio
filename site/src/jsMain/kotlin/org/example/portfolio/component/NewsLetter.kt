package org.example.portfolio.component

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.toAttrs
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import org.example.portfolio.styles.NewEmailBoxStyle
import org.example.portfolio.styles.NewsLetterBoxStyle
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.dom.*


@Composable
fun NewsLetterBox() {
    Column(NewsLetterBoxStyle.toModifier()) {
        SimpleGrid(
            modifier = Modifier
                .fillMaxWidth(),
            numColumns = numColumns(1, md = 2)
        ) {
            H3 {
                SpanText("Subscribe to our Newsletter & Never miss latest updates")
            }
            Form(
                attrs = NewEmailBoxStyle.toAttrs()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Input(InputType.Email) {
                        placeholder("Email Address")
                    }
                    Button {
                        Text("Submit")
                    }
                }
            }
        }
    }
}