package c.bmartinez.fayucafinder.View.List

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.BinderThread
import androidx.recyclerview.widget.RecyclerView
import c.bmartinez.fayucafinder.Model.fayucaDao
import c.bmartinez.fayucafinder.R

class FayucaListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private var mFayucaList: ArrayList<fayucaDao>
    private var mContext: Context

    constructor(context: Context, fayucas: ArrayList<fayucaDao>){
        mContext = context
        this.mFayucaList = fayucas
    }

    override  fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        return mFayucaList.size
    }
}

class FayucaViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    @BinderThread
}