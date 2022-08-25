plugins {
    `kotlin-dsl`
}

group = "com.mhd.spacexrockets.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "spacexrockets.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("androidApplicationCompose") {
            id = "spacexrockets.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }

        register("androidLibrary") {
            id = "spacexrockets.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        register("androidLibraryCompose") {
            id = "spacexrockets.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
    }
}
