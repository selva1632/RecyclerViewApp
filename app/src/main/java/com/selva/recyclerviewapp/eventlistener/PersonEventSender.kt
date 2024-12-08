package com.selva.recyclerviewapp.eventlistener

fun interface PersonEventSender {
    fun sendEvent(event: PersonEvent)
}