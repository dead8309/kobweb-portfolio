package org.example.portfolio

object Constants {
    const val LOREM =
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    val projects = listOf(
        Project(
            title = "Business Startup",
            description = "Design & Development",
            imageUrl = Assets.ProjectImg1
        ),
        Project(
            title = "Business Startup",
            description = "Design & Development",
            imageUrl = Assets.ProjectImg2
        ),
        Project(
            title = "Business Startup",
            description = "Design & Development",
            imageUrl = Assets.ProjectImg3
        ),
        Project(
            title = "Business Startup",
            description = "Design & Development",
            imageUrl = Assets.ProjectImg1
        ),
        Project(
            title = "Business Startup",
            description = "Design & Development",
            imageUrl = Assets.ProjectImg2
        ),
        Project(
            title = "Business Startup",
            description = "Design & Development",
            imageUrl = Assets.ProjectImg3
        )
    )
}

data class Project(
    val title: String,
    val description: String,
    val imageUrl: String
)