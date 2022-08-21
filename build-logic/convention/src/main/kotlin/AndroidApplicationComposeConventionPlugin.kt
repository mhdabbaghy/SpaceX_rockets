import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.mhd.spacexrockets.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            pluginManager.apply("com.android.application")
            val extension = extensions.getByType<BaseAppModuleExtension>()
            configureAndroidCompose(extension)
        }
    }

}