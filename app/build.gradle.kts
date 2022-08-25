plugins {
    id("spacexrockets.android.application")
    id("spacexrockets.android.application.compose")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {

    defaultConfig {
        applicationId = "com.mhd.spacexrockets"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        val release by getting{
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-rules.pro"
            )
        }
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(project(":core-network"))
    implementation(project(":core-designsystem"))

    //androidx
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifeCycle.runtimeKtx)
    implementation(libs.androidx.activity.compose)

    //Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}