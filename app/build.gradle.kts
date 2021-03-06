plugins {
    id ("com.android.application")
    kotlin ("android")

    //Kapt
    kotlin("kapt")

    //Hilt
    id ("com.google.dagger.hilt.android")

    //Navigation Safe Args
    id ("androidx.navigation.safeargs")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "com.example.kotlin1Hm2RaM"
        minSdk = 22
        targetSdk = 32
        versionCode = 1
        versionName =  "1.0"

        testInstrumentationRunner  = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility  = JavaVersion.VERSION_11
        targetCompatibility  = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    //Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")

    implementation ("androidx.core:core-ktx:1.7.0")
    implementation ("androidx.appcompat:appcompat:1.4.1")
    implementation ("com.google.android.material:material:1.5.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.3")
    implementation ("androidx.legacy:legacy-support-v4:1.0.0")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")

    // Retrofit 2
    val retrofit_version = "2.9.0"

    implementation ("com.squareup.retrofit2:retrofit:$retrofit_version")
    implementation ("com.squareup.retrofit2:converter-gson:$retrofit_version")
    implementation ("com.squareup.retrofit2:retrofit:(insert latest version)")

    // OkHttp
    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.9.3"))
    // define any required OkHttp artifacts without version
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")


    // Hilt
    implementation("com.google.dagger:hilt-android:2.41")
    kapt("com.google.dagger:hilt-android-compiler:2.41")

    // Lifecycle
    val lifecycle_version = "2.5.0-alpha04"

    //ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")

    //LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")

    //Navigation Component
    implementation("androidx.navigation:navigation-fragment-ktx:2.4.1")
    implementation("androidx.navigation:navigation-ui-ktx:2.4.1")

    //Glide
    implementation ("com.github.bumptech.glide:glide:4.13.0")

    val view_biding_property_delegate = "1.5.3"
    // To use only without reflection variants of viewBinding
    implementation ("com.github.kirich1409:viewbindingpropertydelegate-noreflection:$view_biding_property_delegate")

    //Room
    val roomVersion = "2.4.2"

    implementation("androidx.room:room-runtime:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")

    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$roomVersion")


}