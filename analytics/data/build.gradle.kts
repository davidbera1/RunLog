plugins {
    alias(libs.plugins.runlog.android.library)
    alias(libs.plugins.runlog.android.room)
}

android {
    namespace = "com.db.analytics.data"
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.bundles.koin)

    implementation(projects.core.database)
    implementation(projects.core.domain)
    implementation(projects.analytics.domain)
}