package gianhadat.online.thuy.view.fragment.viewpager

import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.os.Build
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import android.webkit.WebView
import android.widget.ImageView
import android.widget.PopupWindow
import com.daimajia.slider.library.Animations.DescriptionAnimation
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.BaseSliderView
import com.daimajia.slider.library.SliderTypes.TextSliderViewDefault
import com.daimajia.slider.library.Tricks.ViewPagerEx
import gianhadat.online.thuy.R
import gianhadat.online.thuy.manager.event.EventDefine
import gianhadat.online.thuy.manager.event.EventMessage
import gianhadat.online.thuy.manager.ext.LogUtil
import gianhadat.online.thuy.manager.ext.SimpleToast
import gianhadat.online.thuy.module.New
import gianhadat.online.thuy.view.adapter.NewAdapter
import gianhadat.online.thuy.view.widget.BaseFragment
import kotlinx.android.synthetic.main.fragment_new_bat_dong_san.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


/**
 * Created by thuythu on 12/03/2018.
 */
class NewBatDongSanFragment: BaseFragment(), BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener, NewAdapter.OnClickItemNew{

    private lateinit var root: View
    private lateinit var data: MutableList<New>
    private lateinit var newAdapter: NewAdapter
    private lateinit var mPopupWindow: PopupWindow
    private lateinit var mWebViewNew: WebView
    private lateinit var mToolBarPop: ImageView
    private lateinit var mImgBack: ImageView

