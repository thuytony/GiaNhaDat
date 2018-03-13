package gianhadat.online.thuy.view.fragment

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.TextView
import com.daimajia.slider.library.Animations.DescriptionAnimation
import com.daimajia.slider.library.Indicators.PagerIndicator
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.BaseSliderView
import com.daimajia.slider.library.SliderTypes.TextSliderView
import com.daimajia.slider.library.Tricks.ViewPagerEx
import com.dolphinwang.imagecoverflow.CoverFlowView
import gianhadat.online.thuy.R
import gianhadat.online.thuy.manager.ext.LogUtil
import gianhadat.online.thuy.manager.ext.SimpleToast
import gianhadat.online.thuy.module.CoverFlow
import gianhadat.online.thuy.utils.ActivityUtils
import gianhadat.online.thuy.view.adapter.MyCoverFlowAdapter
import gianhadat.online.thuy.view.adapter.SlideImageAdappter
import gianhadat.online.thuy.view.amin.SlideImageAnimation
import gianhadat.online.thuy.view.widget.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.ui_navigation_view.*


class HomeFragment : BaseFragment(), BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener, View.OnClickListener {

    private lateinit var root:View
    private var dataCoverImage: MutableList<CoverFlow> = arrayListOf()

    companion object {
        val TAG = HomeFragment::class.java.simpleName
        fun instance(): HomeFragment {
            val args = Bundle()
            val fragment = HomeFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        root = inflater.inflate(R.layout.fragment_home, container,false)
        return root
    }

    override fun init() {
        super.init()

        imgMenu.setOnClickListener(this)
        itemNhaDat.setOnClickListener(this)
        itemChungCu.setOnClickListener(this)
        itemVanTai.setOnClickListener(this)
        itemXayDung.setOnClickListener(this)
        itemNew.setOnClickListener(this)
        itemSupport.setOnClickListener(this)

        var mCoverFlowView: CoverFlowView<MyCoverFlowAdapter> = coverflow as CoverFlowView<MyCoverFlowAdapter>

        dataCoverImage.add(CoverFlow(R.drawable.nha_dat, "Nhà Đất"))
        dataCoverImage.add(CoverFlow(R.drawable.chung_cu, "Chung Cư"))
        dataCoverImage.add(CoverFlow(R.drawable.ct_xay_dung, "Công Trình Xây Dựng"))
        dataCoverImage.add(CoverFlow(R.drawable.pt_van_tai, "Phương Tiện Vận Tải"))

        var mAdapter: MyCoverFlowAdapter = MyCoverFlowAdapter(context!!, dataCoverImage)


        mCoverFlowView.setAdapter(mAdapter)
        //mCoverFlowView.setSelection(2)

        /*mCoverFlowView.setCoverFlowListener(object : CoverFlowView.CoverFlowListener<MyCoverFlowAdapter> {
            override fun visibleImageClick(coverFlowView: CoverFlowView<MyCoverFlowAdapter>?, position: Int, place: Int) {

            }

            override fun imageOnTop(
                            view: CoverFlowView<MyCoverFlowAdapter>,
                            position: Int, left: Float, top: Float, right: Float,
                            bottom: Float, contentImage: String) {
                        LogUtil.e("COVER_FLOW", position.toString() + " on top!"+contentImage)
                        txtContent.setText(contentImage)
                    }

                    override fun topImageClicked(
                            view: CoverFlowView<MyCoverFlowAdapter>, position: Int) {
                        LogUtil.e("COVER_FLOW", position.toString() + " clicked!")
                    }

                    override fun invalidationCompleted() {
                        LogUtil.e("COVER_FLOW", "abcabc")
                 }
                })

        mCoverFlowView.setTopImageLongClickListener {
            position -> LogUtil.e("COVER_FLOW", "top image long clicked == >" + position)
        }*/
        mCoverFlowView.setImageClickListener(object : CoverFlowView.ImageClickListener {
            override fun onClick(coverFlowView: CoverFlowView<*>, position: Int, contentImage: String) {
                LogUtil.e("COVER_FLOW", position.toString() + " clicked!")
                coverFlowView.setSelection(position)
                txtContent.setText(contentImage)
            }
        })


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
            val textSliderView = TextSliderView(context)
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
            transformers.setAdapter(SlideImageAdappter(context!!))
            mDemoSlider.setPresetTransformer("ZoomIn")
            transformers.setOnItemClickListener(object : AdapterView.OnItemClickListener {
                override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    mDemoSlider.setPresetTransformer((view as TextView).getText().toString())
                }
            })
        }

        //set click img menu
        //imgMenu.setOnClickListener { E }
    }

    override fun onClick(v: View?) {
        LogUtil.d("TEST123", "on click ${v!!.id}")
        when(v.id){
            R.id.imgMenu -> switchHomeDrawer(true)
            R.id.itemNhaDat -> {
                switchHomeDrawer(false)
                ActivityUtils.addFragmentToActivity(base.supportFragmentManager, LandHouseFragment.instance(), R.id.frameMain, true, LandHouseFragment.TAG)
            }
            R.id.itemNew -> {
                switchHomeDrawer(false)
                ActivityUtils.addFragmentToActivity(base.supportFragmentManager, NewFragment.instance(),R.id.frameMain,true,NewFragment.TAG)
            }
        }
    }
    fun switchHomeDrawer(isOpen: Boolean) {

        if (isOpen) {

            homeDrawer.openDrawer(Gravity.START)
        } else {
            homeDrawer.closeDrawers()
        }

    }

    override fun onSliderClick(slider: BaseSliderView) {
        SimpleToast.showShort(slider.bundle.get("extra")!!.toString() + "")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.action_custom_indicator -> mDemoSlider.setCustomIndicator(custom_indicator as PagerIndicator)
            R.id.action_custom_child_animation -> mDemoSlider.setCustomAnimation(SlideImageAnimation())
            R.id.action_restore_default -> {
                mDemoSlider!!.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom)
                mDemoSlider!!.setCustomAnimation(DescriptionAnimation())
            }
            R.id.action_github -> {
                val browserIntent = Intent(ACTION_VIEW, Uri.parse("https://github.com/daimajia/AndroidImageSlider"))
                startActivity(browserIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

    override fun onPageSelected(position: Int) {
        LogUtil.d("Slider Demo", "Page Changed: " + position)
    }

    override fun onPageScrollStateChanged(state: Int) {}


    override fun onStop() {
        super.onStop()
        mDemoSlider.stopAutoCycle()
    }
}
