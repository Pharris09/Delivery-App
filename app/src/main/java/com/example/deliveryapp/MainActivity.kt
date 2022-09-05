package com.example.deliveryapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceFragmentCompat
import com.example.deliveryapp.databinding.ActivityMainBinding
import com.example.deliveryapp.ui.HomeFragment
import com.example.deliveryapp.ui.PanierFragment
import com.example.deliveryapp.ui.ParcourirFragment
import com.example.deliveryapp.ui.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView



class MainActivity : AppCompatActivity() {

    private lateinit var currentFragment : Fragment
    private lateinit var bottomNavView : BottomNavigationView
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        bottomNavView = binding.navigationBarMainActivity
        bottomNavView.setOnNavigationItemSelectedListener(navListener)

    }
    private val navListener = BottomNavigationView.OnNavigationItemSelectedListener{
        when(it.itemId){
            R.id.navigation_home -> {
                currentFragment = HomeFragment()
            }
            R.id.navigation_parcourir -> {
                currentFragment = ParcourirFragment()
            }
            R.id.navigation_panier -> {
                currentFragment = PanierFragment()
            }
            R.id.navigation_settings -> {
                currentFragment = SettingsFragment.SettingsFragment()
            }
        }
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame,currentFragment)
            commit()
        }
        true
    }

}
