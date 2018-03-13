package gianhadat.online.thuy.view.activity

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.view.View
import gianhadat.online.thuy.R
import android.widget.ArrayAdapter
import gianhadat.online.thuy.manager.ext.SimpleToast
import gianhadat.online.thuy.view.widget.BaseActivity
import kotlinx.android.synthetic.main.activity_housing.*
import android.widget.PopupWindow
import android.view.LayoutInflater
import android.view.ViewGroup.LayoutParams
import lecho.lib.hellocharts.model.*
import lecho.lib.hellocharts.view.LineChartView
import android.os.Handler
import android.widget.AdapterView
import kotlinx.android.synthetic.main.layout_data_housing.*


class HousingActivity : BaseActivity() {

    private var mPopupWindow: PopupWindow? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_housing)

        val ITEMS = arrayOf("Hải Dương", "Vĩnh Phúc", "Nam Định", "Hà Nội", "Đà Nẵng", "Nghệ An")
        val adapter: ArrayAdapter<String>
        adapter = ArrayAdapter(this, R.layout.hint_item, ITEMS)
        adapter.setDropDownViewResource(R.layout.dropdown_hint_item)

        spinnerCity.setAdapter(adapter)
        spinnerCity.setHint("--Lựa Chọn--")
        spinnerCity.showFloatingLabel()
        spinnerCity.setOnItemSelectedListener(object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                SimpleToast.showShort(p2.toString())
            }
        })

        spinnerDistrict.setAdapter(adapter)
        spinnerDistrict.showFloatingLabel()
        spinnerDistrict.setHint("--Lựa Chọn--")
        spinnerStreet.setAdapter(adapter)
        spinnerStreet.showFloatingLabel()
        spinnerStreet.setHint("--Lựa Chọn--")
        spinnerLocation.setAdapter(adapter)
        spinnerLocation.showFloatingLabel()
        spinnerLocation.setHint("--Lựa Chọn--")
        spinnerShape.setAdapter(adapter)
        spinnerShape.showFloatingLabel()
        spinnerShape.setHint("--Lựa Chọn--")
        spinnerMattiepgiap.setAdapter(adapter)
        spinnerMattiepgiap.showFloatingLabel()
        spinnerMattiepgiap.setHint("--Lựa Chọn--")
        spinnerBusinessAdvantage.setAdapter(adapter)
        spinnerBusinessAdvantage.showFloatingLabel()
        spinnerBusinessAdvantage.setHint("--Lựa Chọn--")
        spinnerCoGiaiToa.setAdapter(adapter)
        spinnerCoGiaiToa.showFloatingLabel()
        spinnerCoGiaiToa.setHint("--Lựa Chọn--")

        edtStreetWidth.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
                if(p0!!.length > 0){
                    fab.visibility = View.VISIBLE
                }else{
                    fab.visibility = View.GONE
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

        })

        btnCheck.setOnClickListener {
            //edt9.requestFocus()
            //edt9.setError("Lỗi", resources.getDrawable(R.drawable.ic_info))
            edtAcreage.requestFocus()
            spinnerCity.setError("Chưa chọn gì cả")
            val handler = Handler()
            handler.postDelayed(Runnable {
                runOnUiThread {
                    scroll.scrollTo(0, 200)
                }
            }, 350)
        }

        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val customView = inflater.inflate(R.layout.popup_detail, null)
        mPopupWindow = PopupWindow(
                customView,
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT
        )
        if(Build.VERSION.SDK_INT>=21){
            mPopupWindow!!.setElevation(5.0f)
        }


        fab.setOnClickListener {

            hideKeyboard()

            mPopupWindow.let{

                val values = ArrayList<PointValue>()
                values.add(PointValue(0f, 2f))
                values.add(PointValue(1f, 4f))
                values.add(PointValue(2f, 3f))
                values.add(PointValue(3f, 4f))

                //In most cased you can call data model methods in builder-pattern-like manner.
                val line = Line(values).setColor(Color.BLUE).setCubic(true)
                val lines = ArrayList<Line>()
                lines.add(line)

                val data = LineChartData()
                data.lines = lines

                var axisValuesForX = ArrayList<AxisValue>()
                var axisValuesForY = ArrayList<AxisValue>()
                var tempAxisValue: AxisValue

                for(i in 0..5 step 1){
                    tempAxisValue = AxisValue(i.toFloat())
                    tempAxisValue.setLabel(i.toString() + "/2017")
                    axisValuesForX.add(tempAxisValue)
                }

                for(i in 0..5 step 1){
                    tempAxisValue = AxisValue(i.toFloat())
                    tempAxisValue.setLabel(i.toString())
                    axisValuesForY.add(tempAxisValue)
                }
                val xAxis = Axis(axisValuesForX)
                val yAxis = Axis(axisValuesForY)
                data.axisXBottom = xAxis
                data.axisYLeft = yAxis


                var chart: LineChartView = mPopupWindow!!.contentView.findViewById(R.id.chart)
                chart.lineChartData = data

                mPopupWindow!!.showAtLocation(root, Gravity.CENTER,0,0)
            }
        }
    }

    override fun onBackPressed() {
        mPopupWindow.let {
            if(mPopupWindow!!.isShowing){
                mPopupWindow!!.dismiss()
            }else{
                super.onBackPressed()
            }
        }
    }
}
