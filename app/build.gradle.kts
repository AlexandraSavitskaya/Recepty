//Ссылки на зависимости, которые используются только в модуле app. Название пакета-проекта, минимальная версия sdk,
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}
//Настройки приложения
android {
    namespace = "com.example.recepty"
    compileSdk = 35

    //Включение библиотеки viewBinding
    buildFeatures {
        viewBinding = true
    }

    defaultConfig {
        applicationId = "com.example.recepty"
        //Минимальная версия Андроид, на котором будет работать приложение
        minSdk = 23
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}


//Ссылки на используемые библиотеки
dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    //implementation("androidx.fragment:fragment:1.8.8")
}