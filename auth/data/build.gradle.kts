plugins {
    alias(libs.plugins.runlog.android.library)
    alias(libs.plugins.runlog.jvm.ktor)
}

android {
    namespace = "com.db.auth.data"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.auth.domain)
    implementation(projects.core.data)
}