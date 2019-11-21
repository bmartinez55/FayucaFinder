package c.bmartinez.fayucafinder.Model.Database

class fayucaDao {
    private lateinit var name: String
    private lateinit var address: String
    private var latitude: Double = 0.0
    private var longitude: Double = 0.0
    private var distance: Double = 0.0

    init{
        this.name = name
        this.address = address
        this.longitude = longitude
        this.latitude = latitude
        this.distance = distance
    }

    fun getName(): String { return name }

    fun getAddress(): String { return address }

    fun getLatitude(): Double {return latitude }

    fun getLongitude(): Double { return longitude }

    fun getDistance(): Double { return distance }

}