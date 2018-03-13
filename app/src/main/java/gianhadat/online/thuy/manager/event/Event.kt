package gianhadat.online.thuy.manager.event

import org.greenrobot.eventbus.EventBus

/**
 * Created by thuythu on 28/02/2018.
 */
class Event{
    companion object {
        fun postEvent(eventMessage: EventMessage){
            EventBus.getDefault().post(eventMessage)
        }
    }
}