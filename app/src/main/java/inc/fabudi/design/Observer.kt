package inc.fabudi.design

import android.os.Handler
import android.os.Looper


object Observer {
    private var subscribers = ArrayList<Subscriber>()
    private lateinit var mainHandler: Handler
    private val timerTask = object : Runnable {
        override fun run() {
            notifySubscriber()
            mainHandler.postDelayed(this, 5000)
        }
    }

    fun subscribe(subscriber: Subscriber) {
        subscribers.add(subscriber)
    }

    fun unsubscribe(subscriber: Subscriber) {
        subscribers.remove(subscriber)
        if (subscribers.size == 0) stopTimer()
    }

    fun startTimer() {
        mainHandler = Handler(Looper.getMainLooper())
        mainHandler.post(timerTask)
    }

    private fun stopTimer() {
        mainHandler.removeCallbacks(timerTask)
    }

    private fun notifySubscriber() {
        for (subscriber in subscribers) subscriber.update()
    }
}


