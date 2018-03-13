package gianhadat.online.thuy.manager.ext

import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by thuythu on 07/03/2018.
 */
class RxUtil{
    companion object {

        fun <T> applyMain(): (Observable<T>) -> Observable<T> {
            return { observable: Observable<T> ->

                observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
            }
        }


        fun <T> applyHandlerStartFinish(src: Observable<T>, start: Runnable?, finish: Runnable?): Observable<T> {
            return Observable.using<T, Any>(
                    {
                        start?.run()
                    },
                    { nothing ->
                        src
                    })
            { resource ->
                finish?.run()
            }

        }

    }
}