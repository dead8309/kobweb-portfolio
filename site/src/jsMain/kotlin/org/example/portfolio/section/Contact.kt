package org.example.portfolio.section

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.AnimationIterationCount
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.animation
import com.varabyte.kobweb.compose.ui.modifiers.columnGap
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.animation.toAnimation
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import org.example.portfolio.styles.ContactStyle
import org.example.portfolio.styles.formStyle
import org.example.portfolio.styles.zoomIn
import org.example.portfolio.utils.Assets
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.s
import org.jetbrains.compose.web.dom.*

@Composable
fun Contact() {
    Box(
        ContactStyle.toModifier(),
        contentAlignment = Alignment.Center
    ) {
        SimpleGrid(numColumns(1, md = 2), Modifier.fillMaxSize()) {
            Image(
                src = Assets.ContactImg,
                modifier = Modifier
                    .animation(
                        zoomIn.toAnimation(
                            duration = 1.s, timingFunction = AnimationTimingFunction.Ease,
                            iterationCount = AnimationIterationCount.of(1)
                        )
                    )
            )
            Column(Modifier.fillMaxWidth()) {
                H2 {
                    Text("Get In Touch")
                }
                Form(attrs = formStyle.toModifier().toAttrs()) {
                    SimpleGrid(
                        numColumns(1, md = 2),
                        Modifier.fillMaxWidth().columnGap(8.px)
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
