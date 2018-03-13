package gianhadat.online.thuy.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import gianhadat.online.thuy.R
import gianhadat.online.thuy.view.widget.BaseFragment
import gianhadat.online.thuy.view.widget.FontEditText
import gianhadat.online.thuy.view.widget.FontTextView
import kotlinx.android.synthetic.main.layout_land_house.*


class LandHouseFragment : BaseFragment() {

    private lateinit var root: View

    companion object {
        val TAG = LandHouseFragment::class.java.simpleName
        fun instance(): LandHouseFragment {
            val args = Bundle()
            val fragment = LandHouseFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        root = inflater.inflate(R.layout.fragment_land_house, container,false)
        return root
    }

    override fun init() {
        super.init()

        val adapter = ArrayAdapter.createFromResource(context,
                R.array.travelreasons, R.layout.hint_item)
        adapter.setDropDownViewResource(R.layout.dropdown_hint_item)

        (lableCity as FontTextView).setText(R.string.spinner_city)
        (spinnerCity as Spinner).adapter = adapter

        (lableDistrict as FontTextView).setText(R.string.spinner_district)
        (spinnerDistrict as Spinner).adapter = adapter

        (lableStreet as FontTextView).setText(R.string.spinner_street)
        (spinnerStreet as Spinner).adapter = adapter

        (lableLocation as FontTextView).setText(R.string.spinner_location)
        (spinnerLocation as Spinner).adapter = adapter

        (labelStreetWidth as FontTextView).setText(R.string.edt_street_width)
        (edtStreetWidth as FontEditText).setHint(R.string.hint_street_width)

        (labelLocationAsset as FontTextView).setText(R.string.edt_location_asset)
        (edtLocationAsset as FontEditText).setHint(R.string.hint_location_asset)

        (labelFacade as FontTextView).setText(R.string.edt_facade)
        (edtFacade as FontEditText).setHint(R.string.hint_facade)

        (labelAcreage as FontTextView).setText(R.string.edt_acreage)
        (edtAcreage as FontEditText).setHint(R.string.hint_acreage)

        (lableShape as FontTextView).setText(R.string.spinner_shape)
        (spinnerShape as Spinner).adapter = adapter

        (lableMattiepgiap as FontTextView).setText(R.string.spinner_mat_tiep_giap)
        (spinnerMattiepgiap as Spinner).adapter = adapter

        (lableTraffic as FontTextView).setText(R.string.spinner_traffic)
        (spinnerTraffic as Spinner).adapter = adapter

        (lableBusinessAdvantage as FontTextView).setText(R.string.spinner_business_advantage)
        (spinnerBusinessAdvantage as Spinner).adapter = adapter

        (lableCoGiaiToa as FontTextView).setText(R.string.spinner_co_giai_toa)
        (spinnerCoGiaiToa as Spinner).adapter = adapter
    }
}
