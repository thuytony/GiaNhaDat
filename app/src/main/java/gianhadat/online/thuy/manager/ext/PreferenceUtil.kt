package gianhadat.online.thuy.manager.ext

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by thuythu on 28/02/2018.
 */
class PreferenceUtil(context: Context){
    private lateinit var sharedPreferencesAcc: SharedPreferences
    private lateinit var sharedPreferencesSetting: SharedPreferences

    private val GBOT_ACCOUNT = "GIANHADAT_ACCOUNT"
    private val GBOT_SETTING = "GIANHADAT_SETTING"

    private val DEVICE_ID = "DEVICE_ID"

    companion object {
        private var prefer: PreferenceUtil? = null

        fun mInstance(context: Context): PreferenceUtil {
            if (prefer == null) {
                prefer = PreferenceUtil(context)
            }
            return prefer!!
        }
    }

    init {
        sharedPreferencesAcc = context.getSharedPreferences(GBOT_ACCOUNT, Context.MODE_PRIVATE);
        sharedPreferencesSetting = context.getSharedPreferences(GBOT_SETTING, Context.MODE_PRIVATE);
    }

    fun setDeviceId(deviceId: String){
        sharedPreferencesSetting.edit().putString(DEVICE_ID, deviceId).commit()
    }

    fun getDeviceId() : String{
        return sharedPreferencesSetting.getString(DEVICE_ID, "")
    }
}