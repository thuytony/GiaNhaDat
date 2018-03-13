package gianhadat.online.thuy.application

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import gianhadat.online.thuy.manager.rest.RestBuilder

/**
 * Created by thuythu on 28/02/2018.
 */
class NhaDatApp : Application() {
    var context: Context? = null
        get() = context
    protected var gson: Gson? = null




    companion object {

        var instance: NhaDatApp? = null

        fun buildInstance(): NhaDatApp {
            return instance!!
        }

    }

    override fun onCreate() {

        super.onCreate()
        context = applicationContext
        instance = this
        gson = RestBuilder.provideGson()
        //Fabric.with(this, Crashlytics())
    }


    fun gson(): Gson {
        return instance?.gson!!
    }

}