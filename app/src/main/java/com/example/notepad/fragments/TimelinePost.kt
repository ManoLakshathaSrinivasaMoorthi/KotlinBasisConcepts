package com.example.notepad.fragments

class TimelinePost {
    private var profilePic: String? = null
    private var name: String? = null
    private var imageUrl: String? = null
    private var likes = 0
    private var caption: String? = null
    private var date: String? = null

    fun TimelinePost(
        profilePic: String?,
        name: String?,
        imageUrl: String?,
        likes: Int,
        caption: String?,
        date: String?
    ) {
        this.profilePic = profilePic
        this.name = name
        this.imageUrl = imageUrl
        this.likes = likes
        this.caption = caption
        this.date = date
    }


    fun getProfilePic(): String? {
        return profilePic
    }

    fun setProfilePic(profilePic: String?) {
        this.profilePic = profilePic
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun getImageUrl(): String? {
        return imageUrl
    }

    fun setImageUrl(imageUrl: String?) {
        this.imageUrl = imageUrl
    }

    fun getLikes(): Int {
        return likes
    }

    fun setLikes(likes: Int) {
        this.likes = likes
    }

    fun getCaption(): String? {
        return caption
    }

    fun setCaption(caption: String?) {
        this.caption = caption
    }

    fun getDate(): String? {
        return date
    }

    fun setDate(date: String?) {
        this.date = date
    }
}
