package com.riogonzales.bottomnavigation

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.riogonzales.bottomnavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi binding untuk ActivityMain
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inisialisasi BottomNavigationView
        val navView: BottomNavigationView = binding.navView

        // Menyiapkan NavController yang menghubungkan fragment dengan BottomNavigation
        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        // Mendefinisikan set top-level destinations untuk aplikasi
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_dashboard,
                R.id.navigation_notifications
            )
        )

        // Menyiapkan ActionBar dengan NavController (jika diperlukan)
        setupActionBarWithNavController(navController, appBarConfiguration)

        // Menghubungkan BottomNavigationView dengan NavController
        navView.setupWithNavController(navController)
    }

    // Optional: Mengatur kembali fungsi navigasi pada tombol back, jika diperlukan
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}