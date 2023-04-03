package org.example.portfolio.utils

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit

/**
 * Returns a [CSSSizeValue] with a value set to [first] when the current device's screen width satisfies the given
 * comparator, and set to [other] otherwise.
 *
 * @param first The size value to use when the current screen width satisfies the given comparator.
 * @param other The size value to use when the current screen width does not satisfy the given comparator.
 * @param comparator A function that takes a [Breakpoint] and returns a Boolean indicating whether the current screen
 * width satisfies the condition.
 * @return A [CSSSizeValue] representing the size value at the current breakpoint.
 */
@Composable
private fun breakpoint(
    first: CSSSizeValue<CSSUnit.px>,
    other: CSSSizeValue<CSSUnit.px>,
    comparator: (Breakpoint) -> Boolean
): CSSSizeValue<CSSUnit.px> {
    val breakpoint = rememberBreakpoint()
    return if (comparator(breakpoint.value)) first else other
}

/**
 * Returns a [CSSSizeValue] with a value set to [this] when the current device's screen width is greater than or
 * equal to [Breakpoint.MD], and set to [other] otherwise.
 *
 * @param other The size value to use when the current screen width is less than [Breakpoint.MD].
 * @return A [CSSSizeValue] representing the size value at the current breakpoint.
 */
@Composable
infix fun CSSSizeValue<CSSUnit.px>.atBreakpointMd(other: CSSSizeValue<CSSUnit.px>): CSSSizeValue<CSSUnit.px> =
    breakpoint(this, other) { breakpoint -> breakpoint >= Breakpoint.MD }

/**
 * Returns a [CSSSizeValue] with a value set to [this] when the current device's screen width is greater than or
 * equal to [Breakpoint.SM], and set to [other] otherwise.
 *
 * @param other The size value to use when the current screen width is less than [Breakpoint.SM].
 * @return A [CSSSizeValue] representing the size value at the current breakpoint.
 */
@Composable
infix fun CSSSizeValue<CSSUnit.px>.atBreakpointSM(other: CSSSizeValue<CSSUnit.px>): CSSSizeValue<CSSUnit.px> =
    breakpoint(this, other) { breakpoint -> breakpoint >= Breakpoint.SM }

/**
 * Returns a [CSSSizeValue] with a value set to [this] when the current device's screen width is greater than or
 * equal to [Breakpoint.XL], and set to [other] otherwise.
 *
 * @param other The size value to use when the current screen width is less than [Breakpoint.XL].
 * @return A [CSSSizeValue] representing the size value at the current breakpoint.
 */
@Composable
infix fun CSSSizeValue<CSSUnit.px>.atBreakpointXL(other: CSSSizeValue<CSSUnit.px>): CSSSizeValue<CSSUnit.px> =
    breakpoint(this, other) { breakpoint -> breakpoint >= Breakpoint.XL }

/**
 * Returns a [CSSSizeValue] with a value set to [this] when the current device's screen width is greater than or
 * equal to [Breakpoint.LG], and set to [other] otherwise.
 *
 * @param other The size value to use when the current screen width is less than [Breakpoint.LG].
 * @return A [CSSSizeValue] representing the size value at the current breakpoint.
 */
@Composable
infix fun CSSSizeValue<CSSUnit.px>.atBreakpointLG(other: CSSSizeValue<CSSUnit.px>): CSSSizeValue<CSSUnit.px> =
    breakpoint(this, other) { breakpoint -> breakpoint >= Breakpoint.LG }