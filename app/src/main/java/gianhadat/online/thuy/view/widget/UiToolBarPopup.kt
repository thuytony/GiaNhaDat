package gianhadat.online.thuy.view.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import gianhadat.online.thuy.R
import kotlinx.android.synthetic.main.ui_toolbar_back.view.*

/**
 * Created by thuythu on 12/03/2018.
 */
class UiToolBarPopup : RelativeLayout, BaseView {

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

        v = LayoutInflater.from(context).inflate(R.layout.ui_toolbar_back,this,true)

        val t = context.obtainStyledAttributes(attrs,
                R.styleable.ToolbarStyleable)
        try {
            val title = t.getString(R.styleable.ToolbarStyleable_title)
            pageTitle.text = title
        } finally {
            t.recycle()
        }


        /*context.let {
            base = context as BaseActivity
            //v.icBack.setOnClickListener { SimpleToast.showShort("click back")}
            v.icBack.setOnClickListener { base.supportFragmentManager.popBackStackImmediate()}
        }*/

    }

    fun setTitle(title: String) {
        pageTitle.text = title
    }

}