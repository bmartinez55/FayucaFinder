package c.bmartinez.fayucafinder.View.List

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import c.bmartinez.fayucafinder.Model.fayucaDao
import c.bmartinez.fayucafinder.R
import kotlinx.android.synthetic.main.fayuca_list_item.view.*
import kotlinx.android.synthetic.main.fragment_list.*

class FayucaListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private var mFayucaList: ArrayList<fayucaDao>
    private var mContext: Context

    constructor(context: Context, fayucas: ArrayList<fayucaDao>){
        mContext = context
        this.mFayucaList = fayucas
    }

    override  fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return RecyclerView.ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.fayuca_list_item,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       holder?.fayucaNameText?.text = mFayucaList.get(position)
    }

    override fun getItemCount(): Int {
        return mFayucaList.size
    }
}

class FayucaViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val vehicleName = view.fayucaNameText
    val vehicleAddress = view.fayucaAddressText
    val vehicleDistance = view.distanceTextView
}