package com.selva.recyclerviewapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.selva.recyclerviewapp.data.PersonViewItem
import com.selva.recyclerviewapp.eventlistener.PersonEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PersonViewModel(
    private val model: PersonModel
) : ViewModel() {

    init {
        model.init()
    }

    val personItemLiveDate: LiveData<List<PersonViewItem>>
        get() = model.personItemLiveData

    fun update() {
        viewModelScope.launch(Dispatchers.IO) {
            delay(5_000L)
            model.update()
        }
    }

    fun handleEvent(event: PersonEvent) {
        when (event) {
            is PersonEvent.AddField -> {}
        }
    }
}