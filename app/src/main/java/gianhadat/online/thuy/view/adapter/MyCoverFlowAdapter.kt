package gianhadat.online.thuy.view.adapter

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.dolphinwang.imagecoverflow.CoverFlowAdapter
import gianhadat.online.thuy.module.CoverFlow

/**
 * Created by thuythu on 02/03/2018.
 */
class MyCoverFlowAdapter: CoverFlowAdapter{

    private var dataCoverImage: MutableList<CoverFlow> = arrayListOf()

    constructor(context: Context, dataCoverImage: MutableList<CoverFlow>) {
        this.dataCoverImage = dataCoverImage
        image1 = BitmapFactory.decodeResource(context.getResources(), dataCoverImage.get(0).getBitmapImage())
        image2 = BitmapFactory.decodeResource(context.getResources(), dataCoverImage.get(1).getBitmapImage())
        image3 = BitmapFactory.decodeResource(context.getResources(), dataCoverImage.get(2).getBitmapImage())
        image4 = BitmapFactory.decodeResource(context.getResources(), dataCoverImage.get(3).getBitmapImage())
    }

    private var image1: Bitmap? = null
    private var image2: Bitmap? = null
    private var image3: Bitmap? = null
    private var image4: Bitmap? = null

    override fun getCount(): Int {
        return dataCoverImage.size
    }

    override fun getImage(position: Int): Bitmap? {
        when (position){
            0 -> return image1
            1 -> return image2
            2 -> return image3
            3 -> return image4
            else -> return image1
        }
    }

    override fun getContentImage(position: Int): String {
        return dataCoverImage.get(position).getTextContent()
    }
}