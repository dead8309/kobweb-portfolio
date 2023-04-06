package org.example.portfolio.utils

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint

/**
 * Private utility function to choose between [first] and [other] values based on the current screen [Breakpoint].
 * Both [first] and [other] must have the same type [T].
 *
 * @param first The value to be returned if the [comparator] returns true.
 * @param other The value to be returned if the [comparator] returns false.
 * @param comparator The comparison function to determine if [first] or [other] should be returned.
 * @throws IllegalArgumentException if [first] and [other] have different types.
 * @return The value of [first] if [comparator] returns true, otherwise the value of [other].
 */
@Composable
private inline fun <T> breakpoint(
    first: T,
    other: T,
    comparator: (Breakpoint) -> Boolean
): T {
    require(first!!::class == other!!::class) { "Arguments must have the same type." }
    val breakpoint = rememberBreakpoint()
    return if (comparator(breakpoint.value)) first else other
}


/**
 * Returns the value of [this] if the current screen width is at least [Breakpoint.MD], otherwise returns the value of [other].
 *
 * Both [first] and [other] must have the same type [T]
 *
 * @param other The value to be returned if the screen width is less than [Breakpoint.MD].
 * @return The value of [this] if the screen width is at least [Breakpoint.MD], otherwise the value of [other].
 */
@Composable
infix fun <T> T.atBreakpointMd(other: T) =
    breakpoint(this, other) { breakpoint -> breakpoint >= Breakpoint.MD }

/**
 * Returns the value of [this] if the current screen width is at least [Breakpoint.SM], otherwise returns the value of [other].
 *
 * Both [first] and [other] must have the same type [T]
 *
 * @param other The value to be returned if the screen width is less than [Breakpoint.SM].
 * @return The value of [this] if the screen width is at least [Breakpoint.SM], otherwise the value of [other].
 */
@Composable
infix fun <T> T.atBreakpointSM(other: T) =
    breakpoint(this, other) { breakpoint -> breakpoint >= Breakpoint.SM }

/**
 * Returns the value of [this] if the current screen width is at least [Breakpoint.XL], otherwise returns the value of [other].
 *
 * Both [first] and [other] must have the same type [T]
 *
 * @param other The value to be returned if the screen width is less than [Breakpoint.XL].
 * @return The value of [this] if the screen width is at least [Breakpoint.XL], otherwise the value of [other].
 */
@Composable
infix fun <T> T.atBreakpointXL(other: T) =
    breakpoint(this, other) { breakpoint -> breakpoint >= Breakpoint.XL }

/**
 * Returns the value of [this] if the current screen width is at least [Breakpoint.LG], otherwise returns the value of [other].
 *
 * Both [first] and [other] must have the same type [T]
 *
 * @param other The value to be returned if the screen width is less than [Breakpoint.LG].
 * @return The value of [this] if the screen width is at least [Breakpoint.LG], otherwise the value of [other].
 */
@Composable
infix fun <T> T.atBreakpointLG(other: T) =
    breakpoint(this, other) { breakpoint -> breakpoint >= Breakpoint.LG }