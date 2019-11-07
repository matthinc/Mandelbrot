package eu.mrupp.mandelbrot.thread

import eu.mrupp.mandelbrot.math.Complex

data class RenderRequest (
    val size: Int,
    val zoom: Double,
    val center: Complex,
    val maxIterations: Int,
    val colorMapper: (Int) -> Int,
    val outputFile: String
)