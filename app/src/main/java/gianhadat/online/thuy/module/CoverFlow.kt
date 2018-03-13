package gianhadat.online.thuy.module

import android.graphics.Bitmap
import gianhadat.online.thuy.R


/**
 * Created by thuythu on 02/03/2018.
 */
class CoverFlow{
    private var bitmapImage: Int? = null
    private var textContent: String? = null

    constructor(bitmapImage: Int, textContent: String){
        this.bitmapImage = bitmapImage
        this.textContent = textContent
    }

    fun setBitmapImage(bitmapImage: Int){
        this.bitmapImage = bitmapImage
    }
    fun getBitmapImage(): Int{
        val differenceBitmap = Bitmap.createBitmap(100, 200, Bitmap.Config.ARGB_8888)
        return bitmapImage ?: R.drawable.ic_launcher
    }

    fun setTextContent(textContent: String){
        this.textContent = textContent
    }
    fun getTextContent(): String{
        return textContent ?: ""
    }
}