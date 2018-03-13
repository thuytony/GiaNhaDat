package gianhadat.online.thuy.view.dialog

import android.app.Activity
import android.content.Context
import android.support.v7.app.AlertDialog
import android.view.View
import gianhadat.online.thuy.R
import org.jetbrains.annotations.NotNull


/**
 * Created by thuythu on 12/03/2018.
 */
class DialogDetailNewFragment: AlertDialog {
    private lateinit var v: View
    constructor(@NotNull context: Context) : super(context){
        init(context)
    }
    fun init(context: Context) {
        val inflater = (context as Activity).layoutInflater
        v = inflater.inflate(R.layout.view_popup_new_detail, null)
        window!!.attributes.windowAnimations = R.style.CustomStyleDialog
        setView(v)
    }
}