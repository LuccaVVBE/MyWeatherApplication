//[app](../../index.md)/[com.example.myweatherapplication.data.database](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [dbLocatieInfo](db-locatie-info/index.md) | [androidJvm]<br>data class [dbLocatieInfo](db-locatie-info/index.md)(val placeName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val temp: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0, val feelsLike: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0, val icon: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val windSpeed: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0, val windDirection: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, val pressure: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0, val humidity: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, val visibility: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0, val uv: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0)<br>Representeert een dataklasse voor het opslaan van locatiegerelateerde informatie in de lokale Room-database. |
| [LocatieInfoDao](-locatie-info-dao/index.md) | [androidJvm]<br>interface [LocatieInfoDao](-locatie-info-dao/index.md)<br>Data Access Object (DAO) voor het uitvoeren van databasebewerkingen met betrekking tot locatie-informatie. |
| [LocatieInfoDb](-locatie-info-db/index.md) | [androidJvm]<br>abstract class [LocatieInfoDb](-locatie-info-db/index.md) : [RoomDatabase](https://developer.android.com/reference/kotlin/androidx/room/RoomDatabase.html)<br>Databaseklasse voor het beheren van de lokale Room-database met betrekking tot locatie-informatie. |

## Functions

| Name | Summary |
|---|---|
| [asDbWeatherLocation](as-db-weather-location.md) | [androidJvm]<br>fun [LocatieInfo](../com.example.myweatherapplication.ui.model/-locatie-info/index.md).[asDbWeatherLocation](as-db-weather-location.md)(): [dbLocatieInfo](db-locatie-info/index.md)<br>Extensiefunctie om een [LocatieInfo](../com.example.myweatherapplication.ui.model/-locatie-info/index.md)-object om te zetten naar een [dbLocatieInfo](db-locatie-info/index.md)-object. |
| [asDomainLocatieInfo](as-domain-locatie-info.md) | [androidJvm]<br>fun [dbLocatieInfo](db-locatie-info/index.md).[asDomainLocatieInfo](as-domain-locatie-info.md)(): [LocatieInfo](../com.example.myweatherapplication.ui.model/-locatie-info/index.md)<br>Extensiefunctie om een [dbLocatieInfo](db-locatie-info/index.md)-object om te zetten naar een [LocatieInfo](../com.example.myweatherapplication.ui.model/-locatie-info/index.md)-object. |
| [asDomainLocatieInfoList](as-domain-locatie-info-list.md) | [androidJvm]<br>fun [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[dbLocatieInfo](db-locatie-info/index.md)&gt;.[asDomainLocatieInfoList](as-domain-locatie-info-list.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[LocatieInfo](../com.example.myweatherapplication.ui.model/-locatie-info/index.md)&gt;<br>Extensiefunctie om een lijst van [dbLocatieInfo](db-locatie-info/index.md)-objecten om te zetten naar een lijst van [LocatieInfo](../com.example.myweatherapplication.ui.model/-locatie-info/index.md)-objecten. |
