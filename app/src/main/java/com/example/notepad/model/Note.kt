package com.example.notepad.model

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

class Note() :Parcelable{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private var id = 0

    @ColumnInfo(name = "title")
    private var title: String? = null

    @ColumnInfo(name = "description")
    private var description: String? = null

    @ColumnInfo(name = "priority")
    private var priority = 0

    fun Note(title: String?, description: String?, priority: Int) {
        this.title = title
        this.description = description
        this.priority = priority
    }

    fun getId(): Int {
        return id
    }

    fun getTitle(): String? {
        return title
    }

    fun getDescription(): String? {
        return description
    }

    fun getPriority(): Int {
        return priority
    }

    fun setId(id: Int) {
        this.id = id
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(id)
        dest.writeString(title)
        dest.writeString(description)
        dest.writeInt(priority)
    }

    protected fun Note(`in`: Parcel) {
        id = `in`.readInt()
        title = `in`.readString()
        description = `in`.readString()
        priority = `in`.readInt()
    }



    constructor(parcel: Parcel) : this() {
        id = parcel.readInt()
        title = parcel.readString()
        description = parcel.readString()
        priority = parcel.readInt()
    }

    companion object CREATOR : Creator<Note> {
        override fun createFromParcel(parcel: Parcel): Note {
            return Note(parcel)
        }

        override fun newArray(size: Int): Array<Note?> {
            return arrayOfNulls(size)
        }
    }
}