package com.example.learn.DataBingTest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.learn.R
import com.example.learn.databinding.ActivityDataBingBinding
import com.example.learn.databinding.ViewstubTestBinding

class DataBingActivity : AppCompatActivity() {

    private var binding: ActivityDataBingBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_bing)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_bing)

        // include 调用方法
        binding?.testColor?.third?.text = "00asdfasdfasdf"

        // 常规调用
        binding?.first?.text = "123123"
        binding?.second?.text = "234234"

        // viewStub调用
        binding?.testViewStub?.setOnInflateListener { _, inflated ->
            val viewStubBinding = DataBindingUtil.bind<ViewstubTestBinding>(inflated)
            viewStubBinding?.forth?.text = "345345"
        }

        // 当 viewStub inflate 后，ViewStubProxy 的 setOnInflateListener 无法获取到 ViewStub 对象。
        binding?.testViewStub?.viewStub?.inflate()
    }
}
