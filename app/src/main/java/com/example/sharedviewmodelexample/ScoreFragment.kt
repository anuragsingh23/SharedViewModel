package com.example.sharedviewmodelexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.sharedviewmodelexample.databinding.FragmentCountBinding
import com.example.sharedviewmodelexample.databinding.FragmentScoreBinding


class ScoreFragment : Fragment() {
    private  var _mBinding : FragmentScoreBinding? = null
    private val mBinding get() = _mBinding!!

    private val sharedViewModel : SharedViewModel by lazy {
        ViewModelProvider(this).get(SharedViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _mBinding = FragmentScoreBinding.inflate(layoutInflater,container,false)

        sharedViewModel.score.observe(viewLifecycleOwner, Observer {
            mBinding.tvScore.text = it.toString()
        })

        mBinding.tvScore.text = sharedViewModel.score.toString()

        return mBinding.root
    }

}