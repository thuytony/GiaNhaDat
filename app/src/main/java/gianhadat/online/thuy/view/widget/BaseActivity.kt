package gianhadat.online.thuy.view.widget

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager

/**
 * Created by thuythu on 28/02/2018.
 */
open class BaseActivity : AppCompatActivity() {

    private var isShowPopupNew = false

    companion object {

        val TAG = BaseActivity::class.java.simpleName

    }


    fun hideKeyboard() {
        try {
            val view = currentFocus
            if (view != null) {
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                if(imm.isActive){
                    imm.hideSoftInputFromWindow(view.windowToken, 0)
                }
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    fun setIsShowPopupNew(isShow: Boolean){
        this.isShowPopupNew = isShow
    }
    fun getIsShowPopupNew(): Boolean{
        return isShowPopupNew
    }

}