package com.example.eko.clubfootball

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import org.jetbrains.anko.*


class KetActivity : AppCompatActivity() {

    companion object {
        val POSITIONEXTRA = "position_extra"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent : Intent = intent
        val list   = intent.getParcelableExtra<Item>(POSITIONEXTRA)
        KetActivityUI(list).setContentView(this)

    }

    class KetActivityUI(var list: Item) : AnkoComponent<KetActivity> {

        @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
        override fun createView(ui: AnkoContext<KetActivity>) = with(ui){
            var position = 0
            linearLayout {
                orientation = LinearLayout.VERTICAL
                lparams(matchParent, matchParent)

                imageView{
                    id =R.id.image
                    Glide.with(this).load(list.image).into(this)
                    padding = dip(10)

                    this@linearLayout.gravity = Gravity.CENTER_HORIZONTAL
                }.lparams(dip(80), dip(80))

                textView{
                    id = R.id.name
                    text = list.name
                    textSize = sp(10).toFloat()
                    gravity = Gravity.CENTER_HORIZONTAL
                    padding = dip(10)
                }

                textView{
                    id = R.id.keterangan
                    text = list.keterangan
                    gravity = Gravity.CENTER_HORIZONTAL
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                    padding = dip(10)
                }

            }
        }

    }
}



