package com.example.testelistcheckbox

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.testelistcheckbox.adapters.AbstractRecyclerAdapter
import com.example.testelistcheckbox.adapters.ItemAdapter
import com.example.testelistcheckbox.databinding.FragmentFirstBinding
import com.example.testelistcheckbox.helpers.CustomFragment
import com.example.testelistcheckbox.itemlist.ItemList
import com.example.testelistcheckbox.itemlist.SeedingService

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private lateinit var itemAdapter: ItemAdapter
    private lateinit var customFragment: CustomFragment


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        customFragment = CustomFragment(requireActivity())
        var seddingList = SeedingService()

        customFragment.recyclerFragment(requireActivity(), seddingList.retornaListaItens(), onClickParameter = {}, binding.FirstFragment)

//        itemAdapter = ItemAdapter(
//            requireActivity(),
//            seddingList.retornaListaItens(),
//            onCLickItem = object : AbstractRecyclerAdapter.OnClick<ItemList> {
//                override fun onClick(view: View?, item: ItemList, position: Int) {
//                    item.listaItens?.forEach {
//
//                    }
//                }
//            })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}