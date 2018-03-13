package gianhadat.online.thuy

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import gianhadat.online.thuy.view.activity.GuessActivity


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var intent = Intent(this, GuessActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val handler = Handler()
        handler.postDelayed(Runnable {
            runOnUiThread {
                startActivity(intent)
            }
        }, 1000)
        overridePendingTransition(R.anim.mainfadein, R.anim.splashfadeout)
    }
}
