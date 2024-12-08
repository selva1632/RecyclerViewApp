package com.selva.recyclerviewapp

data class FieldData(
    val title: String,
    val subTitle: String? = null,
) {
    companion object {
        fun getEducationField() = listOf(
            FieldData("B.Tech", "National Institute of Technology, Puducherry"),
            FieldData("MBA", "London School Business, London"),
            FieldData("Add")
        )

        fun getExperienceField() = listOf(
            FieldData("Data Analyst", "Virtusa, Hyderabad"),
            FieldData("Software Engineer", "Samsung R&D Institute, Noida"),
            FieldData("Add")
        )

        fun getSkillField() = listOf(
            FieldData("Kotlin"),
            FieldData("Java"),
            FieldData("Python"),
            FieldData("Cpp"),
            FieldData("SQL"),
            FieldData("SQL"),
            FieldData("Add"),
        )

        fun getToolsField() = listOf(
            FieldData("JetPack Compose"),
            FieldData("Room DB"),
            FieldData("Hilt"),
            FieldData("JUnit"),
            FieldData("Android Studio"),
            FieldData("Gradle"),
            FieldData("Jira"),
            FieldData("GitHub"),
            FieldData("Add")
        )

        fun getArchitectureField() = listOf(
            FieldData("MVVM"),
            FieldData("MVI"),
            FieldData("Factory"),
            FieldData("Builder"),
            FieldData("Strategy"),
            FieldData("Singleton")
        )

        fun getHobbyField() = listOf(
            FieldData("Coding"),
            FieldData("Cricket"),
            FieldData("VolleyBall")
        )
    }
}