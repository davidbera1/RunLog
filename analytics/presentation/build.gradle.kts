plugins {
    alias(libs.plugins.runlog.android.feature.ui)
}

android {
    namespace = "com.db.analytics.presentation"
}

dependencies {
    implementation(projects.analytics.domain)
}