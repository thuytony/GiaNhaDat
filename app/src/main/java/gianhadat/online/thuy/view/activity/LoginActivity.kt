package gianhadat.online.thuy.view.activity

import android.content.Intent
import android.os.Bundle
import android.text.Html
import gianhadat.online.thuy.R
import gianhadat.online.thuy.manager.ext.LogUtil
import gianhadat.online.thuy.manager.ext.RxUtil
import gianhadat.online.thuy.manager.ext.SimpleToast
import gianhadat.online.thuy.manager.rest.RestBuilder
import gianhadat.online.thuy.view.widget.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*



class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var text:String = "<font color=#121111>Hãy chọn một trong số các chức năng </font> <font color=#800657>đăng nhập</font>"
        txtDescriptionLogin.setText(Html.fromHtml(text))

        btnLoginEmail.setOnClickListener {
            var intent = Intent(this, LoginEmailActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.mainfadein, R.anim.splashfadeout)
        }

        //login()
    }

    fun login(){
        RxUtil.applyHandlerStartFinish(RestBuilder.api().login("baolochn1@gmail.com", "222"),
                Runnable {  },
                Runnable {  })
                .compose(RxUtil.applyMain())
                .subscribe(
                        {
                            response ->
                            run {
                                response.let {
                                    if (response.errorId!! == "200") {
                                        LogUtil.e("LOGIN", response.data!!.token.toString())
                                        var intent = Intent(this, LoginEmailActivity::class.java)
                                        startActivity(intent)
                                        overridePendingTransition(R.anim.mainfadein, R.anim.splashfadeout)
                                    } else {
                                        LogUtil.e("LOGINNN", response.message!!)
                                        SimpleToast.showShort(response.message!!)
                                    }
                                }
                            }
                        },
                        {t ->
                            LogUtil.e("LOGINN", t.message!!)
                            SimpleToast.showShort(t.message!!)
                        }
                )
    }
}
