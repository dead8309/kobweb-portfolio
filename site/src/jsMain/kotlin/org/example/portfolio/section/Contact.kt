package org.example.portfolio.section

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.columnGap
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import org.example.portfolio.Assets
import org.example.portfolio.styles.ContactStyle
import org.example.portfolio.styles.formStyle
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.*

@Composable
fun Contact() {
    Box(
        ContactStyle.toModifier(),
        contentAlignment = Alignment.Center
    ) {
        Row {
            Image(Assets.ContactImg)
            Column {
                H2 {
                    Text("Get In Touch")
                }
                Form(attrs = formStyle.toModifier().toAttrs()) {
                    SimpleGrid(
                        numColumns(1, lg = 2),
                        Modifier.columnGap(8.px)
                    ) {
                        Input(InputType.Text) {
                            placeholder("First Name")
                        }
                        Input(InputType.Text) {
                            placeholder("Last Name")
                        }
                        Input(InputType.Email) {
                            placeholder("Email")
                        }
                        Input(InputType.Tel) {
                            placeholder("Phone No.")
                        }
                    }
                    Column(Modifier.fillMaxWidth()) {
                        TextArea {
                            placeholder("Message")
                        }
                        Button {
                            SpanText("Send")
                        }
                    }
                }
            }
        }
    }
}
