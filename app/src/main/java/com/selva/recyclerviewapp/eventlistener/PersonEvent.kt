package com.selva.recyclerviewapp.eventlistener

sealed class PersonEvent {
    data object AddField: PersonEvent()
}