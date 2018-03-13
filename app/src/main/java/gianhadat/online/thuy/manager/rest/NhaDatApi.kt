package gianhadat.online.thuy.manager.rest

import gianhadat.online.thuy.BuildConfig
import gianhadat.online.thuy.module.Login
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import rx.Observable

/**
 * Created by thuythu on 28/02/2018.
 */
interface NhaDatApi{
    companion object {
        val DOMAIN = BuildConfig.DOMAIN
    }

    @FormUrlEncoded
    @POST(RestEndPoint.LOGIN)
    //fun login(@HeaderMap header: Map<String, String>, @Part("email") email: RequestBody, @Part("password") password: RequestBody): Observable<NhaDatResponse<Login>>
    //fun login(@HeaderMap header: Map<String, String>, @Body userRequest: UserRequest): Observable<NhaDatResponse<Lin>>
    fun login(@Field("email") email: String, @Field("password") password: String): Observable<NhaDatResponse<Login>>
}