package gianhadat.online.thuy.manager.rest

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by thuythu on 28/02/2018.
 */
class NhaDatResponse<T> {

    @SerializedName("error")
    @Expose
    var errorId: String? = null
    @SerializedName("data")
    @Expose
    var data: T? = null
    @SerializedName("message")
    @Expose
    var message: String? = null
}