package com.example.stepper


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupStepView()
        setupViewPager()
        setupButtons()
    }

    private fun setupStepView(){
        stepView.state
             // You should specify only stepsNumber or steps array of strings.
            // In case you specify both steps array is chosen.
            .steps(listOf("First Step", "Second Step", "Third Step")) // You should specify only steps number or steps array of strings.
            // In case you specify both steps array is chosen.
            .stepsNumber(3)
            .animationDuration(resources.getInteger(android.R.integer.config_shortAnimTime))
            .commit()

        stepView.setOnStepClickListener { position ->
            viewPager.setCurrentItem(position, false)
        }

    }

    private fun setupViewPager(){
        viewPager.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        viewPager.registerOnPageChangeCallback(
                object : ViewPager2.OnPageChangeCallback(){

                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        stepView.go(position, true)
                        setButtons(position)

                    }

                }
        )

    }

    private fun setupButtons(){

        backButton.setOnClickListener{
            viewPager.setCurrentItem(viewPager.currentItem-1, false)
        }

        nextButton.setOnClickListener{
            viewPager.setCurrentItem(viewPager.currentItem+1, false)
        }

    }

    private fun setButtons(position:Int){
        when(position){
            0 -> {
                backButton.visibility = View.INVISIBLE
                nextButton.visibility = View.VISIBLE
            }
            1->{
                backButton.visibility = View.VISIBLE
                nextButton.visibility = View.VISIBLE
            }
            2 -> {
                backButton.visibility = View.VISIBLE
                nextButton.visibility = View.INVISIBLE
            }
        }
    }


}