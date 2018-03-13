package gianhadat.online.thuy.view.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Html
import gianhadat.online.thuy.R
import kotlinx.android.synthetic.main.activity_guess.*

class GuessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guess)

        var text:String = "<font color=#121111>Hãy đến với </font> <font color=#de1111>Thẩm định giá</font><font color=#121111> ngay bây giờ.</font>"
        txtDescription.setText(Html.fromHtml(text))

        btnRegister.setOnClickListener {
            var intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.mainfadein, R.anim.splashfadeout)
        }
        btnLogin.setOnClickListener {
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.mainfadein, R.anim.splashfadeout)
        }

        //
        var intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.mainfadein, R.anim.splashfadeout)
        //
    }
}
