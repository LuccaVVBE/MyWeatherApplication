//[app](../../index.md)/[com.example.myweatherapplication.data](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [AppContainer](-app-container/index.md) | [androidJvm]<br>interface [AppContainer](-app-container/index.md)<br>Interface voor het beheren van afhankelijkheden in de applicatie. |
| [CachingWeatherRepository](-caching-weather-repository/index.md) | [androidJvm]<br>class [CachingWeatherRepository](-caching-weather-repository/index.md)(locatieInfoDao: [LocatieInfoDao](../com.example.myweatherapplication.data.database/-locatie-info-dao/index.md), weatherApiService: [WeatherApiService](../com.example.myweatherapplication.network/-weather-api-service/index.md)) : [WeatherRepository](-weather-repository/index.md)<br>Implementatie van [WeatherRepository](-weather-repository/index.md) die gebruikmaakt van een lokale cache voor het opslaan van weerinformatie. |
| [DefaultAppContainer](-default-app-container/index.md) | [androidJvm]<br>class [DefaultAppContainer](-default-app-container/index.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) : [AppContainer](-app-container/index.md)<br>Standaard implementatie van [AppContainer](-app-container/index.md) die verantwoordelijk is voor het beheren van afhankelijkheden. |
| [WeatherRepository](-weather-repository/index.md) | [androidJvm]<br>interface [WeatherRepository](-weather-repository/index.md)<br>Repository-interface voor het ophalen en beheren van weergerelateerde locatie-informatie. |
