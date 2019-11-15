package c.bmartinez.fayucafinder.View.List

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import c.bmartinez.fayucafinder.Model.fayucaDao

class FayucaListAdapter: RecyclerView.Adapter<FayucaListAdapter.FayucaViewHolder> {
    private val fayucaList: ArrayList<fayucaDao>
    private lateinit var mContext: Context
}