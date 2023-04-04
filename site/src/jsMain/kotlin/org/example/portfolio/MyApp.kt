package org.example.portfolio

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.core.App
import com.varabyte.kobweb.silk.SilkApp
import com.varabyte.kobweb.silk.components.layout.Surface
import com.varabyte.kobweb.silk.components.style.common.SmoothColorStyle
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import org.jetbrains.compose.web.css.vh

@InitSilk
fun updateTheme(ctx: InitSilkContext) {
    ctx.stylesheet.registerStyle("@font-face") {
        base {
            Modifier
                .fontFamily("Centra")
                .fontWeight(700)
                .styleModifier {
                    property("src", "url(font/CentraNo2-Bold.ttf)")
                }
        }
    }
    ctx.stylesheet.registerStyle("@font-face") {
        base {
            Modifier
                .fontFamily("Centra")
                .fontWeight(500)
                .styleModifier {
                    property("src", "url(font/CentraNo2-Medium.ttf)")
                }
        }
    }
    ctx.stylesheet.registerStyle("@font-face") {
        base {
            Modifier
                .fontFamily("Centra")
                .fontWeight(400)
                .styleModifier {
                    property("src", "url(font/CentraNo2-Book.ttf)")
                }
        }
    }
}

@App
@Composable
fun MyApp(content: @Composable () -> Unit) {
    SilkApp {
        Surface(SmoothColorStyle.toModifier().minHeight(100.vh)) {
            content()
        }
    }
}
