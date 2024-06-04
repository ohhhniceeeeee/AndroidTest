package com.example.advancedtest

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


//class Person : Serializable {
//    var name = ""
//    var age = 0
//}

@Parcelize
class Person(var name: String, var age: Int) : Parcelable //{
//    var name = ""
//    var age = 0
//
//    override fun writeToParcel(parcel: Parcel, flags: Int) {
//        parcel.writeString(name)
//        parcel.writeInt(age)
//    }
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    companion object CREATOR : Parcelable.Creator<Person> {
//        override fun createFromParcel(parcel: Parcel): Person {
//            val person = Person()
//            person.name = parcel.readString() ?: ""
//            person.age = parcel.readInt()
//            return person
//        }
//
//        override fun newArray(size: Int): Array<Person?> {
//            return arrayOfNulls(size)
//        }
//    }
//}