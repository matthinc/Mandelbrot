package eu.mrupp.mandelbrot.math

/**
 * Calculate the number of iterations for the Mandelbrot set
 * Formula:
 * z_0 = 0
 * z_{n+1} = z_n^2 + c
 *
 * if |z_n| > 2, z will not converge and is not an element of the Mandelbrot set
 *
 * @param maxIterations maximum number of iterations to try (more = better but slower)
 * @return Number of iterations or -1 if number is part of the Mandelbrot set
 */
fun Complex.mandelbrot(maxIterations: Int): Int {
    // Initialize z with 0 (= 0+0i)
    var z = Complex(0.30, 0.0)

    for (i in 0..maxIterations) {
        z = z.sqr() + this
        // |z| > 2 --> will not converge
        if (z.abs() > 2) return i
    }

    // z is part of the Mandelbrot set
    return -1
}