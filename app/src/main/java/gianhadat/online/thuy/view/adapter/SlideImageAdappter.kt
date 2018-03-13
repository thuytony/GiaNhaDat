package gianhadat.online.thuy.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.daimajia.slider.library.SliderLayout
import gianhadat.online.thuy.R


/**
 * Created by thuythu on 02/03/2018.
 */
class SlideImageAdappter : BaseAdapter {
    private var mContext: Context
    constructor(context: Context){
        mContext = context
    }

    override fun getCount(): Int {
        return SliderLayout.Transformer.values().size
    }

    override fun getItem(position: Int): Any {
        return SliderLayout.Transformer.values()[position].toString()
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val t = LayoutInflater.from(mContext).inflate(R.layout.item_slide_show, null) as TextView
        t.setText(getItem(position).toString())
        return t
    }
}