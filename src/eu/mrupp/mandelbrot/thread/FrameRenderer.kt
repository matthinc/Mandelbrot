package eu.mrupp.mandelbrot.thread

import eu.mrupp.mandelbrot.math.Complex
import eu.mrupp.mandelbrot.math.mandelbrot
import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO
import kotlin.math.pow

class FrameRenderer(val request: RenderRequest): Runnable {

    /**
     * Needed for the calculation of start- and endpoint.
     * Grows with 1/O(2^n) for linear scaling
     */
    private val scaleCoefficient: Double by lazy {
        2 / (2.0.pow(request.zoom * 0.1))
    }

    /**
     * Start point (-2 -2) at the beginning
     */
    private val startPoint: Complex by lazy {
        Complex(request.center.re - scaleCoefficient, request.center.im - scaleCoefficient)
    }

    /**
     * End point (2 2) at the beginning
     */
    private val endPoint: Complex by lazy {
        Complex(request.center.re + scaleCoefficient, request.center.im + scaleCoefficient)
    }

    /**
     * Required increment per pixel
     */
    private val step: Double by lazy {
        (endPoint.im - startPoint.im) / request.size
    }

    override fun run() {
        val data = IntArray(request.size * request.size)
        val sizeRange = 0 until request.size

        val bufferedImage = BufferedImage(request.size, request.size, BufferedImage.TYPE_INT_RGB)
        val gfx = bufferedImage.graphics

        sizeRange.forEach { x ->
            sizeRange.forEach { y ->
                val iterations = Complex(startPoint.re + step * x, startPoint.im + step * y)
                    .mandelbrot(request.maxIterations)
                data[y * request.size + x] = request.colorMapper(iterations)
                gfx.color = Color(request.colorMapper(iterations))
                gfx.drawRect(x, y, 1, 1);
            }
        }

        ImageIO.write(bufferedImage, "png", File(request.outputFile))
    }

}