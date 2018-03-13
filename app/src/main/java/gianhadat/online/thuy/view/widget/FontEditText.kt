package gianhadat.online.thuy.view.widget

import android.content.Context
import android.graphics.Typeface
import android.support.v7.widget.AppCompatEditText
import android.util.AttributeSet
import gianhadat.online.thuy.R

/**
 * Created by thuythu on 28/02/2018.
 */
class FontEditText : AppCompatEditText, BaseView {


    companion object {

        private val TAG = FontEditText::class.java.simpleName
    }

    constructor(context: Context) : super(context) {
        init( null!!, -1)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init( null!!, -1)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init( attrs, -1)
    }

    override fun init(attrs: AttributeSet, defStyleAttr: Int) {

        try {
            val t = context.obtainStyledAttributes(attrs, R.styleable.FontStyleable)
            val indext = Integer.parseInt(t.getString(R.styleable.FontStyleable_custom_font))
            val pathTypeFace = "fonts/" + context.resources.getStringArray(R.array.font_name)[indext]
            val tf = Typeface.createFromAsset(context.assets, pathTypeFace)
            typeface = tf
            t.recycle()
        } catch (ex: Exception) {

        }

    }

    /**
     *
     * @param pathTypeFace Path of font in Assets resource ("fonts/Roboto-Black.ttf").
     */
    fun setFont(pathTypeFace: String) {
        val tf = Typeface.createFromAsset(context!!.assets, pathTypeFace)
        typeface = tf
    }


}