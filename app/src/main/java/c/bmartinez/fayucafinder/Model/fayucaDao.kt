package c.bmartinez.fayucafinder.Model

class fayucaDao {
    private lateinit var name:String
    private lateinit var address: String
    private var latitude: Double = 0.0
    private var longitude: Double = 0.0

    init{
        this.name = name
        this.address = address
        this.longitude = longitude
        this.latitude = latitude
    }

    public fun getName(): String { return name }

    public fun getAddress(): String { return address }
}