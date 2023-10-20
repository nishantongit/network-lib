package com.example.androidrnd.presenter.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.androidrnd.R
import com.example.androidrnd.base.di.ViewModelFactory
import com.example.androidrnd.databinding.FragmentEmployeeListBinding
import com.example.androidrnd.presenter.di.FeatureComponent
import com.example.androidrnd.presenter.viewmodel.EmployeeListVIewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class EmployeeLIstFragment : Fragment() {

    private var _binding: FragmentEmployeeListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    lateinit var viewModel :EmployeeListVIewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FeatureComponent.init(requireContext()).inject(this)
         viewModel = ViewModelProvider(this, viewModelFactory)[EmployeeListVIewModel::class.java]

        lifecycleScope.launch {
            viewModel.onLoad()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentEmployeeListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}