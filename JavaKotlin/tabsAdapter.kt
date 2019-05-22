package com.rd_boost.me.booster

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class tabsAdapter: FragmentStatePagerAdapter {
    var nbt:Int? = null

    constructor(fm:FragmentManager,nbt:Int) : super(fm) {
        this.nbt=nbt
    }
    override fun getItem(position: Int): Fragment {
        when(position){
            0->{return allApps()}
            1->{return boostApps()}
            else->{return allApps()}
        }
    }

    override fun getCount(): Int {
        return nbt!!
    }

    override fun getPageTitle(position: Int):CharSequence{
        when(position){
            0->return "Your Apps"
            1->return "Boost"
            else->return ""
        }
    }

}