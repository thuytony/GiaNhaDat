package gianhadat.online.thuy.module

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by thuythu on 07/03/2018.
 */
class Login: Serializable{
    @SerializedName("token")
    @Expose
    var token:String? = null
    @SerializedName("user")
    @Expose
    var user:User? = null
}