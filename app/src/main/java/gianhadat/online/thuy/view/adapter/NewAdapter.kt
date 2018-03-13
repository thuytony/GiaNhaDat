package gianhadat.online.thuy.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gianhadat.online.thuy.R
import gianhadat.online.thuy.module.New

/**
 * Created by thuythu on 12/03/2018.
 */
class NewAdapter: RecyclerView.Adapter<NewAdapter.NewHolder>{

    private lateinit var mContext: Context
    private lateinit var data: MutableList<New>
    private lateinit var listener: OnClickItemNew

    constructor(context: Context, data: MutableList<New>){
        this.data = data
        this.mContext = context
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): NewHolder {
        val v = LayoutInflater.from(parent!!.context).inflate(R.layout.item_new, null)
        return NewHolder(v)
    }

    override fun onBindViewHolder(holder: NewHolder, position: Int) {
        //val new = data[position]
        //holder.bind(new, position)
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return 10
    }

    inner class NewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        /*fun bind(new: New, position: Int){
            itemView.setOnClickListener {
                listener.let {
                    listener.onClickItem(position)
                }
            }
        }*/
        fun bind(position: Int){
            itemView.setOnClickListener {
                listener.let {
                    listener.onClickItem(position)
                }
            }
        }
    }

    interface OnClickItemNew{
        fun onClickItem(position: Int)
    }

    fun setOnClickItemNew(listener: OnClickItemNew){
        this.listener = listener
    }
}