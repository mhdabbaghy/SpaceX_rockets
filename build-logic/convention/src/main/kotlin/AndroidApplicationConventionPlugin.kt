import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.mhd.spacexrockets.kotlinOptions
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
                apply(libs.findPlugin("android.application").get().get().pluginId)
                apply(libs.findPlugin("kotlin.android").get().get().pluginId)
            }

            extensions.configure<BaseAppModuleExtension> {
                compileSdk = 32

                defaultConfig {
                    minSdk = 21
                    targetSdk = 32
                }

                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_1_8
                    targetCompatibility = JavaVersion.VERSION_1_8
                }

                kotlinOptions {
                    // Set JVM target to 1.8
                    jvmTarget = JavaVersion.VERSION_1_8.toString()
                }
            }
        }
    }

}