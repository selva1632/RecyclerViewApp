package com.selva.recyclerviewapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.selva.recyclerviewapp.data.PersonViewItem
import com.selva.recyclerviewapp.data.PersonViewItemMaker

class PersonModel {
    private var _personItemLiveData: MutableLiveData<List<PersonViewItem>> =
        MutableLiveData(emptyList())

    val personItemLiveData: LiveData<List<PersonViewItem>>
        get() = _personItemLiveData

    private val itemMaker = PersonViewItemMaker()
    private val personItem = mutableListOf<PersonViewItem>()

    fun init() {
        personItem.apply {
            add(
                itemMaker.makeProfile(
                    name = "Selva Bharathy",
                    iconId = R.drawable.icon_stroke_background,
                    contentDescription = R.string.content_description_name
                )
            )
            add(itemMaker.makeTitle(R.string.title_education))
            addAll(itemMaker.makeField(FieldData.getEducationField()))
            add(itemMaker.makeTitle(R.string.title_experience))
            addAll(itemMaker.makeField(FieldData.getExperienceField()))
            add(itemMaker.makeTitle(R.string.title_skill))
            addAll(itemMaker.makeField(FieldData.getSkillField()))
            add(itemMaker.makeTitle(R.string.title_tool))
            addAll(itemMaker.makeField(FieldData.getToolsField()))
        }
        _personItemLiveData.value = personItem
    }

    fun update() {
        personItem.add(itemMaker.makeTitle(R.string.title_architecture))
        personItem.addAll(itemMaker.makeField(FieldData.getArchitectureField()))
        personItem.add(itemMaker.makeTitle(R.string.title_hobby))
        personItem.addAll(itemMaker.makeField(FieldData.getHobbyField()))
        _personItemLiveData.postValue(personItem)
    }
}