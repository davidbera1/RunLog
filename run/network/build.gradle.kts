plugins {
    alias(libs.plugins.runlog.android.library)
}

android {
    namespace = "com.db.run.network"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.data)
}