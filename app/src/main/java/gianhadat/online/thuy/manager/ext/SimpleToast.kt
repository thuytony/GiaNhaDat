package gianhadat.online.thuy.manager.ext

import android.app.Activity
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.support.annotation.StringRes
import android.view.View
import android.widget.Toast
import gianhadat.online.thuy.R
import gianhadat.online.thuy.application.NhaDatApp
import gianhadat.online.thuy.view.widget.FontTextView

/**
 * Created by thuythu on 28/02/2018.
 */
class SimpleToast private constructor(context: Context) {

    private val handler: Handler = Handler(Looper.getMainLooper())
    private val context: Context = context.applicationContext
    private var layoutSuccess: View? = null
    private var toastSuccess: Toast? = null
    private var layoutInfo: View? = null
    private var toastInfo: Toast? = null

    private fun show(message: String, duration: Int) {
        handler.post { Toast.makeText(NhaDatApp.buildInstance(), message, duration).show() }
    }

    private fun show(message: Int, duration: Int) {
        handler.post { Toast.makeText(NhaDatApp.buildInstance(), message, duration).show() }
    }

    private fun showSuccess(activity: Activity, message: String) {
        if(layoutSuccess == null){
            layoutSuccess = activity.getLayoutInflater().inflate(R.layout.custom_toast_success, null)
        }
        if(toastSuccess == null){
            toastSuccess = Toast(NhaDatApp.buildInstance())
        }
        layoutSuccess!!.findViewById<FontTextView>(R.id.txtToast).setText(message)
        //toast.setGravity(Gravity.CENTER, 0, 0)
        toastSuccess!!.duration = Toast.LENGTH_SHORT
        toastSuccess!!.view = layoutSuccess
        handler.post { toastSuccess!!.show() }
    }

    private fun showInfo(activity: Activity, message: String) {
        if(layoutInfo == null){
            layoutInfo = activity.getLayoutInflater().inflate(R.layout.custom_toast_info, null)
        }
        if(toastInfo == null){
            toastInfo = Toast(NhaDatApp.buildInstance())
        }
        layoutInfo!!.findViewById<FontTextView>(R.id.txtToast).setText(message)
        //toast.setGravity(Gravity.CENTER, 0, 0)
        toastInfo!!.duration = Toast.LENGTH_SHORT
        toastInfo!!.view = layoutInfo
        handler.post { toastInfo!!.show() }
    }

    companion object {
        private var INSTANCE: SimpleToast? = null


        private fun get(): SimpleToast {
            if (INSTANCE == null) {
                INSTANCE = SimpleToast(NhaDatApp.buildInstance())
            }
            return INSTANCE!!
        }

        fun showShort(message: String) {
            get().show(message, Toast.LENGTH_SHORT)
        }

        fun showLong(message: String) {
            get().show(message, Toast.LENGTH_LONG)
        }

        fun showShort(@StringRes message: Int) {
            get().show(message, Toast.LENGTH_SHORT)
        }

        fun showLong(@StringRes message: Int) {
            get().show(message, Toast.LENGTH_LONG)
        }

        fun showSuccess(activity: Activity, message: String){
            get().showSuccess(activity, message)
        }

        fun showInfo(activity: Activity, message: String){
            get().showInfo(activity, message)
        }
    }
}