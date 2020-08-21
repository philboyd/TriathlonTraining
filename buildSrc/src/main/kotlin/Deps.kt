package dependencies

object Deps {
    object Apk {
        const val compileSdkVersion = 29
        const val minSdkVersion = 25
        const val targetSdkVersion = 29
        const val versionCode = 1
        const val versionName = "0.1.0"
    }

    object Core {
        val data = ":core-data"
        val domain = ":core-domain"
        val ui = ":core-ui"
    }

    object Workout {
        val ui = ":workout-ui"
    }


    val appcompat = dependency("androidx.appcompat:appcompat", Versions.appcomat)

    val androidCore = dependency("androidx.core:core-ktx", Versions.androidCore)

    val constraintLayout = dependency("androidx.constraintlayout:constraintlayout", Versions.constraintLayout)

    object Coroutines : Group("org.jetbrains.kotlinx") {
        val android = withArtifact("kotlinx-coroutines-android", Versions.coroutines)
        val test = withArtifact("kotlinx-coroutines-test", Versions.coroutines)
    }

    object DaggerHilt : Group("com.google.dagger") {
        val android = withArtifact("hilt-android", Versions.dagger)
        val compiler = withArtifact("hilt-android-compiler", Versions.dagger)
        val plugin = withArtifact("hilt-android-gradle-plugin", Versions.dagger)
        val test = withArtifact("hilt-android-testing", Versions.dagger)
    }

    val epoxy = dependency("com.airbnb.android:epoxy", Versions.epoxy)

    val kotlin = dependency("org.jetbrains.kotlin:kotlin-stdlib-jdk7", Versions.kotlin)

    val material = dependency("com.google.android.material:material", Versions.material)

    object Navigation : Group("androidx.navigation") {
        val fragment = withArtifact("navigation-fragment-ktx", Versions.navigation)
        val ui = withArtifact("navigation-ui-ktx", Versions.navigation)
    }

    object Test {
        val runner = "testInstrumentationRunner Deps.Test.runner"

        val core = dependency("androidx.test:core", Versions.testCore)
        val testExt = dependency("androidx.test.ext:junit", Versions.testExt)
        val junit = dependency("junit:junit", Versions.junit)
        val kotest = dependency("io.kotest:kotest-runner-junit5-jvm", Versions.kotest)
        val kotestAssertion = dependency("io.kotest:kotest-assertions-core-jvm", Versions.kotest)
        val kotestProperty = dependency("io.kotest:kotest-property-jvm", Versions.kotest)
        val mockk = dependency("io.mockk:mockk", Versions.mockk)
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
    const val coroutines = "1.3.8"
    const val dagger = "2.28.3-alpha"
    const val epoxy = "3.10.0"
    const val junit = "4.13"
    const val kotest = "4.0.5"
    const val kotlin = "1.3.70"
    const val material = "1.3.0-alpha02"
    const val mockk = "1.9.3"
    const val navigation = "2.3.0"
    const val testCore = "1.2.0"
    const val testExt = "1.1.1"
    const val viewpager2 = "1.0.0"

}