    companion object {
        val TAG = NewBatDongSanFragment::class.java.simpleName
        fun instance(): NewBatDongSanFragment {
            val args = Bundle()
            val fragment = NewBatDongSanFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater.inflate(R.layout.fragment_new_bat_dong_san, container,false)
        return root
    }

    override fun init() {
        super.init()

        setTopNew()

        setRecyclerView()

        createPopUp()
    }

    override fun onClickItem(position: Int) {
        mWebViewNew.getSettings().setJavaScriptEnabled(true)
        mWebViewNew.loadUrl("http://dalo.vn/news-details/LoI-KHUYeN-HuU-iCH-CHO-AI-MUoN-daU-Tu-BaT-doNG-SaN-THaNH-CoNG-p6.html")

        mPopupWindow.showAtLocation(root, Gravity.CENTER,0,0)
        base.setIsShowPopupNew(true)
    }

    fun setTopNew(){
        var contentString = "Mua bất động sản có vị trí địa lý thuận lợi: Yếu tố vị trí, môi trường xã hội còn quan trọng hơn chính bất động sản của bạn. Vị trí có thuận tiện cho việc đi lại không? Giao thông có dễ dàng không? Các dịch vụ có thuận tiện không? Khí hậu trong lành hay ô nhiễm?…là những yếu tố bạn cần quan tâm. Mua một ngôi nhà xấu có vị trí thuận lợi vẫn tốt hơn một ngôi nhà đẹp có vị trí không thuận lợi vì nhà xấu thì vẫn sửa sang được theo ý muốn của mình. Nếu bạn có khả năng tài chính thì nên mua bất động sản có diện tích rộng vì nó hứa hẹn mức lợi nhuận cao hơn rất nhiều"
        var contentString2 = "Mua bất động sản có vị trí địa lý thuận lợi: Yếu tố vị trí, môi trường xã hội còn quan trọng hơn chính bất động sản của bạn. Vị trí có thuận tiện cho việc đi lại không? Giao thông có dễ dàng không? Các dịch vụ có thuận tiện không? Khí hậu trong lành hay ô nhiễm?…là những yếu tố bạn cần quan tâm. Mua một ngôi nhà xấu có vị trí thuận lợi vẫn tốt hơn một ngôi nhà đẹp có vị trí không thuận lợi vì nhà xấu thì vẫn sửa sang được theo ý muốn của mình. Nếu bạn có khả năng tài chính thì nên mua bất động sản có diện tích rộng vì nó hứa hẹn mức lợi nhuận cao hơn "
        var contentString3 = "Mua bất động sản có vị trí địa lý thuận lợi: Yếu tố vị trí, môi trường xã hội còn quan trọng hơn chính bất động sản của bạn. Vị trí có thuận tiện cho việc đi lại không? Giao thông có dễ dàng không? Các dịch vụ có thuận tiện không? Khí hậu trong lành hay ô nhiễm?…là những yếu tố bạn cần quan tâm. Mua một ngôi nhà xấu có vị trí thuận lợi vẫn tốt hơn một ngôi nhà đẹp có vị trí không thuận lợi vì nhà xấu thì vẫn sửa sang được theo ý muốn của mình. Nếu bạn có khả năng tài chính thì nên mua bất động sản có diện tích rộng vì nó hứa hẹn mức lợi nhuận cao"
        var contentString4 = "Mua bất động sản có vị trí địa lý thuận lợi: Yếu tố vị trí, môi trường xã hội còn quan trọng hơn chính bất động sản của bạn. Vị trí có thuận tiện cho việc đi lại không? Giao thông có dễ dàng không? Các dịch vụ có thuận tiện không? Khí hậu trong lành hay ô nhiễm?…là những yếu tố bạn cần quan tâm. Mua một ngôi nhà xấu có vị trí thuận lợi vẫn tốt hơn một ngôi nhà đẹp có vị trí không thuận lợi vì nhà xấu thì vẫn sửa sang được theo ý muốn của mình. Nếu bạn có khả năng tài chính thì nên mua bất động sản có diện tích rộng vì nó hứa hẹn mức lợi nhuận cao hơn rất"
        //set Slide Show
        var url_maps = HashMap<String, String>()
        url_maps[contentString] = "http://dalo.vn/uploads/banners/1510851232_Sf4sm.jpg"
        url_maps[contentString2] = "http://dalo.vn/uploads/banners/1510824892_qoUuK.jpg"
        url_maps[contentString3] = "http://dalo.vn/uploads/banners/1515401692_k2IXH.png"
        url_maps[contentString4] = "http://dalo.vn/uploads/banners/1511085109_ueIoW.jpg"
        var file_maps = HashMap<String, Int>()
        file_maps["Hannibal"] = R.drawable.image_cover
        file_maps["Big Bang Theory"] = R.drawable.image_cover
        file_maps["House of Cards"] = R.drawable.image_cover
        file_maps["Game of Thrones"] = R.drawable.image_cover
        for (name in url_maps.keys) {
            val textSliderView = TextSliderViewDefault(context)
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(url_maps[name]!!)
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this)

            //add your extra information
            textSliderView.bundle(Bundle())
            textSliderView.bundle
                    .putString("extra", name)

            mDemoSlider.addSlider(textSliderView)
            mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion)
            mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom)
            mDemoSlider.setCustomAnimation(DescriptionAnimation())
            mDemoSlider.setDuration(4000)
            mDemoSlider.addOnPageChangeListener(this)
            mDemoSlider.setPresetTransformer("ZoomIn")
        }
    }

    override fun onSliderClick(slider: BaseSliderView) {
        SimpleToast.showShort(slider.bundle.get("extra")!!.toString() + "")
    }
    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

    override fun onPageSelected(position: Int) {
        LogUtil.d("Slider Demo", "Page Changed: " + position)
    }

    override fun onPageScrollStateChanged(state: Int) {}

    fun setRecyclerView(){
        data = arrayListOf()
        rcNew.setHasFixedSize(true)
        newAdapter = NewAdapter(context!!, data)
        rcNew.layoutManager = LinearLayoutManager(context!!, LinearLayoutManager.VERTICAL, false)
        //add ItemDecoration
        //rcNew.addItemDecoration(VerticalSpaceItemDecoration(VERTICAL_ITEM_SPACE))
        //or
        //rcNew.addItemDecoration(DividerItemDecorationCustom(context!!))
        //or
        //rcNew.addItemDecoration(DividerItemDecorationCustom(context!!, R.drawable.divider))
        newAdapter.setOnClickItemNew(this)
        rcNew.adapter = newAdapter
    }

    fun createPopUp(){
        val inflater = context!!.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        // Inflate the custom layout/view
        val customView = inflater.inflate(R.layout.view_popup_new_detail, null)
        mPopupWindow = PopupWindow(
                customView,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT
        )
        if(Build.VERSION.SDK_INT>=21){
            mPopupWindow.setElevation(5.0f);
        }

        mWebViewNew = mPopupWindow.contentView.findViewById<WebView>(R.id.webViewNew)
        mToolBarPop = mPopupWindow.contentView.findViewById<ImageView>(R.id.icBack)
        mImgBack = mToolBarPop.findViewById<ImageView>(R.id.icBack)
        mImgBack.setOnClickListener { mPopupWindow.dismiss() }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: EventMessage) {
        when (event.key) {
            EventDefine.CLICK_BACK -> {
                if(mPopupWindow.isShowing){
                    mPopupWindow.dismiss()
                    base.setIsShowPopupNew(false)
                }
            }
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        EventBus.getDefault().register(this)
    }

    override fun onDetach() {
        super.onDetach()
        EventBus.getDefault().unregister(this)
    }
}