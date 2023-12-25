//[app](../../../index.md)/[com.example.myweatherapplication.data](../index.md)/[WeatherRepository](index.md)/[refresh](refresh.md)

# refresh

[androidJvm]\
abstract suspend fun [refresh](refresh.md)(loc: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

Vernieuwt de weerinformatie voor de opgegeven locatie en retourneert de bijgewerkte locatienaam.

#### Return

De bijgewerkte locatienaam.

#### Parameters

androidJvm

| | |
|---|---|
| loc | De naam van de locatie waarvan de weerinformatie moet worden vernieuwd. |

#### Throws

| | |
|---|---|
| [Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html) | Als er een fout optreedt bij het vernieuwen van de weerinformatie. |
