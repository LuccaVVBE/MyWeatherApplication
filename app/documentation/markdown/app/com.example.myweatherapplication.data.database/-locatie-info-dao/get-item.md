//[app](../../../index.md)/[com.example.myweatherapplication.data.database](../index.md)/[LocatieInfoDao](index.md)/[getItem](get-item.md)

# getItem

[androidJvm]\
abstract fun [getItem](get-item.md)(realLocation: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[dbLocatieInfo](../db-locatie-info/index.md)&gt;

Haalt locatie-informatie op uit de database op basis van de opgegeven locatienaam.

#### Return

Een Flow van [dbLocatieInfo](../db-locatie-info/index.md) die overeenkomt met de opgegeven locatienaam.

#### Parameters

androidJvm

| | |
|---|---|
| realLocation | De naam van de locatie waarvan de informatie moet worden opgehaald. |
