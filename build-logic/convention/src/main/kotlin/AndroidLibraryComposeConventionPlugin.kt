import com.android.build.gradle.LibraryExtension
import com.mhd.spacexrockets.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            pluginManager.apply(libs.findPlugin("android.library").get().get().pluginId)
            val extension = extensions.getByType<LibraryExtension>()
            configureAndroidCompose(extension)
        }
    }

}