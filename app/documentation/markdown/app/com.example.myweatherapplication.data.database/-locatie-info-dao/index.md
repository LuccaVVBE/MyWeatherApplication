//[app](../../../index.md)/[com.example.myweatherapplication.data.database](../index.md)/[LocatieInfoDao](index.md)

# LocatieInfoDao

[androidJvm]\
interface [LocatieInfoDao](index.md)

Data Access Object (DAO) voor het uitvoeren van databasebewerkingen met betrekking tot locatie-informatie.

## Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | [androidJvm]<br>abstract suspend fun [delete](delete.md)(locatieInfo: [dbLocatieInfo](../db-locatie-info/index.md))<br>Verwijdert de opgegeven locatie-informatie uit de database. |
| [getAllItems](get-all-items.md) | [androidJvm]<br>abstract fun [getAllItems](get-all-items.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[dbLocatieInfo](../db-locatie-info/index.md)&gt;&gt;<br>Haalt alle locatie-informatie op uit de database, gesorteerd op locatienaam in oplopende volgorde. |
| [getItem](get-item.md) | [androidJvm]<br>abstract fun [getItem](get-item.md)(realLocation: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[dbLocatieInfo](../db-locatie-info/index.md)&gt;<br>Haalt locatie-informatie op uit de database op basis van de opgegeven locatienaam. |
| [insert](insert.md) | [androidJvm]<br>abstract suspend fun [insert](insert.md)(locatieInfo: [dbLocatieInfo](../db-locatie-info/index.md))<br>Voegt locatie-informatie toe aan de database of vervangt deze als deze al bestaat. |
| [update](update.md) | [androidJvm]<br>abstract suspend fun [update](update.md)(locatieInfo: [dbLocatieInfo](../db-locatie-info/index.md))<br>Werkt de bestaande locatie-informatie in de database bij. |
