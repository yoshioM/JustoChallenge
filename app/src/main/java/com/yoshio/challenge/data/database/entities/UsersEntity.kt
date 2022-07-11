package com.yoshio.challenge.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yoshio.challenge.data.network.model.StreetModel
import com.yoshio.challenge.domain.model.UserItem

@Entity(tableName = "user_tbl")
data class UsersEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "firstName")
    val firstName: String,
    @ColumnInfo(name = "lastName")
    val lastName: String,
    @ColumnInfo(name = "birthday")
    val birthday: String,
    @ColumnInfo(name = "age")
    val age: Int,
    @ColumnInfo(name = "phone")
    val phone: String,
    @ColumnInfo(name = "cell")
    val cell: String,
    @ColumnInfo(name = "email")
    val email: String,
    @ColumnInfo(name = "picture")
    val picture: String,

    @ColumnInfo(name = "street")
    val street: String,
    @ColumnInfo(name = "city")
    val city: String,
    @ColumnInfo(name = "state")
    val state: String,
    @ColumnInfo(name = "country")
    val country: String,
    @ColumnInfo(name = "postcode")
    val postcode: String,
    @ColumnInfo(name = "latitude")
    val latitude: String,
    @ColumnInfo(name = "longitude")
    val longitude: String
)

fun UserItem.toDatabase() = UsersEntity(
    title = name.title,
    firstName = name.first,
    lastName = name.last,
    birthday = dob.date,
    age = dob.age,
    phone = phone,
    cell = cell,
    email = email,
    picture = picture.large,
    street = "${location.street.name}, ${location.street.number} ",
    city = location.city,
    state = location.state,
    country = location.country,
    postcode = location.postcode,
    latitude = location.coordinates.latitude,
    longitude = location.coordinates.longitude
)