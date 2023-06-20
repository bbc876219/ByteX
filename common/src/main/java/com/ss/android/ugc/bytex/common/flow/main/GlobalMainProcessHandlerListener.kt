package com.ss.android.ugc.bytex.common.flow.main

import com.ss.android.ugc.bytex.common.log.LevelLog
import com.ss.android.ugc.bytex.transformer.TransformEngine
import com.ss.android.ugc.bytex.transformer.utils.FetchStackTrace


/**
 * Created by yangzhiqian on 2020/8/30<br/>
 */
internal object GlobalMainProcessHandlerListener : MainProcessHandlerListener {
    override fun finishTraverseIncremental(handlers: MutableCollection<MainProcessHandler>, exception: Exception?) {
        println("GlobalMainProcessHandlerListener.finishTraverseIncremental() called with: handlers = $handlers, exception = $exception")
        for (listener in MainProcessHandlerListenerManager.getMainProcessHandlerListeners()) {
            listener.finishTraverseIncremental(handlers, exception)
        }
    }

    override fun startStartRunning(handler: MainProcessHandler, transformer: TransformEngine) {
        println("GlobalMainProcessHandlerListener.startStartRunning() called with: handler = $handler, transformer = $transformer"
        )
        for (listener in MainProcessHandlerListenerManager.getMainProcessHandlerListeners()) {
            listener.startStartRunning(handler, transformer)
        }
    }

    override fun finishInit(handler: MainProcessHandler, transformer: TransformEngine, exception: Exception?) {
        println("GlobalMainProcessHandlerListener.finishInit() called with: handler = $handler, transformer = $transformer, exception = $exception"
        )
        for (listener in MainProcessHandlerListenerManager.getMainProcessHandlerListeners()) {
            listener.finishInit(handler, transformer, exception)
        }
    }

    override fun startTraverseIncremental(handlers: MutableCollection<MainProcessHandler>) {
        println("GlobalMainProcessHandlerListener.startTraverseIncremental() called with: handlers = $handlers")
        for (listener in MainProcessHandlerListenerManager.getMainProcessHandlerListeners()) {
            listener.startTraverseIncremental(handlers)
        }
    }

    override fun startAfterTransform(handler: MainProcessHandler, transformer: TransformEngine) {
        println("GlobalMainProcessHandlerListener.startAfterTransform() called with: handler = $handler, transformer = $transformer"
        )
        for (listener in MainProcessHandlerListenerManager.getMainProcessHandlerListeners()) {
            listener.startAfterTransform(handler, transformer)
        }
    }

    override fun startTransform(handlers: MutableCollection<MainProcessHandler>) {
        println("GlobalMainProcessHandlerListener.startTransform() called with: handlers = $handlers")
        for (listener in MainProcessHandlerListenerManager.getMainProcessHandlerListeners()) {
            listener.startTransform(handlers)
        }
    }

    override fun finishTraverseAndroidJar(handlers: MutableCollection<MainProcessHandler>, exception: Exception?) {
        println("GlobalMainProcessHandlerListener.finishTraverseAndroidJar() called with: handlers = $handlers, exception = $exception"
        )
        for (listener in MainProcessHandlerListenerManager.getMainProcessHandlerListeners()) {
            listener.finishTraverseAndroidJar(handlers, exception)
        }
    }

    override fun startTraverse(handlers: MutableCollection<MainProcessHandler>) {
        println("GlobalMainProcessHandlerListener.startTraverse() called with: handlers = $handlers")
        for (listener in MainProcessHandlerListenerManager.getMainProcessHandlerListeners()) {
            listener.startTraverse(handlers)
        }
    }

    override fun finishStartRunning(handler: MainProcessHandler, transformer: TransformEngine, exception: Exception?) {
        println("GlobalMainProcessHandlerListener.finishStartRunning() called with: handler = $handler, transformer = $transformer, exception = $exception"
        )
        for (listener in MainProcessHandlerListenerManager.getMainProcessHandlerListeners()) {
            listener.finishStartRunning(handler, transformer, exception)
        }
    }

    override fun finishBeforeTransform(handler: MainProcessHandler, transformer: TransformEngine, exception: Exception?) {
        println("GlobalMainProcessHandlerListener.finishBeforeTransform() called with: handler = $handler, transformer = $transformer, exception = $exception"
        )
        for (listener in MainProcessHandlerListenerManager.getMainProcessHandlerListeners()) {
            listener.finishBeforeTransform(handler, transformer, exception)
        }
    }

    override fun startInit(handler: MainProcessHandler, transformer: TransformEngine) {
        println("GlobalMainProcessHandlerListener.startInit() called with: handler = $handler, transformer = $transformer  \n "+FetchStackTrace.getStackTraceString(Throwable())
        )
        for (listener in MainProcessHandlerListenerManager.getMainProcessHandlerListeners()) {
            listener.startInit(handler, transformer)
        }
    }

    override fun startBeforeTraverse(handler: MainProcessHandler, transformer: TransformEngine) {
        println("GlobalMainProcessHandlerListener.startBeforeTraverse() called with: handler = $handler, transformer = $transformer"
        )
        for (listener in MainProcessHandlerListenerManager.getMainProcessHandlerListeners()) {
            listener.startBeforeTraverse(handler, transformer)
        }
    }

    override fun finishTraverse(handlers: MutableCollection<MainProcessHandler>, exception: Exception?) {
        println("GlobalMainProcessHandlerListener.finishTraverse() called with: handlers = $handlers, exception = $exception"
        )
        for (listener in MainProcessHandlerListenerManager.getMainProcessHandlerListeners()) {
            listener.finishTraverse(handlers, exception)
        }
    }

    override fun finishAfterTransform(handler: MainProcessHandler, transformer: TransformEngine, exception: Exception?) {
        println("GlobalMainProcessHandlerListener.finishAfterTransform() called with: handler = $handler, transformer = $transformer, exception = $exception"
        )
        for (listener in MainProcessHandlerListenerManager.getMainProcessHandlerListeners()) {
            listener.finishAfterTransform(handler, transformer, exception)
        }
    }

    override fun startBeforeTransform(handler: MainProcessHandler, transformer: TransformEngine) {
        println("GlobalMainProcessHandlerListener.startBeforeTransform() called with: handler = $handler, transformer = $transformer"
        )
        for (listener in MainProcessHandlerListenerManager.getMainProcessHandlerListeners()) {
            listener.startBeforeTransform(handler, transformer)
        }
    }

    override fun startTraverseAndroidJar(handlers: MutableCollection<MainProcessHandler>) {
        println("GlobalMainProcessHandlerListener.startTraverseAndroidJar() called with: handlers = $handlers")
        for (listener in MainProcessHandlerListenerManager.getMainProcessHandlerListeners()) {
            listener.startTraverseAndroidJar(handlers)
        }
    }

    override fun finishBeforeTraverse(handler: MainProcessHandler, transformer: TransformEngine, exception: Exception?) {
        println("GlobalMainProcessHandlerListener.finishBeforeTraverse() called with: handler = $handler, transformer = $transformer, exception = $exception"
        )
        for (listener in MainProcessHandlerListenerManager.getMainProcessHandlerListeners()) {
            listener.finishBeforeTraverse(handler, transformer, exception)
        }
    }

    override fun finishTransform(handlers: MutableCollection<MainProcessHandler>, exception: Exception?) {
        println("GlobalMainProcessHandlerListener.finishTransform() called with: handlers = $handlers, exception = $exception"
        )
        for (listener in MainProcessHandlerListenerManager.getMainProcessHandlerListeners()) {
            listener.finishTransform(handlers, exception)
        }
    }
}