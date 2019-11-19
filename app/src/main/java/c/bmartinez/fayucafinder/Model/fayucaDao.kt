package c.bmartinez.fayucafinder.Model

class fayucaDao {
    private lateinit var name: String
    private lateinit var address: String
    private var latitude: Double = 0.0
    private var longitude: Double = 0.0

    init{
        this.name = name
        this.address = address
        this.longitude = longitude
        this.latitude = latitude
    }

    fun getName(): String { return name }

    fun getAddress(): String { return address }

    fun getLatitude(): Double {return latitude }

    fun getLongitude(): Double { return longitude }

}