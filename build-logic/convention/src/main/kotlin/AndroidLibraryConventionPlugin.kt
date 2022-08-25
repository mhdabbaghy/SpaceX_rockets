import com.android.build.gradle.LibraryExtension
import com.mhd.spacexrockets.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
                apply(libs.findPlugin("android.library").get().get().pluginId)
                apply(libs.findPlugin("kotlin.android").get().get().pluginId)
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = 32
            }
        }
    }

}
