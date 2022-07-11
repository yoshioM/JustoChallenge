package com.yoshio.challenge.domain.model

import com.yoshio.challenge.data.database.entities.UsersEntity
import com.yoshio.challenge.data.network.model.*

data class UserItem(
    var gender: String,
    var name: NameItem,
    var location: LocationItem,
    var email: String,
    var login: LoginItem,
    var dob: DobItem,
    var registered: RegisteredItem,
    var phone: String,
    var cell: String,
    var id: IdItem,
    var picture: PictureItem,
    var nat: String
)

fun UserModel.toDomain() = UserItem(
    gender = results[0].gender,
    name = NameItem(
        title = results[0].name.title,
        first = results[0].name.first,
        last = results[0].name.last
    ),
    location = LocationItem(
        street = StreetItem(
            number = results[0].location.street.number,
            name = results[0].location.street.name
        ),
        city = results[0].location.city,
        results[0].location.state,
        country = results[0].location.country,
        postcode = results[0].location.postcode,
        CoordinatesItem(
            latitude = results[0].location.coordinates.latitude,
            longitude = results[0].location.coordinates.longitude
        ),
        timezone = TimezoneItem(
            offset = results[0].location.timezone.offset,
            description = results[0].location.timezone.description
        )
    ),
    email = results[0].email,
    login = LoginItem(
        uuid = results[0].login.uuid,
        username = results[0].login.username,
        password = results[0].login.password,
        salt = results[0].login.salt,
        md5 = results[0].login.md5,
        sha1 = results[0].login.sha1,
        sha256 = results[0].login.sha256
    ),
    dob = DobItem(
        date = results[0].dob.date,
        age = results[0].dob.age
    ),
    registered = RegisteredItem(
        date = results[0].registered.date,
        age = results[0].registered.age
    ),
    phone = results[0].phone,
    cell = results[0].cell,
    id = IdItem(
        name = results[0].id.name ?: "",
        value = results[0].id.value ?: ""
    ),
    picture = PictureItem(
        large = results[0].picture.large,
        medium = results[0].picture.medium,
        thumbnail = results[0].picture.thumbnail
    ),
    nat = results[0].nat
)

fun UsersEntity.toDomain() = UserItem(
    gender = "",
    name = NameItem(
        title = title,
        first = firstName,
        last = lastName
    ),
    location = LocationItem(
        street = StreetItem(
            number = 0,
            name = street
        ),
        city = city,
        state = state,
        country = country,
        postcode = postcode,
        CoordinatesItem(
            latitude = latitude,
            longitude = longitude
        ),
        timezone = TimezoneItem(
            offset = "",
            description = ""
        )
    ),
    email = email,
    login = LoginItem(
        uuid = "id_${id}",
        username = "",
        password = "",
        salt = "",
        md5 = "",
        sha1 = "",
        sha256 = ""
    ),
    dob = DobItem(
        date = birthday,
        age = age
    ),
    registered = RegisteredItem(
        date = "",
        age = 0
    ),
    phone = phone,
    cell = cell,
    id = IdItem(
        name = "",
        value = ""
    ),
    picture = PictureItem(
        large = picture,
        medium = "",
        thumbnail = ""
    ),
    nat = ""
)