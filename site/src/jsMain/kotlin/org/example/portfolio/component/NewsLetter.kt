package org.example.portfolio.component

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.columnGap
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import org.example.portfolio.styles.newEmailBox
import org.example.portfolio.styles.newsLetterBox
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.*


@Composable
fun NewsLetterBox() {
    Column(newsLetterBox.toModifier()) {
        Row(Modifier.columnGap(30.px)) {
            Column {
                H3 {
                    Column {
                        SpanText("Subscribe to our Newsletter")
                        SpanText("& Never miss latest updates")
                    }
                }
            }
            Column {
                Form {
                    Row(
                        newEmailBox.toModifier(),
                        verticalAlignment = Alignment.CenterVertically) {
                        Input(InputType.Email){
                            placeholder("Email Address")
                        }
                        Button{
                            Text("Submit")
                        }
                    }
                }
            }
        }
    }
}