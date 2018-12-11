package com.nkmr.myultraviewpager

import android.graphics.Color
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

/**
 * Created by mikeafc on 15/11/26.
 */
class UltraPagerAdapter(private val isMultiScr: Boolean) : PagerAdapter() {

    override fun getCount(): Int {
        return 5
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    // 表示するアイテムを返す
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val linearLayout = LayoutInflater.from(container.context).inflate(R.layout.layout_child, null) as LinearLayout
        //new LinearLayout(container.getContext());

        linearLayout.id = R.id.item_id
        when (position) {
            0 -> linearLayout.setBackgroundColor(Color.parseColor("#2196F3"))
            1 -> linearLayout.setBackgroundColor(Color.parseColor("#673AB7"))
            2 -> linearLayout.setBackgroundColor(Color.parseColor("#009688"))
            3 -> linearLayout.setBackgroundColor(Color.parseColor("#607D8B"))
            4 -> linearLayout.setBackgroundColor(Color.parseColor("#F44336"))
        }
        container.addView(linearLayout)
        //        linearLayout.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 180, container.getContext().getResources().getDisplayMetrics());
        //        linearLayout.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 400, container.getContext().getResources().getDisplayMetrics());
        return linearLayout
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as LinearLayout
        container.removeView(view)
    }
}
