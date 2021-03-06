package com.example.googrydrawerlayoutlesson

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.DrawerLayout
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawer_root.addDrawerListener(object :
            DrawerLayout.DrawerListener{

            override fun onDrawerStateChanged(newState: Int) {
                when (newState){
                    DrawerLayout.STATE_IDLE -> {
                        Log.d("googry", "DrawerLayout.STATE_IDLE")
                    }
                    DrawerLayout.STATE_DRAGGING -> {
                        Log.d("googry", "DrawerLayout.STATE_DRAGGING")
                    }
                    DrawerLayout.STATE_SETTLING -> {
                        Log.d("googry", "DrawerLayout.STATE_SETTLING")
                    }
                }
            }

            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                Log.d("googry", "slideOffset "+slideOffset)
                // 밀기
                when (drawerView.id){
                    R.id.frame_left_side -> {
                        constraint_main_content.translationX = slideOffset * constraint_main_content.width / 2
                    }
                    R.id.frame_right_side -> {
                        constraint_main_content.translationX = -slideOffset * constraint_main_content.width / 2
                    }
                }
                // 회전
                when (drawerView.id){
                    R.id.frame_left_side -> {
                        constraint_main_content.rotationY = slideOffset * 180;
                    }
                    R.id.frame_right_side -> {
                        constraint_main_content.rotationY = -slideOffset * 180;
                    }
                }
                // 크기 변경
                when (drawerView.id){
                    R.id.frame_left_side -> {
                        constraint_main_content.scaleX = (1 - slideOffset * 0.2).toFloat()
                        constraint_main_content.scaleY = (1 - slideOffset * 0.2).toFloat()
                    }
                    R.id.frame_right_side -> {
                        constraint_main_content.scaleX = (1 - slideOffset * 0.2).toFloat()
                        constraint_main_content.scaleY = (1 - slideOffset * 0.2).toFloat()
                    }
                }
            }

            override fun onDrawerClosed(drawerView: View) {
                Log.d("googry", "Drawer 닫혔을 때")
            }

            override fun onDrawerOpened(drawerView: View) {
                Log.d("googry", "Drawer 열렸을 때")
            }
        })

        drawer_root.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)

        button_open_left.setOnClickListener{
            drawer_root.openDrawer(frame_left_side)
        }
        button_open_left_non_animate.setOnClickListener{
            drawer_root.openDrawer(frame_left_side, false)
        }

        button_open_right.setOnClickListener{
            drawer_root.openDrawer(frame_right_side)
        }
        button_open_right_non_animate.setOnClickListener{
            drawer_root.openDrawer(frame_right_side, false)
        }
    }
}
