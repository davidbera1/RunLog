plugins {
    alias(libs.plugins.runlog.android.library)
    alias(libs.plugins.runlog.android.room)
}

android {
    namespace = "com.db.core.database"
}

dependencies {
    implementation(libs.org.mongodb.bson)
    implementation(libs.bundles.koin)

    implementation(projects.core.domain)
}