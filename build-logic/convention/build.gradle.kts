plugins {
    `kotlin-dsl`
}

group = "com.mhd.spacexrockets.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "spacexrocekts.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("androidApplicationCompose") {
            id = "spacexrocekts.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
    }
}
