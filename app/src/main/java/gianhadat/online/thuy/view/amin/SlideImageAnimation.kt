package gianhadat.online.thuy.view.amin

import android.util.Log
import android.view.View
import com.daimajia.slider.library.Animations.BaseAnimationInterface

/**
 * Created by thuythu on 02/03/2018.
 */
class SlideImageAnimation : BaseAnimationInterface {
    private val TAG = "SlideImageAnimation"

    override fun onPrepareCurrentItemLeaveScreen(current: View) {
        val descriptionLayout = current.findViewById<View>(com.daimajia.slider.library.R.id.description_layout)
        if (descriptionLayout != null) {
            current.findViewById<View>(com.daimajia.slider.library.R.id.description_layout).setVisibility(View.INVISIBLE)
        }
        Log.e(TAG, "onPrepareCurrentItemLeaveScreen called")
    }

    override fun onPrepareNextItemShowInScreen(next: View) {
        val descriptionLayout = next.findViewById<View>(com.daimajia.slider.library.R.id.description_layout)
        if (descriptionLayout != null) {
            next.findViewById<View>(com.daimajia.slider.library.R.id.description_layout).setVisibility(View.INVISIBLE)
        }
        Log.e(TAG, "onPrepareNextItemShowInScreen called")
    }

    override fun onCurrentItemDisappear(view: View) {
        Log.e(TAG, "onCurrentItemDisappear called")
    }

    override fun onNextItemAppear(view: View) {

        val descriptionLayout = view.findViewById<View>(com.daimajia.slider.library.R.id.description_layout)
        if (descriptionLayout != null) {
            view.findViewById<View>(com.daimajia.slider.library.R.id.description_layout).setVisibility(View.VISIBLE)
            //            ValueAnimator animator = ObjectAnimator.ofFloat(
            //                    descriptionLayout, "y", -descriptionLayout.getHeight(),
            //                    0).setDuration(500);
            //            animator.start();
            //            new BounceInAnimator().animate(descriptionLayout);
            //StandUpAnimator().animate(descriptionLayout)
        }
        Log.e(TAG, "onCurrentItemDisappear called")
    }
}