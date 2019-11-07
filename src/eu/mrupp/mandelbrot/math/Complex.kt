package eu.mrupp.mandelbrot.math

import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Represents a complex number
 * See <a href=">https://en.wikipedia.org/wiki/Complex_number">Wikipedia</a>
 *
 * @param re Real part
 * @param im Imaginary part
 */
class Complex(val re: Double, val im: Double) {

    /**
     * Add two Complex numbers
     * @param other second Complex number
     * @return new Complex number
     */
    operator fun plus(other: Complex) = Complex(re + other.re, im + other.im)

    /**
     * Absolute value of a Complex number
     */
    fun abs() = sqrt(re.pow(2) + im.pow(2))

    /**
     * Square of a Complex number
     */
    fun sqr() = Complex(re.pow(2) - im.pow(2), 2 * re * im)
}