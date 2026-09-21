package com.github.lasnelus.Capybara.domain.data

enum class WeatherCondition(val raw: String) {
    Sunny("sunny"),
    SunCloud("sun_cloud"),
    Cloud("cloud"),
    Fog("fog"),
    Rain("rain"),
    Snow("snow"),
    SnowStorm("snow_storm"),
    Moon("moon")
}