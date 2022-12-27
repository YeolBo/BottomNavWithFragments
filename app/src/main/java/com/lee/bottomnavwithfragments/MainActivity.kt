package com.lee.bottomnavwithfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.navigation.NavigationBarView
import kotlinx.android.synthetic.main.activity_main.*

// NavigationBarView.OnItemSelectedListener
class MainActivity : AppCompatActivity(){

    // 멤버 변수
    private lateinit var homeFragment: HomeFragment
    private lateinit var rankingFragment: RankingFragment
    private lateinit var profileFragment: ProfileFragment

    companion object{
        const val TAG: String = "로그"
    }

    // 화면이 메모리에 올라갔을 때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 레이아웃과 연결
        setContentView(R.layout.activity_main)
        
        Log.d(TAG, "MainActivity - onCreate() called")

        bottom_nav.setOnItemSelectedListener(onBottomNavItemSelectedListener)

        homeFragment = HomeFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.fragment_frame, homeFragment).commit()

    }

    // 바텀네비게이션 아이템 클릭리스너 설정
    private val onBottomNavItemSelectedListener = NavigationBarView.OnItemSelectedListener{
        
        when(it.itemId){
            R.id.menu_hoem -> {
                Log.d(TAG, "MainActivity - 홈 버튼 클릭")
                homeFragment = HomeFragment.newInstance()
                // supportFragmentManager = Fragment 관리
                supportFragmentManager.beginTransaction().replace(R.id.fragment_frame, homeFragment).commit()
            }
            R.id.menu_ranking -> {
                Log.d(TAG, "MainActivity - 랭킹 버튼 클릭")
                rankingFragment = RankingFragment.newInstance()
                // supportFragmentManager = Fragment 관리
                supportFragmentManager.beginTransaction().replace(R.id.fragment_frame, rankingFragment).commit()
            }
            R.id.menu_profile -> {
                Log.d(TAG, "MainActivity - 프로필 버튼 클릭")
                profileFragment = ProfileFragment.newInstance()
                // supportFragmentManager = Fragment 관리
                supportFragmentManager.beginTransaction().replace(R.id.fragment_frame, profileFragment).commit()
            }
        }

        true
    }

//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        Log.d(TAG, "MainActivity - onNavigationItemSelected() called")
//
//        when(item.itemId){
//            R.id.menu_hoem -> {
//                Log.d(TAG, "MainActivity - 홈 버튼 클릭")
//            }
//            R.id.menu_ranking -> {
//                Log.d(TAG, "MainActivity - 랭킹 버튼 클릭")
//            }
//            R.id.menu_profile -> {
//                Log.d(TAG, "MainActivity - 프로필 버튼 클릭")
//            }
//        }
//
//        return  true
//    }

}