package gianhadat.online.thuy.manager.rest

import gianhadat.online.thuy.BuildConfig
import java.util.*

/**
 * Created by thuythu on 07/03/2018.
 */
class RestParams{
    constructor()

    fun defaultHeader(): Map<String, String> {
        val header = HashMap<String, String>()
        header["Content-Type"] = "application/json"
        header["api-version"] = BuildConfig.API_VERSION
        header["Accept"] = "application/json"
        header["charset"] = "UTF-8"

        return header
    }
}