package inc.fabudi.design

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Random


class MainActivity : AppCompatActivity(), Subscriber {
    private val imageViews = ArrayList<ImageView>()
    private lateinit var lastSeenLabel: TextView
    private lateinit var usersCounterLabel: TextView
    private lateinit var viewsLabel: TextView
    private lateinit var smthidkLabel: TextView
    private lateinit var followersLabel: TextView
    private lateinit var avatarsMoreLabel: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_from_reference)
        initViewsReferences()
        ProfileGenerator.generateProfiles(10)
        Observer.startTimer()
        Observer.subscribe(this)
    }

    override fun onStop() {
        super.onStop()
        Observer.unsubscribe(this)
    }

    private fun initViewsReferences() {
        lastSeenLabel = findViewById(R.id.last_seen)
        usersCounterLabel = findViewById(R.id.users_counter)
        viewsLabel = findViewById(R.id.views)
        smthidkLabel = findViewById(R.id.smthidk)
        followersLabel = findViewById(R.id.followers)
        avatarsMoreLabel = findViewById(R.id.avatar_small_more)
        imageViews.add(findViewById(R.id.avatar_small_1))
        imageViews.add(findViewById(R.id.avatar_small_2))
        imageViews.add(findViewById(R.id.avatar_small_3))
        imageViews.add(findViewById(R.id.avatar_small_4))
        imageViews.add(findViewById(R.id.avatar))
        imageViews.add(findViewById(R.id.image))
    }

    override fun update() {
        val profile = ProfileGenerator.getNextProfile()
        avatarsMoreLabel.text = profile.avatarsMoreLabel
        lastSeenLabel.text = profile.lastSeenLabel
        viewsLabel.text = profile.viewsLabel
        smthidkLabel.text = profile.smthidkLabel
        followersLabel.text = profile.followersLabel
        usersCounterLabel.text = profile.usersCounterLabel
        for ((i, iv) in imageViews.withIndex()) {
            iv.setBackgroundColor(profile.imageViewsColor[i])
        }
    }

}