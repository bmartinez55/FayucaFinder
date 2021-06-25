package c.bmartinez.fayucafinder.view.List

//class FayucaListAdapter(context: Context, fayucas: ArrayList<Trucks>) : RecyclerView.Adapter<ViewHolder>() {
//    private var mFayucaList: ArrayList<Trucks> = fayucas
//    private var mContext: Context = context
//
//    override  fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val rootView: View = LayoutInflater.from(mContext).inflate(R.layout.fayuca_list_item,parent,false)
//        return RecyclerViewViewHolder(rootView)
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//       val trucks: Trucks = mFayucaList.get(position)
//        val viewHolder: RecyclerViewViewHolder = holder as RecyclerViewViewHolder
//
//        viewHolder.textViewName.setText(trucks.name)
//
//    }
//
//    override fun getItemCount(): Int {
//        return mFayucaList.size
//    }
//
//    class RecyclerViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        lateinit var imageView: ImageView
//        lateinit var textViewName: TextView
//
//        fun RecyclerViewViewHolder(itemView: View){
//            imageView = itemView.findViewById(R.id.imageView)
//            textViewName = itemView.findViewById(R.id.truck_title)
//        }
//
//    }
//}
