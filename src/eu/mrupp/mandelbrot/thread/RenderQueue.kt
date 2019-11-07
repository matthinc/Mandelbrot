package eu.mrupp.mandelbrot.thread

import java.util.concurrent.Executors

/**
 * Fixed thread pool for rendering
 */
class RenderQueue {

    private val threadPool = Executors.newFixedThreadPool(8);

    operator fun plus(request: RenderRequest) {
        threadPool.execute(FrameRenderer(request))
    }

}