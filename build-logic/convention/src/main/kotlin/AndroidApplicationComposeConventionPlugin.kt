import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.mhd.spacexrockets.kotlinOptions
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            pluginManager.apply(libs.findPlugin("android.application").get().get().pluginId)
            extensions.getByType<BaseAppModuleExtension>().apply {
                buildFeatures {
                    compose = true
                }

                composeOptions {
                    kotlinCompilerExtensionVersion =
                        libs.findVersion("androidxComposeCompiler").get().toString()
                }

                kotlinOptions {
                    // Set JVM target to 1.8
                    jvmTarget = JavaVersion.VERSION_1_8.toString()
                }
            }
        }
    }
}