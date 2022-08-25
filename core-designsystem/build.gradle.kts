plugins {
    id("spacexrockets.android.library")
    id("spacexrockets.android.library.compose")
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    lint {
        checkDependencies = true
    }
}

dependencies {
    api(libs.androidx.compose.ui)

    // Tooling support (Previews, etc.)
    debugApi(libs.androidx.compose.ui.tooling)
    api(libs.androidx.compose.ui.tooling.preview)

    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    api(libs.androidx.compose.foundation)

    // Material Design
    api(libs.androidx.compose.material)

    // Material design icons
    api(libs.androidx.compose.material.icons.core)
    api(libs.androidx.compose.material.icons.extended)
}