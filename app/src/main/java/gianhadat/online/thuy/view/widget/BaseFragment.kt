package gianhadat.online.thuy.view.widget

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View

/**
 * Created by thuythu on 28/02/2018.
 */
open abstract class BaseFragment : Fragment() {

    lateinit var base: BaseActivity

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init()
    }

    open fun init(){
        base = context as BaseActivity
    }

}