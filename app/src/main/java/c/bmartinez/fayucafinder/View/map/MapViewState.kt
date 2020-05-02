package c.bmartinez.fayucafinder.View.map

import androidx.lifecycle.LiveData
import c.bmartinez.fayucafinder.Base.ViewState
import c.bmartinez.fayucafinder.Model.Trucks

class MapViewState (
    var locationUpdateState:Boolean = false,
    var trucksViewModelLiveDate: LiveData<ArrayList<Trucks>>? = null
): ViewState()