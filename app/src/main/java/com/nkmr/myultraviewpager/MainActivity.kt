package com.nkmr.myultraviewpager

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.util.TypedValue
import com.tmall.ultraviewpager.UltraViewPager
import android.support.v4.view.PagerAdapter
import com.tmall.ultraviewpager.transformer.UltraDepthScaleTransformer


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ウルトラViewPagerを表示
        val ultraViewPager = findViewById(R.id.ultra_viewpager) as UltraViewPager
        ultraViewPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL)

        val adapter = UltraPagerAdapter(false)
        ultraViewPager.adapter = adapter

        // 状況表示領域を画面下に設置
        ultraViewPager.initIndicator()
        ultraViewPager.indicator
            .setOrientation(UltraViewPager.Orientation.HORIZONTAL)
            .setFocusColor(Color.GREEN)
            .setNormalColor(Color.WHITE)
            .setRadius(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5f, resources.displayMetrics).toInt())
        ultraViewPager.indicator.setGravity(Gravity.CENTER_HORIZONTAL or Gravity.BOTTOM)
        ultraViewPager.indicator.build()

        // カバーフロー風に表示
        ultraViewPager.setPageTransformer(false, UltraDepthScaleTransformer())
        // 複数のアイテムを領域に表示するか
        // 0 ~ 1 : 大きければセンター画像を大きく表示
        ultraViewPager.setMultiScreen(0.65f)
        // 無限にスクロール可能か
        ultraViewPager.setInfiniteLoop(false)
        // 1.0: 縦横比を保つ
        ultraViewPager.setItemRatio(1.0)
        // 自動でスクロールするか
        ultraViewPager.setAutoScroll(0)
        //
        ultraViewPager.setAutoMeasureHeight(true)
    }
}

