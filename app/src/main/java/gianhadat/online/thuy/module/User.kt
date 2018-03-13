package gianhadat.online.thuy.module

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by thuythu on 07/03/2018.
 */
class User: Serializable{
    @SerializedName("g_name")
    @Expose
    var gName:String? = null
    @SerializedName("g_email")
    @Expose
    var gEmail:String? = null
    @SerializedName("g_phone")
    @Expose
    var gPhone:String? = null
    @SerializedName("g_avatar")
    @Expose
    var gAvatar:String? = null
}