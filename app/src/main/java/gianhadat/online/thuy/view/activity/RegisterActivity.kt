package gianhadat.online.thuy.view.activity

import android.os.Bundle
import android.text.Html
import gianhadat.online.thuy.R
import gianhadat.online.thuy.view.widget.BaseActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var text:String = "<font color=#121111>Cho chúng tôi biết thêm </font> <font color=#ccbf0c>thông tin</font><font color=#121111> của bạn</font>"
        txtDescriptionRegister.setText(Html.fromHtml(text))
    }
}
