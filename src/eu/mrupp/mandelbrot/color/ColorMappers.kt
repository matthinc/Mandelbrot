package eu.mrupp.mandelbrot.color

import java.awt.Color

/**
 * Default color mapper which uses the whole HSL spectrum
 */
fun getDefaultColorMapper(maxIterations: Int): (Int) -> Int = {
    if (it < 0) 0
    else Color.HSBtoRGB(it / maxIterations.toFloat(), 1f, 1f)
}

/**
 * Default color mapper which uses the whole HSL spectrum
 * Shift spectrum to the blue color
 */
fun getDefaultColorMapperBlue(maxIterations: Int): (Int) -> Int = {
    if (it < 0) 0
    else Color.HSBtoRGB((it + 100) / (maxIterations.toFloat() + 100) , 1f, 1f)
}