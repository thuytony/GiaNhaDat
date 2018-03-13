package gianhadat.online.thuy.module

/**
 * Created by thuythu on 01/03/2018.
 */
class ItemHome {
    private var image: Int? = null
    private var title: String? = null

    fun setImage(image: Int){
        this.image = image
    }
    fun getImage(): Int{
        return image!!
    }

    fun setTitle(title: String){
        this.title = title
    }
    fun getTitle(): String{
        return title!!
    }
}