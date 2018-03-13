package gianhadat.online.thuy.view.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import gianhadat.online.thuy.R
import gianhadat.online.thuy.manager.ext.SimpleToast
import kotlinx.android.synthetic.main.ui_toolbar_home.view.*

/**
 * Created by thuythu on 07/03/2018.
 */
class UiToolBarHome : RelativeLayout, BaseView {

    private lateinit var v: View
    private lateinit var base: BaseActivity

    constructor(context: Context) : super(context) {
        init(null!!, -1)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, -1)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(attrs, defStyleAttr)
    }

    override fun init(attrs: AttributeSet, defStyleAttr: Int) {

        v = LayoutInflater.from(context).inflate(R.layout.ui_toolbar_home,this,true)

        val t = context.obtainStyledAttributes(attrs,
                R.styleable.ToolbarStyleable)


        context.let {
            base = context as BaseActivity
            v.icMenu.setOnClickListener { SimpleToast.showShort("click menu")}
        }

    }

}