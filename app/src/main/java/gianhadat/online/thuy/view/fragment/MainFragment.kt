package gianhadat.online.thuy.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gianhadat.online.thuy.R
import gianhadat.online.thuy.utils.ActivityUtils
import gianhadat.online.thuy.view.widget.BaseFragment

/**
 * Created by thuythu on 07/03/2018.
 */
class MainFragment : BaseFragment(){

    private lateinit var root: View

    companion object {
        val TAG = MainFragment::class.java.simpleName
        fun instance(): MainFragment {
            val args = Bundle()
            val fragment = MainFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        root = inflater.inflate(R.layout.fragment_main, container,false)
        return root
    }

    override fun init() {
        super.init()
        ActivityUtils.replaceFragmentToActivity(base.supportFragmentManager,HomeFragment.instance(),R.id.frameMain,false,HomeFragment.TAG)

    }
}