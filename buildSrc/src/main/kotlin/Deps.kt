package dependencies

object Deps {
    object Apk {
        const val compileSdkVersion = 29
        const val minSdkVersion = 25
        const val targetSdkVersion = 29
        const val versionCode = 1
        const val versionName = "0.1.0"
    }


    val appcompat = dependency("androidx.appcompat:appcompat", Versions.appcomat)

    val androidCore = dependency("androidx.core:core-ktx", Versions.androidCore)

    val constraintLayout = dependency("androidx.constraintlayout:constraintlayout", Versions.constraintLayout)

    val coroutines = dependency("org.jetbrains.kotlinx:kotlinx-coroutines-android", Versions.coroutine)

    val epoxy = dependency("com.airbnb.android:epoxy", Versions.epoxy)

    val kotlin = dependency("org.jetbrains.kotlin:kotlin-stdlib-jdk7", Versions.kotlin)

    val material = dependency("com.google.android.material:material", Versions.material)

    object Navigation : Group("androidx.navigation") {
        val fragment = withArtifact("navigation-fragment-ktx", Versions.navigation)
        val ui = withArtifact("navigation-ui-ktx", Versions.navigation)
    }

    val viewpager2 = dependency("androidx.viewpager2:viewpager2", Versions.viewpager2)

}

abstract class Group(val group: String) {
    fun withArtifact(artifact: String, version: String): String = "$group:$artifact:$version"
}

private fun dependency(path: String, version: String, extension: String? = null): String =
    extension?.let {
        "$path:$version@$extension"
    } ?: "$path:$version"

object Versions {
    const val androidCore = "1.3.1"
    const val appcomat = "1.2.0"
    const val constraintLayout = "1.1.3"
    const val coroutine = "1.3.8"
    const val epoxy = "3.10.0"
    const val kotlin = "1.3.70"
    const val material = "1.3.0-alpha02"
    const val navigation = "2.3.0"
    const val viewpager2 = "1.0.0"

}
