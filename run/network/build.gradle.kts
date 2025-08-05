plugins {
    alias(libs.plugins.runlog.android.library)
    alias(libs.plugins.runlog.jvm.ktor)
}

android {
    namespace = "com.db.run.network"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.data)
}