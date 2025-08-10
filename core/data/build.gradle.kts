plugins {
    alias(libs.plugins.runlog.android.library)
    alias(libs.plugins.runlog.jvm.ktor)
}

android {
    namespace = "com.db.core.data"
}

dependencies {
    implementation(libs.timber)
    implementation(libs.bundles.koin)

    implementation(projects.core.domain)
    implementation(projects.core.database)
}