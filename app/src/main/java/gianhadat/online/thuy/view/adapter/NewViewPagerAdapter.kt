package gianhadat.online.thuy.view.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import gianhadat.online.thuy.view.fragment.viewpager.NewBatDongSanFragment

/**
 * Created by thuythu on 12/03/2018.
 */
class NewViewPagerAdapter(fm: FragmentManager?): FragmentStatePagerAdapter(fm){

    companion object {
        val PAGE_NUMBER = 8
        val BDS_INDEX   = 0
        val TC_INDEX    = 1
        val TL_INDEX    = 2
        val TV_INDEX    = 3
    }

    override fun getItem(position: Int): Fragment {

        var fr: Fragment? = null

        when(position){
            BDS_INDEX -> fr = NewBatDongSanFragment.instance()
            TC_INDEX  -> fr = NewBatDongSanFragment.instance()
            TL_INDEX  -> fr = NewBatDongSanFragment.instance()
            TV_INDEX  -> fr = NewBatDongSanFragment.instance()
            else      -> fr = NewBatDongSanFragment.instance()
        }
        return fr!!
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var title: String = ""
        when(position){
            BDS_INDEX -> title = "B.Đ sản"
            TC_INDEX  -> title = "Tài chính"
            TL_INDEX  -> title = "Tài liệu"
            TV_INDEX  -> title = "Tư vấn"
            else      -> title = "B.Đ sản"
        }
        return title
    }

    override fun getCount(): Int {
        return PAGE_NUMBER
    }
}