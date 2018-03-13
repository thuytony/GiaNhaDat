package gianhadat.online.thuy.view.activity

import android.content.Intent
import android.os.Bundle
import android.text.Html
import gianhadat.online.thuy.R
import gianhadat.online.thuy.view.widget.BaseActivity
import kotlinx.android.synthetic.main.activity_login_email.*

class LoginEmailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_email)

        var text:String = "<font color=#121111>Hãy điền </font> <font color=#de1111>chính xác</font><font color=#121111> các trường thông tin dưới đây</font>"
        txtDescriptionLoginEmail.setText(Html.fromHtml(text))

        btnLogin.setOnClickListener {
            var intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            overridePendingTransition(R.anim.mainfadein, R.anim.splashfadeout)
        }
    }
}
