package eu.mrupp.mandelbrot

import eu.mrupp.mandelbrot.color.getDefaultColorMapperBlue
import eu.mrupp.mandelbrot.math.Complex
import eu.mrupp.mandelbrot.thread.RenderQueue
import eu.mrupp.mandelbrot.thread.RenderRequest

// Constants
const val MAX_ZOOM = 1200
const val IMAGE_SIZE = 1000
const val ZOOM_SPEED = 0.25
const val CENTER_RE = -0.6955
const val CENTER_IM = -0.266
const val MAX_ITERATIONS_FACTOR = 2
const val MAX_ITERATIONS_START = 100
const val PATH = "/home/matthias/Desktop/brot/"

fun main() {

    val renderQueue = RenderQueue()

    for (zoom in 1..MAX_ZOOM) {
        // Calculate max iterations (optimize me!)
        val iterations = zoom * MAX_ITERATIONS_FACTOR + MAX_ITERATIONS_START

        // Filename
        val filename = zoom.toString().padStart(6, '0')
        val filePath = "${PATH}brot_$filename.png"

        val request = RenderRequest(
            IMAGE_SIZE,
            zoom * ZOOM_SPEED,
            Complex(CENTER_RE, CENTER_IM),
            iterations,
            getDefaultColorMapperBlue(iterations),
            filePath
        )

        // Add to render queue
        renderQueue + request
    }

}