package com.example.josycom.marsrealestate.detail

import android.app.Application
import androidx.lifecycle.*
import com.example.josycom.marsrealestate.network.MarsProperty
import com.example.josycom.marsrealestate.R

/**
 * The [ViewModel] that is associated with the [DetailFragment].
 */
class DetailViewModel(marsProperty: MarsProperty, app: Application) : AndroidViewModel(app) {

    private val _selectedProperty = MutableLiveData<MarsProperty>()

    val selectedProperty: LiveData<MarsProperty>
        get() = _selectedProperty

    val displayPropertyPrice = Transformations.map(selectedProperty) {
        app.applicationContext.getString(
                when (it.isRental) {
                    true -> R.string.display_price_monthly_rental
                    false -> R.string.display_price
                }, it.price)
    }

    val displayPropertyType = Transformations.map(selectedProperty) {
        app.applicationContext.getString(R.string.display_type,
                app.applicationContext.getString(
                        when(it.isRental) {
                            true -> R.string.type_rent
                            false -> R.string.type_sale
                        }))
    }


    init {
        _selectedProperty.value = marsProperty
    }
}
