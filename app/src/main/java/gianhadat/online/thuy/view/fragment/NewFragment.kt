package gianhadat.online.thuy.view.fragment

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gianhadat.online.thuy.R
import gianhadat.online.thuy.view.adapter.NewViewPagerAdapter
import gianhadat.online.thuy.view.widget.BaseFragment
import kotlinx.android.synthetic.main.fragment_new.*

/**
 * Created by thuythu on 12/03/2018.
 */
class NewFragment: BaseFragment(){

    private lateinit var root: View
    private lateinit var newViewPagerAdapter: NewViewPagerAdapter

    companion object {
        val TAG = NewFragment::class.java.simpleName
        fun instance(): NewFragment {
            val args = Bundle()
            val fragment = NewFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater.inflate(R.layout.fragment_new, container,false)
        return root
    }

    override fun init() {
        super.init()

        viewPager.offscreenPageLimit = NewViewPagerAdapter.PAGE_NUMBER
        newViewPagerAdapter = NewViewPagerAdapter(base.supportFragmentManager)
        viewPager.adapter = newViewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

    }
}