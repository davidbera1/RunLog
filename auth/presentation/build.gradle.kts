plugins {
    alias(libs.plugins.runlog.android.feature.ui)
}

android {
    namespace = "com.db.auth.presentation"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.auth.domain)
}