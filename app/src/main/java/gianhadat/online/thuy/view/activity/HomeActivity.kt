package gianhadat.online.thuy.view.activity

import android.os.Bundle
import android.os.Handler
import gianhadat.online.thuy.R
import gianhadat.online.thuy.manager.event.Event
import gianhadat.online.thuy.manager.event.EventDefine
import gianhadat.online.thuy.manager.event.EventMessage
import gianhadat.online.thuy.manager.ext.SimpleToast
import gianhadat.online.thuy.utils.ActivityUtils
import gianhadat.online.thuy.view.fragment.HomeFragment
import gianhadat.online.thuy.view.fragment.MainFragment
import gianhadat.online.thuy.view.fragment.NewFragment
import gianhadat.online.thuy.view.widget.BaseActivity

class HomeActivity : BaseActivity() {

    private var isExitApp              : Boolean  = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        ActivityUtils.replaceFragmentToActivity(supportFragmentManager, MainFragment.instance(),R.id.frameHome,false, MainFragment.TAG)
    }

    override fun onBackPressed() {
        var homeFr = supportFragmentManager.findFragmentByTag(HomeFragment.TAG)
        var newFr = supportFragmentManager.findFragmentByTag(NewFragment.TAG)
        if (homeFr != null && homeFr.isVisible) {
            if (isExitApp) {
                super.onBackPressed()
                return
            }
            this.isExitApp = true
            SimpleToast.showInfo(this, "Ấn back thêm lần nữa để thoát")
            Handler().postDelayed(Runnable { isExitApp = false }, 2000)
        }else if (newFr != null && newFr.isVisible){
            if(getIsShowPopupNew()) {
                Event.postEvent(EventMessage(EventDefine.CLICK_BACK, true))
            }else{
                supportFragmentManager.popBackStackImmediate()
            }
        }else{
            supportFragmentManager.popBackStackImmediate()
        }
    }
}
