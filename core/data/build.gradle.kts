plugins {
    alias(libs.plugins.runlog.android.library)
}

android {
    namespace = "com.db.core.data"
}

dependencies {
    implementation(libs.timber)

    implementation(projects.core.domain)
    implementation(projects.core.database)
}