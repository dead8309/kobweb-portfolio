package org.example.portfolio.component

import androidx.compose.runtime.*
import kotlinx.coroutines.delay

@Composable
fun rememberAnimatedText(toRotate: List<String>, period: Int): MutableState<String> {
    val textState = remember { mutableStateOf("") }
    LaunchedEffect(Unit) {
        var loopNum = 0
        var isDeleting = false
        var delta = 300 - (1..100).random()
        var index = 1

        while (true) {
            val i = loopNum % toRotate.size
            val fullText = toRotate[i]
            val updatedText = if (isDeleting) {
                fullText.substring(0, textState.value.length - 1)
            } else {
                fullText.substring(0, minOf(index, fullText.length))
            }

            textState.value = updatedText

            if (isDeleting) {
                delta /= 2
            }

            if (!isDeleting && updatedText == fullText) {
                isDeleting = true
                index -= 1
                delta = period
            } else if (isDeleting && updatedText.isEmpty()) {
                isDeleting = false
                loopNum += 1
                index = 1
                delta = 500
            } else {
                index += 1
            }

            delay(delta.toLong())
        }
    }

    return textState
}
